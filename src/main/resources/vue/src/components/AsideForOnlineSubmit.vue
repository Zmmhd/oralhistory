<template>
  <el-menu router class="menu" text-color="#F0FFFF" active-text-color="#ADD8E6" default-active="/submit">
    <el-menu-item index="/submit">
      <el-icon>
        <Coffee/>
      </el-icon>
      在线提交
    </el-menu-item>
    <el-menu-item index="/review">
      <el-icon>
        <ColdDrink/>
      </el-icon>
      审核查询
    </el-menu-item>
  </el-menu>
</template>

<script>
import {Coffee, ColdDrink} from '@element-plus/icons-vue'
export default {
  name: "AsideForOnlineSubmit",
  components: {
    Coffee,
    ColdDrink
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
