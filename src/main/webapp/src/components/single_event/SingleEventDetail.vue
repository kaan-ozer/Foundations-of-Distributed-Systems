<template>
  <div class="event">
    <div class="container">
      <div class="row mb-5 mt-3">
        <h1>{{ selectedEvent.topicLong}}</h1>
      </div>
      <dl class="row">
        <dt class="col-sm-3">institution</dt>
        <dd class="col-sm-9">{{ selectedEvent.institution }}</dd>
      </dl>
      <hr>
      <dl class="row">
        <dt class="col-sm-3">lecturer</dt>
        <dd class="col-sm-9">{{ selectedEvent.lecturer }}</dd>
      </dl>
      <hr>
      <dl class="row">
        <dt class="col-sm-3">address</dt>
        <dd class="col-sm-9">{{ selectedEvent.address }}</dd>
      </dl>
      <hr>
      <div class="row">
        <dt class="col-sm-3">location</dt>
        <div class="col-sm-9">
          {{ selectedEvent.location }}
        </div>
      </div>
      <hr>
      <div class="row">
        <dt class="col-sm-3">startDateAndTime</dt>
        <div class="col-sm-9">
          {{ selectedEvent.startDateAndTime }}
        </div>
      </div>
      <hr>
      <div class="row">
        <dt class="col-sm-3">endDateAndTime</dt>
        <div class="col-sm-9">
          {{ selectedEvent.endDateAndTime }}
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: "EventDetail",
  components: {},
  computed: {
    ...mapState(['selectedEvent'])
  }
}
</script>

<style scoped>
.event {
  display: flex;
}
</style>
