<template>
  <div style="display: flex;">
    <AsideForOnlineSubmit/>
    <router-view style="flex: 1;"/>
  </div>
</template>

<script>
import AsideForOnlineSubmit from "@/components/AsideForOnlineSubmit";
export default {
  name: "OnlineSubmit",
  components: {
    AsideForOnlineSubmit
  }
}
</script>

<style scoped>

</style>