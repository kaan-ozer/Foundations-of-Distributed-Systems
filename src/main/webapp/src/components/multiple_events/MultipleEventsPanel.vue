<template>
  <div class="multipleeventsspanel">
    <div>
      <MultipleEventsSearchDialog/>
      <MultipleEvents/>
    </div>
    <MultipleEventsButton/>
  </div>
</template>

<script>
import MultipleEvents from "@/components/multiple_events/MultipleEvents.vue";
import MultipleEventsSearchDialog from "@/components/multiple_events/MultipleEventsSearchDialog";
import MultipleEventsButton from "@/components/multiple_events/MultipleEventsButton";

export default {
  name: "MultipleEventsPanel",
  components: {MultipleEventsButton, MultipleEventsSearchDialog, MultipleEvents},
}
</script>

<style scoped>
.multipleeventsspanel {
  flex-basis: 30%;
  background: #343a40;
  color: white;
  padding: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;

}
</style>
