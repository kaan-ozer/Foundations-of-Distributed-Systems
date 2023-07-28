<template>
  <div class="multipleeventssearchdialog mb-4">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Search events ..."
             v-model="search" @keyup.enter="startSearch">
      <div class="input-group-append me-2">
        <button class="btn btn-secondary" type="button" @click="startSearch">
          <i class="fa fa-search"></i>
        </button>
      </div>
      <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          {{ selectedOrder || 'Order' }} <!-- Display the selected order or 'Order' if none is selected -->
        </button>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#" @click="selectOrder('date')">ascending date</a></li>
          <li><a class="dropdown-item" href="#" @click="selectOrder('-date')">descending date</a></li>
          <li><a class="dropdown-item" href="#" @click="selectOrder('topic')">ascending topic</a></li>
          <li><a class="dropdown-item" href="#" @click="selectOrder('-topic')">descending topic</a></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MultipleEventsSearchDialog",
  data: function () {
    return {
      search: "",
      selectedOrder: "", // Data property to store the selected order
    }
  },
  methods: {
    startSearch: function () {
      // Dispatch your action with the selectedOrder
      this.$store.dispatch("getAllEvents",{ searchKey: this.search, orderKey: this.selectedOrder } );
    },
    selectOrder: function (order) {
      // Update the selectedOrder when a dropdown item is clicked
      this.selectedOrder = order;
      this.startSearch()
    }
  }
}
</script>

<style scoped>
/* Add your custom styles here */
</style>