import Vue from 'vue'
import Vuex from 'vuex'
import network from '@/network/network';

const parse = require('parse-link-header');

Vue.use(Vuex)

export const store = new Vuex.Store({
    state: {
        events: [],
        selectedEvent: {},
        editMode: false,
        createUrl: undefined,
        editUrl: undefined,
        deleteUrl: undefined,
        nextUrl: undefined,
        prevUrl: undefined,
        clearSearchField: false
    },
    mutations: {
        SET_EVENTS(state, {events, createUrl, nextUrl, prevUrl}) {
            state.events = events;
            state.selectedProject = {};
            state.clearSearchField = false;
            state.createUrl = createUrl;
            state.prevUrl = prevUrl;
            state.nextUrl = nextUrl;
        },
        SET_EVENT(state, {event, editUrl, deleteUrl}) {
            state.selectedEvent = event;
            state.editUrl = editUrl;
            state.deleteUrl = deleteUrl;
            state.clearSearchField = true;
            state.editMode = false;
        },
        SET_EDIT_MODE(state, editMode) {
            state.editMode = editMode;
            if (editMode == false && state.selectedProject.id == 0) {
                state.selectedProject = {};
            }
        }
    },
    actions: {

            async getAllEvents(context,payload) {

                const search = payload.searchKey;
                const order = payload.orderKey;

                const dispatcherResponse = await network.getDispatcherState();
                const allLinks = parse(dispatcherResponse.headers.link);

                let url = null;


                if (search === undefined && order === undefined) {
                    url = allLinks['getAllEventsBySearchWithOrder'].url.replace("{SEARCH}", "");
                    url = url.replace("topic%2C-topic%2Cdate%2C-date", "topic"); // Update the url with the new value
                } else if(search === undefined && order !== undefined) {
                    url = allLinks['getAllEventsBySearchWithOrder'].url.replace("{SEARCH}", "");
                    url = url.replace("topic%2C-topic%2Cdate%2C-date", order); // Update the url with the new value
                } else if (search !== undefined) {
                    url = allLinks['getAllEventsBySearchWithOrder'].url.replace("{SEARCH}", search);
                    url = url.replace("topic%2C-topic%2Cdate%2C-date", order); // Update the url with the new value
                    if (!isNaN(search.charAt(0))) {
                        url = allLinks['getAllEventsByDateWithOrder'].url.replace("{DATE}", search);
                        url = url.replace("topic%2C-topic%2Cdate%2C-date", order); // Update the url with the new value
                    }
                }



                console.log(search,order, url);
                await context.dispatch('loadPage', url);
            },
        async loadPage(context,url) {
            const getCollectionResponse = await network.getAllEventsState(url);
            const nextRelations = parse(getCollectionResponse.headers.link);

            context.commit("SET_EVENTS", {
                events: getCollectionResponse.data,
                createUrl: nextRelations['createEvent'],
                nextUrl: nextRelations['next'],
                prevUrl: nextRelations['prev']
            });
        },
        async loadNextPage(context) {
            await context.dispatch('loadPage', this.state.nextUrl.url);
        },
        async loadPrevPage(context) {
            await context.dispatch('loadPage', this.state.prevUrl.url);
        },
        async getSingleEvent(context, url) {
            const response = await network.getSingleEventState(url);
            console.log(response)
            const nextRelations = parse(response.headers.link);
            console.log(nextRelations)
            context.commit("SET_EVENT", {
                event: response.data,
                editUrl: nextRelations['updateEvent'],
                deleteUrl: nextRelations['deleteEvent'],
            });
        },
        async switchToEditMode(context) {
            context.commit('SET_EDIT_MODE', true);
        },
        async switchToDetailMode(context) {
            context.commit('SET_EDIT_MODE', false);
        }
    },
    getters: {
        isCreateAllowed(state) {
            return state.createUrl != undefined;
        },
        isProjectEditable(state) {
            return state.editUrl != undefined;
        },
        isNextPageAvailable(state) {
            return state.nextUrl != undefined;
        },
        isPrevPageAvailable(state) {
            return state.prevUrl != undefined;
        }
    }
})
