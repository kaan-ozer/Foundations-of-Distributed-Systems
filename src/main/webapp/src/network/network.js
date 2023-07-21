import axios from 'axios';

const httpClient = axios.create({
    headers: {
        "Accept": "application/json",
    }
});

export const getDispatcherState = (url) => httpClient.get(url);
export const getAllEventsState = (url) => httpClient.get(url);
export const getSingleEventState = (url) => httpClient.get(url);
export const getAllEventState = (url) => httpClient.get(url);


