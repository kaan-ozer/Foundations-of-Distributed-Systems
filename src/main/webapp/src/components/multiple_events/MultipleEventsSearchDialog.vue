<template>
  <div class="multipleeventssearchdialog mb-4">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Search events ..."
             v-model="search" @keyup.enter="startSearch">
      <div class="input-group-append">
        <button class="btn btn-secondary" type="button" @click="startSearch">
          <i class="fa fa-search"></i>
        </button>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "MultipleEventsSearchDialog",
  data: function () {
    return {
      search: ""
    }
  },
  methods: {
    startSearch: function () {
      this.$store.dispatch("getAllEvents", this.search);
    }
  }
}
</script>

<style scoped>

</style>
