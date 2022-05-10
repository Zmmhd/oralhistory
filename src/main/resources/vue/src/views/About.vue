<template>
  <hr>
  <hr>
  <i>19122169卜晟原</i>
  <hr>
  <hr>
  <div>
    <el-button style="color: #0AB1CE" type="info" @click="adminRequest">管理员登录</el-button>
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
  name: "About",
  data() {
    return {
      password: "",
      dialogVisible: false
    }
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

</style>