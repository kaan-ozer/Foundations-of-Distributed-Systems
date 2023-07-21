<template>

  <div v-on:click="handleClick">
    <EventTopicLong>{{ topicLong }}</EventTopicLong>

  </div>
</template>

<script>
import EventTopicLong from "@/components/events/EventTopicLong.vue";

export default {
  name: "EventListWithClickListener",
  components: {EventTopicLong},
  props: {
    topicLong: String,
  },
  methods: {
    handleClick: function () {
      this.$emit('projectSelected');
    }
  }
}
</script>

<style scoped>

</style>