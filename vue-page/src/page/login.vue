<template>
  <div class="login_page fillcontain">
    <transition name="form-fade" mode="in-out">
      <section class="form_contianer" v-show="showLogin">
        <div class="manage_tip">
          <p>实验室管理系统</p>
        </div>
        <el-form :model="loginForm" :rules="rules" ref="loginForm">
          <el-form-item prop="username">
            <el-input v-model="loginForm.phone" placeholder="账号"
              ><span>dsfsf</span></el-input
            >
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              type="password"
              placeholder="密码"
              v-model="loginForm.pwd"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-radio-group v-model="radio">
              <el-radio :label="1">学生</el-radio>
              <el-radio :label="2">教师</el-radio>
              <el-radio :label="3">管理员</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="login" class="submit_btn"
              >登录</el-button
            >
            <el-button
              type="primary"
              @click="register"
              class="submit_btn"
              v-if="radio != 3"
              >注册</el-button
            >
          </el-form-item>
        </el-form>
      </section>
    </transition>
  </div>
</template>

<script>
import { login } from "@/api/api.js";

export default {
  data() {
    return {
      loginForm: {
        phone: "",
        pwd: ""
      },
      rules: {
        phone: [{ required: true, message: "请输入账号", trigger: "blur" }],
        pwd: [{ required: true, message: "请输入密码", trigger: "blur" }]
      },
      showLogin: true,
      radio: 1
    };
  },
  mounted() {},
  methods: {
    login() {
      login(this.loginForm, this.radio).then(response => {
        if (response.status == "200") {
          //登录成功
          this.$store.dispatch("setUser", this.loginForm);
          this.$store.dispatch("setRole", this.radio);
          this.$message({
            showClose: true,
            message: "登录成功",
            type: "success"
          });
          this.$router.push("/manage");
        } else {
          this.$message({
            showClose: true,
            message: "账号或密码错误",
            type: "error"
          });
        }
      });
    },
    register() {
      switch (this.radio) {
        case 1:
          this.$router.push("/register");
          break;
        case 2:
          this.$router.push("/registerTeacher");
          break;
      }
    }
  },
  watch: {}
};
</script>

<style lang="less" scoped>
@import "../style/mixin";
.login_page {
  background-color: #324057;
}
.manage_tip {
  position: absolute;
  width: 100%;
  top: -100px;
  left: 0;
  p {
    font-size: 34px;
    color: #fff;
  }
}
.form_contianer {
  .wh(320px, 210px);
  .ctp(320px, 210px);
  padding: 25px;
  border-radius: 5px;
  text-align: center;
  background-color: #fff;
  .submit_btn {
    width: 30%;
    font-size: 16px;
  }
}
.tip {
  font-size: 12px;
  color: red;
}
.form-fade-enter-active,
.form-fade-leave-active {
  transition: all 1s;
}
.form-fade-enter,
.form-fade-leave-active {
  transform: translate3d(0, -50px, 0);
  opacity: 0;
}
</style>
