<template>
  <div class="studentprojectdetail">
    <SingleEventDetail/>
    <hr>
    <SingleEventDetailButtons/>
  </div>
</template>

<script>
import SingleEventDetail from "@/components/single_event/SingleEventDetail";
import SingleEventDetailButtons from "@/components/single_event/SingleEventDetailButtons";


export default {
  name: "SingleEventDetailPanel",
  components: {SingleEventDetail, SingleEventDetailButtons}
}
</script>

<style scoped>
.studentprojectdetail {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
</style>
