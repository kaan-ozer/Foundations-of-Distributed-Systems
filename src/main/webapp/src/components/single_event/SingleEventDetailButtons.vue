<template>
  <div class="singleeventbuttons">
<!--    <EditStudentProjectButton/>
    <DeleteStudentProjectButton/>-->
  </div>

</template>

<script>
/*
import EditStudentProjectButton from "@/components/studentproject/StudentProjectEditButton";
import DeleteStudentProjectButton from "@/components/studentproject/StudentProjectDeleteButton";
*/

export default {
  name: "SingleEventDetailButtons",
  components: {/*DeleteStudentProjectButton, EditStudentProjectButton*/}
}
</script>

<style scoped>
.singleeventbuttons {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}
</style>
