<template>
  <div id="time">
    <div style="margin-left: 20px; width: 80%; user-select: none; font-weight: 700;">
      {{ time }}
    </div>
    <div style="flex: 1;">
      <el-button type="info" @click="adminRequest">管理员登录</el-button>
    </div>
  </div>
  <div id="title">
    <!--    <div style="margin-left: 50px;"><i>口述历史</i></div>-->
    <div><img src="@/assets/plum2.0.jpg" alt=""></div>
  </div>
  <div>
    <el-menu router
             default-active="/mainPage"
             mode="horizontal"
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b"
             style="font-weight: 900;"
    >
      <el-menu-item index="/mainPage">主页</el-menu-item>
      <el-sub-menu index="/resourceSort">
        <template #title>资源分类</template>
        <el-menu-item index="/sortByType">资源类型</el-menu-item>
        <el-menu-item index="/sortByProvince">省份</el-menu-item>
        <el-menu-item index="/sortByTheme">主题曲</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="/notice">
        <template #title>口述动态</template>
        <el-menu-item index="/raiseNotice">征集公告</el-menu-item>
        <el-menu-item index="/momentsNotice">建设进程动态</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="/principle">口述规范</el-menu-item>
      <el-menu-item index="/knowledgePicture">知识图谱</el-menu-item>
      <el-sub-menu index="/onlineSubmit">
        <template #title>在线提交</template>
        <el-menu-item index="/submit">在线提交</el-menu-item>
        <el-menu-item index="/review">审核查询</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="/oralMap">口述地图</el-menu-item>
      <el-menu-item index="/about">联系我们</el-menu-item>
      <!--    <div style="height: 35px; margin: auto 0 auto 250px;">-->
      <!--      <el-input v-model="search" placeholder="请输入关键字" style="width: 150px;"/>-->
      <!--      <el-button type="info" style="margin-left: 5px;">查询</el-button>-->
      <!--    </div>-->
    </el-menu>
  </div>

  <el-dialog v-model="dialogVisible" title="管理员登录" width="30%">
    <el-input v-model="password" placeholder="请输入密码" style="width: 80%;"/>
    <template #footer>
      <span>
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="login">确 定</el-button>
      </span>
    </template>
  </el-dialog>

</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      time: "",
      weekInChinese: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
      password: ""
      // search: ""
    }
  },
  created() {
    setInterval(() => {
      let time = new Date();
      let week = time.getDay();
      this.time = time.toLocaleString() + " " + this.weekInChinese[week];
    }, 1000)
  },
  methods: {
    adminRequest() {
      this.password = "";
      this.dialogVisible = true;
    },
    login() {
      if (this.password === "") {
        this.$message({
          type: "warning",
          message: "密码不能为空"
        })
      } else if (this.password === "123") {
        this.dialogVisible = false;
        this.$message({
          type: "success",
          message: "欢迎"
        })
        this.$router.push("/admin")
      } else {
        this.$message({
          type: "warning",
          message: "密码错误"
        })
      }
    }
  }
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
  justify-content: center;
  align-items: center;
}

/*#title {*/
/*  height: 100px;*/
/*  background-color: #DCDCDC;*/
/*  line-height: 100px;*/
/*  color: #545c64;*/
/*  font-weight: bold;*/
/*  font-size: 50px;*/
/*}*/

</style>