<template>
  <div id="time">
    <div style="margin-left: 20px; width: 80%;">
      {{ time }}
    </div>
    <div style="flex: 1;">
      <el-popconfirm title="确定退出吗？" @confirm="$router.push('/')">
        <template #reference>
          <el-button type="info">退出登录</el-button>
        </template>
      </el-popconfirm>
    </div>
  </div>
  <div id="title">
    <div><img src="@/assets/plum2.0.jpg" alt=""></div>
  </div>
  <div>
    <el-menu router
             default-active="/manageResource"
             mode="horizontal"
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b"
    >
      <el-menu-item index="/manageResource">审核管理</el-menu-item>
      <el-sub-menu index="/manageNotice">
        <template #title>通知管理</template>
        <el-menu-item index="/manageRaiseNotice">征集公告</el-menu-item>
        <el-menu-item index="/manageMomentsNotice">建设进程动态</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "HeaderForAdmin",
  data() {
    return {
      time: "",
      weekInChinese: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
    }
  },
  created() {
    setInterval(() => {
      let time = new Date();
      let week = time.getDay();
      this.time = time.toLocaleString() + " " + this.weekInChinese[week];
    }, 1000)
  },
}
</script>

<style scoped>
#time {
  margin: 0;
  height: 50px;
  background-color: #545c64;
  line-height: 50px;
  color: #DCDCDC;
  display: flex;
}
</style>