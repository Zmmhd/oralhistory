<template>
  <div>
    <Header></Header>
    <router-view/>
    <Bottom></Bottom>
  </div>
</template>

<script>

import Header from "@/components/Header"
import Bottom from "@/components/Bottom";

export default {
  name: 'HomeView',
  components: {
    Header,
    Bottom
  }
}
</script>
