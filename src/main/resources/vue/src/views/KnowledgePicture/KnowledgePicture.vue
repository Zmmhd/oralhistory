<template>
  <div style="display: flex;">
    <AsideForKnowledgePicture/>
    <router-view style="flex: 1;"/>
  </div>
</template>

<script>
import AsideForKnowledgePicture from "@/components/AsideForKnowledgePicture";
export default {
  name: "KnowledgePicture",
  components: {
    AsideForKnowledgePicture
  }
}
</script>

<style scoped>

</style>