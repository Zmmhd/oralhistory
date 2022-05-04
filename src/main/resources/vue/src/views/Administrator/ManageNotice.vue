<template>
  <div style="display: flex;">
    <AsideForManageNotice/>
    <router-view style="flex: 1;"/>
  </div>
</template>

<script>
import AsideForManageNotice from "@/components/AsideForAdmin/AsideForManageNotice";

export default {
  name: "ManageNotice",
  components: {
    AsideForManageNotice
  }
}
</script>

<style scoped>

</style>