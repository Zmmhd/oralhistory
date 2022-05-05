<template>
  <el-menu router style="width: 200px; min-height: 100vh; font-weight: 700" default-active="/manageRaiseNotice">
    <el-menu-item index="/manageRaiseNotice">
      <el-icon>
        <IceCream/>
      </el-icon>
      征集公告
    </el-menu-item>
    <el-menu-item index="/manageMomentsNotice">
      <el-icon>
        <IceDrink/>
      </el-icon>
      建设进程动态
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "AsideForManageNotice"
}
</script>

<style scoped>

</style>