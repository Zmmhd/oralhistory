<template>
  <div style="display: flex;">
    <AsideForPrinciple/>
    <router-view style="flex: 1;"/>
  </div>
</template>

<script>
import AsideForPrinciple from "@/components/AsideForPrinciple";
export default {
  name: "Principle",
  components: {
    AsideForPrinciple
  }
}
</script>

<style scoped>

</style>
