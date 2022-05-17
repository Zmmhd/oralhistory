<template>
  <div class="bottom">
    <div class="second-bottom">
      <div class="teleportTitle">传送门</div>
      <div class="teleports">
        <div class="teleport">
          <li @click="$router.push('/mainPage')">主页</li>
          <li @click="$router.push('/themeRelative')">知识图谱</li>
        </div>
        <div class="teleport">
          <li @click="$router.push('/sortByType')">资源分类</li>
          <li @click="$router.push('/submit')">在线提交</li>
        </div>
        <div class="teleport">
          <li @click="$router.push('/raiseNotice')">口述动态</li>
          <li @click="$router.push('/oralMap')">口述地图</li>
        </div>
        <div class="teleport">
          <li @click="$router.push('/principle')">口述规范</li>
          <li @click="login">管理员登录</li>
        </div>
      </div>
    </div>
  </div>

  <el-dialog v-model="dialogVisible" title="管理员登陆" width="30%">
    <el-form :model="form" label-width="120px">
      <el-form-item label="用户名">
        <el-input v-model="form.name" style="width: 80%;"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input type="password" v-model="form.password" style="width: 80%;"/>
      </el-form-item>
      <div style="display:flex; justify-content: center; align-items: center;">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="info" @click="save">确 定</el-button>
      </div>
    </el-form>
  </el-dialog>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Bottom",
  data() {
    return {
      form: {},
      dialogVisible: false
    }
  },
  methods: {
    login() {
      this.form = {};
      this.dialogVisible = true;
    },
    save() {
      console.log(this.form.name, this.form.password)
      if (!this.form.name || !this.form.password) {
        this.$message.error("请输入用户名和密码")
      } else {
        let userInfo = new FormData();
        userInfo.append("name", this.form.name);
        userInfo.append("password", this.form.password);
        request.post("/admin/login", userInfo).then(res => {
          console.log(res);
          console.log(res.data);
          if (res.data === "登录成功") {
            this.$message.success("欢迎你，管理员");
            this.$router.push("/admin");
          }
        }).catch(res => {
          console.log(res)
          if(res.response.status === 400){
            this.$message.error("用户名或密码错误");
          }
        })
      }
    }
  }
}
</script>

<style scoped>
.bottom {
  background-color: #FBD786;
  width: 100%;
  height: 120px;
  box-shadow: 0 0px 10px 5px #FBD786;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
}

.second-bottom {
  width: 80%;
  height: 80px;
}

.teleportTitle {
  font-size: small;
  margin-left: 20px;
  margin-bottom: 5px;
  font-weight: 700;
  user-select: none;
}

.teleports {
  display: flex;
}

.teleport li {
  margin: 5px 30px 5px;
  font-size: smaller;
  list-style: none;
  user-select: none;
  transition: all 0.3s;
}

.teleport li:hover {
  color: #f05053;
  cursor: pointer;
}
</style>
