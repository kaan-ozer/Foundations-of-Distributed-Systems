<template>
  <div class="event">
    <div class="container">
      <div class="row mb-5 mt-3">
        <h1>{{ selectedEvent.topicLong}}</h1>
      </div>
      <dl class="row">
        <dt class="col-sm-3">Topic Short</dt>
        <dd class="col-sm-9">{{ selectedEvent.topicShort }}</dd>
      </dl>
      <hr>
      <dl class="row">
        <dt class="col-sm-3">Institution</dt>
        <dd class="col-sm-9">{{ selectedEvent.institution }}</dd>
      </dl>
      <hr>
      <dl class="row">
        <dt class="col-sm-3">Lecturer</dt>
        <dd class="col-sm-9">{{ selectedEvent.lecturer }}</dd>
      </dl>
      <hr>
      <dl class="row">
        <dt class="col-sm-3">Address</dt>
        <dd class="col-sm-9">{{ selectedEvent.address }}</dd>
      </dl>
      <hr>
      <div class="row">
        <dt class="col-sm-3">Location</dt>
        <div class="col-sm-9">
          {{ selectedEvent.location }}
        </div>
      </div>
      <hr>
      <div class="row">
        <dt class="col-sm-3">Start Date and Time</dt>
        <div class="col-sm-9">
          {{ selectedEvent.startDateAndTime }}
        </div>
      </div>
      <hr>
      <div class="row">
        <dt class="col-sm-3">End Date and Time</dt>
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
