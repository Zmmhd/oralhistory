<template>
  <div style="display: flex;">
    <AsideForResourceSort/>
    <router-view style="flex: 1;"/>
  </div>
</template>

<script>
import AsideForResourceSort from "@/components/AsideForResourceSort";

export default {
  name: "ResourceSort",
  components: {
    AsideForResourceSort
  }
}
</script>

<style scoped>

</style>