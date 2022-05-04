<template>
  <div style="display: flex;">
    <AsideForNotice/>
    <router-view style="flex: 1;"/>
  </div>
</template>

<script>
import AsideForNotice from "@/components/AsideForNotice";
export default {
  name: "Notice",
  components: {
    AsideForNotice
  }
}
</script>

<style scoped>

</style>