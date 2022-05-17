<template>
  <el-menu router class="menu" text-color="#fff" active-text-color="#f05053"  default-active="/principleList">
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
  background-color: #e7ac94;
  font-weight: 700;
}
.el-menu-item:hover {
  background-color: #d1806c !important;
}
</style>
