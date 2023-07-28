<template>
  <div class="multipleeventsbutton">
    <button
        class="btn btn-secondary prevbutton"
        v-if="isPrevPageAvailable"
        @click="prevPage()">Prev page
    </button>
    <button
        class="btn btn-secondary nextbutton"
        v-if="isNextPageAvailable"
        @click="nextPage()">Next page
    </button>



  </div>
</template>

<script>
export default {
  name: "MultipleEventsButton",
  methods: {
    prevPage: function () {
      this.$store.dispatch('loadPrevPage');
    },
    nextPage: function () {
      this.$store.dispatch('loadNextPage');
    }
  },
  computed: {

    isNextPageAvailable() {
      return this.$store.getters.isNextPageAvailable
    },
    isPrevPageAvailable() {
      return this.$store.getters.isPrevPageAvailable
    }
  }


}
</script>

<style scoped>
.multipleeventsbutton {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.prevbutton {
  margin-left: 20px;
}

.nextbutton {
  margin-left: 20px;
}



</style>
