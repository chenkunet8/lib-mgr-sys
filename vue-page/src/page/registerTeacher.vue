<template>
  <div class="login_page fillcontain">
    <transition name="form-fade" mode="in-out">
      <section class="form_register">
        <div class="manage_tip">
          <p>教师注册</p>
        </div>
        <el-form :model="registerForm" :rules="rules" ref="registerForm">
          <el-form-item prop="name">
            <el-input v-model="registerForm.name" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item prop="phone">
            <el-input
              v-model="registerForm.phone"
              placeholder="账号"
            ></el-input>
          </el-form-item>
          <el-form-item prop="post">
            <el-input v-model="registerForm.post" placeholder="级别"></el-input>
          </el-form-item>
          <el-form-item prop="academy">
            <el-input
              v-model="registerForm.academy"
              placeholder="学院"
            ></el-input>
          </el-form-item>
          <el-form-item prop="pwd">
            <el-input
              type="password"
              placeholder="密码"
              v-model="registerForm.pwd"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="register" class="submit_btn"
              >注册</el-button
            >
          </el-form-item>
        </el-form>
      </section>
    </transition>
  </div>
</template>

<script>
import { register } from "@/api/api.js";

export default {
  data() {
    return {
      registerForm: {
        name: "",
        phone: "",
        post: "",
        academy: "",
        pwd: ""
      },
      rules: {
        name: [{ required: true, message: "请输入用户名", trigger: "blur" }],
        phone: [{ required: true, message: "请输入账号", trigger: "blur" }],
        post: [{ required: true, message: "请输入级别", trigger: "blur" }],
        academy: [
          { required: true, message: "请输入学院信息", trigger: "blur" }
        ],
        pwd: [{ required: true, message: "请输入密码", trigger: "blur" }]
      }
    };
  },
  mounted() {},
  methods: {
    register() {
      register(this.registerForm, 2).then(response => {
        if (response.status == "200") {
          //注册成功
          this.$message({
            showClose: true,
            message: "您的注册信息已提交管理员审核",
            type: "success"
          });
          this.$router.push("/");
        } else {
          this.$message({
            showClose: true,
            message: "注册失败" + response.message,
            type: "error"
          });
        }
      });
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
.form_register {
  .wh(320px, 350px);
  .ctp(320px, 350px);
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
