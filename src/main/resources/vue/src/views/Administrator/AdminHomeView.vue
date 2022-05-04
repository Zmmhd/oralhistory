<template>
  <HeaderForAdmin/>
  <router-view/>
</template>

<script>
import HeaderForAdmin from "@/components/HeaderForAdmin";
export default {
  name: "AdminHomeView",
  components: {
    HeaderForAdmin
  }
}
</script>

<style scoped>

</style>