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
          <li @click="$router.push('/principleList')">口述规范</li>
          <li @click="login">管理员登录</li>
        </div>
      </div>
    </div>

    <div class="second-bottom-right">
      <div class="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本网站仅限学术研究，无任何商业用途，若有任何侵权信息，请联系我们删除。</div>
    </div>

    <div class="second-bottom-about">
      联系我们&nbsp;/&nbsp;意见反馈:<br>
      电&nbsp;&nbsp;话:&nbsp;18362803657<br>
      邮&nbsp;&nbsp;箱:&nbsp;cwy3314@163.com<br>
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
  background-color: #4682B4;
  width: 100%;
  height: 120px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #F0FFFF;
  border-top: 2px solid #ffffff;
}

.second-bottom {
  width: 30%;
  height: 80px;
}

.teleportTitle {
  font-size: small;
  font-weight: 700;
  user-select: none;
}

.teleports {
  display: flex;
}

.teleport li {
  margin: 10px 10px;
  font-size: x-small;
  list-style: none;
  user-select: none;
  transition: all 0.2s;
}

.teleport li:hover {
  color: #ADD8E6;
  cursor: pointer;
}

.second-bottom-right {
  padding: 20px;
  width: 30%;
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-right: #cccccc dashed 1px;
  border-left: #cccccc dashed 1px;
}

.right{
  font-size: small;
  user-select: none;
}

.second-bottom-about {
  width: 30%;
  height: 80px;
  font-size: small;
  display: flex;
  justify-content: center;
  align-items: center;
  user-select: none;
}
</style>
