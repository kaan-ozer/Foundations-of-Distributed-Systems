<template>
  <div id="app">
    <MultipleEventsApp/>
  </div>
</template>

<script>
import MultipleEventsApp from "@/components/main/MultipleEventsApp.vue";

export default {
  name: 'App',
  components: {
    MultipleEventsApp,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
</style>
