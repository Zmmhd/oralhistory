<template>
  <el-menu router class="menu" text-color="#fff" active-text-color="#f05053" default-active="/sortByType">
    <el-menu-item index="/sortByType">
      <el-icon>
        <Lollipop/>
      </el-icon>
      资源类型
    </el-menu-item>
    <el-menu-item index="/sortByProvince">
      <el-icon>
        <Cherry/>
      </el-icon>
      省份
    </el-menu-item>
    <el-menu-item index="/sortByTheme">
      <el-icon>
        <Chicken/>
      </el-icon>
      主题
    </el-menu-item>
  </el-menu>
</template>

<script>
import {Lollipop, Cherry, Chicken} from '@element-plus/icons-vue'

export default {
  name: "AsideForResourceSort",
  components: {
    Lollipop,
    Cherry,
    Chicken
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
