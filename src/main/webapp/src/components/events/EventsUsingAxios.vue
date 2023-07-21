<template>

  <div>
    <EventListWithClickListener
        v-for="p in projects"
        v-bind:key="p.id"
        v-bind:topic-long="p.topicLong"
        v-on:projectSelected="selectProject(p)"/>
  </div>
</template>

<script>
import axios from 'axios';
import EventListWithClickListener from "@/components/events/EventListWithClickListener.vue";

export default {
  name: "EventsUsingAxios",
  components: {EventListWithClickListener},
  data: function () {
    return {
      projects: []
    }
  },
  methods: {
    selectProject: function (project) {
      console.log("Click on project: " + project.name)
    }
  },
  /* @@@START:"Axios.html" */
  async mounted() {
    const httpClient = axios.create({
      headers: {
        "Accept": "application/json",
      }
    });
    const response = await httpClient.get("http://localhost:8080/exam03/api/events")
    this.projects = response.data;
  }
  /* @@@END */
}
</script>

<style scoped>

</style>