<template>
  <el-menu router class="menu" text-color="#F0FFFF" active-text-color="#ADD8E6" default-active="/sortByType">
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
  background-color: #4682B4;
  font-weight: 700;
}
.el-menu-item:hover {
  background-color: #486067 !important;
}
</style>
