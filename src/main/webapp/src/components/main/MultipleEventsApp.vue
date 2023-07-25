<template>
  <div class="multipleeventssapp">
    <MultipleEventsPanel/>
    <SingleEventPanel/>
  </div>
</template>

<script>
import MultipleEventsPanel from "@/components/multiple_events/MultipleEventsPanel.vue";
import SingleEventPanel from "@/components/single_event/SingleEventPanel.vue";

export default {
  name: "MultipleEventsApp",
  components: {MultipleEventsPanel,SingleEventPanel}
}
</script>

<style scoped>
.multipleeventssapp {
  flex: 1;
  display: flex;
  flex-direction: row;
  align-items: stretch;
  min-width: 100%;
}
</style>
