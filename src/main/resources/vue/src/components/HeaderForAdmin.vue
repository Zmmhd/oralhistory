<template>
  <div class="timeAndLogin">
    <div class="time">
      {{ time }}
    </div>
  </div>
  <div style="height: 95px;"><img src="@/assets/plum2.0.jpg" alt=""></div>
  <div>
    <el-menu router
             default-active="/manageResource"
             mode="horizontal"
             background-color="#e7ac94"
             text-color="#fff"
             active-text-color="#f05053"
             style="font-weight: 900;"
    >
      <el-menu-item index="/manageResource">审核管理</el-menu-item>
      <el-sub-menu index="/manageNotice">
        <template #title>通知管理</template>
        <el-menu-item index="/manageRaiseNotice">征集公告</el-menu-item>
        <el-menu-item index="/manageMomentsNotice">建设进程动态</el-menu-item>
      </el-sub-menu>

      <div style="margin: auto 20px auto 800px;">
        <el-popconfirm title="确定退出吗？" @confirm="$router.push('/')">
          <template #reference>
            <el-button type="info">退出登录</el-button>
          </template>
        </el-popconfirm>
      </div>
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
      dialogVisible: false
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
.timeAndLogin {
  margin: 0;
  height: 30px;
  /*background-color: #f05053;*/
  background: #e1eec3; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #e7ac94, #e1eec3); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #e7ac94, #e1eec3); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  line-height: 30px;
  color: #fff;
}

.time {
  margin: auto 0 auto 20px;
  user-select: none;
}

.el-menu-item:hover {
  background-color: #d1806c !important;
}


img {
  width: 100%;
  overflow: hidden;
}
</style>