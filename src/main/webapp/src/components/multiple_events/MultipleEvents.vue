<template>
  <div class="events">
    <div v-for="e in events" v-bind:key="e.id" @click="selectRow(e)">
      <div class="event rounded-3 mb-3 px-4 py-3">
        <span>{{ e.topicLong }}</span>&nbsp;<span>({{(e.topicShort)}})</span>
      </div>
    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: "MultipleEvents",
  mounted() {
    this.$store.dispatch("getAllEvents", "");
  },
  computed: {
    ...mapState(['events'])
  },
  methods: {
    selectRow: function (event) {
      this.$store.dispatch("getSingleEvent", event.self.href);
    }
  }
}
</script>

<style scoped>
.events {
  float: left;
  clear: both;
}

.events {
  font-size: 24pt;
  margin-bottom: 10px;
 /* background-color: #343a40;*/
}

.event{
  font-size: 18pt;
  padding: 10px;
  background-color: #212529;
  color: white;
}
</style>
