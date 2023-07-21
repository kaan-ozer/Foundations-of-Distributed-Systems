<template>
  <div id="app">
    <events-using-axios></events-using-axios>
  </div>
</template>

<script>

import EventsUsingAxios from "@/components/events/EventsUsingAxios.vue";

export default {
  name: 'App',
  components: {
    EventsUsingAxios


  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
