<template>
  <div class="studentprojectpanel">
    <div v-if="isEventSelected()">
      <div>
        <SingleEventDetailPanel/>
      </div>
    </div>
  </div>
</template>

<script>
import {mapState} from "vuex";
import SingleEventDetailPanel from "@/components/single_event/SingleEventDetailPanel";

export default {
  name: "SingleEventPanel",
  components: {
    SingleEventDetailPanel,
  },
  methods: {
    isEventSelected() {
      return Object.keys(this.selectedEvent).length != 0
    }
  },
  computed: {
    ...mapState(['editMode', 'selectedEvent'])
  }
}
</script>

<style scoped>
.studentprojectpanel {
  flex-basis: 70%;
  background: #ced4da;
  padding: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

</style>
