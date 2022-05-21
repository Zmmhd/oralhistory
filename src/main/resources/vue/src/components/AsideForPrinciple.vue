<template>
  <el-menu router class="menu" text-color="#F0FFFF" active-text-color="#ADD8E6" default-active="/principleList">
    <el-menu-item index="/principleList">
      <el-icon>
        <Bowl/>
      </el-icon>
      口述规范
    </el-menu-item>
  </el-menu>
</template>

<script>
import {Bowl} from '@element-plus/icons-vue'
export default {
  name: "AsideForPrinciple",
  components: {
    Bowl
  }
}
</script>

<style scoped>
.menu{
  width: 200px;
  min-height: 100vh;
  background-color: #4682B4;
  font-weight: 700;
}
.el-menu-item:hover {
  background-color: #486067 !important;
}
</style>
