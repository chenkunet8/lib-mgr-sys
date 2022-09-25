<template>
  <div>
    <head-top></head-top>
    <div
      class="manage_tip"
      style="margin-top: 20px;margin-left: 30px;font-size: 20px;"
    >
      <p>设备录入</p>
    </div>
    <el-form
      :model="registerForm"
      :rules="rules"
      ref="registerForm"
      style="width:50%;margin:30px;"
    >
      <el-form-item prop="name">
        <el-input v-model="registerForm.name" placeholder="设备名称"></el-input>
      </el-form-item>
      <el-form-item prop="model">
        <el-input
          v-model="registerForm.model"
          placeholder="设备型号"
        ></el-input>
      </el-form-item>
      <el-form-item prop="type">
        <el-select
          v-model="registerForm.type"
          placeholder="请选择设备型号"
          prop="type"
        >
          <el-option label="路由器" value="1"></el-option>
          <el-option label="电脑" value="2"></el-option>
          <el-option label="笔记本" value="3"></el-option>
          <el-option label="电子元件" value="4"></el-option>
          <el-option label="机械" value="5"></el-option>
          <el-option label="其他" value="6"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="owner">
        <el-select
          v-model="registerForm.owner"
          placeholder="请选择设备归属"
          prop="owner"
        >
          <el-option label="学院" value="1"></el-option>
          <el-option label="学校" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addDevice" class="submit_btn"
          >注册</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import headTop from "../components/headTop";
import { addDevice } from "@/api/api.js";

export default {
  data() {
    return {
      registerForm: {
        name: "",
        model: "",
        type: "",
        owner: ""
      },
      rules: {
        name: [{ required: true, message: "请输入设备名称", trigger: "blur" }],
        model: [{ required: true, message: "请输入设备型号", trigger: "blur" }],
        type: [{ required: true, message: "请选择设备类型", trigger: "blur" }],
        owner: [{ required: true, message: "请选择设备归属", trigger: "blur" }]
      }
    };
  },
  components: {
    headTop
  },
  mounted() {},
  computed: {},
  methods: {
    addDevice() {
      let param = {
        type: this.registerForm.type + "",
        owner: this.registerForm.owner + "",
        user: 0,
        time: this.formatDate(),
        status: 0,
        name: this.registerForm.name,
        model: this.registerForm.model
      };
      addDevice(param).then(response => {
        if (response.status == "200") {
          //注册成功
          this.$message({
            showClose: true,
            message: "添加成功",
            type: "success"
          });
          this.$router.push("/deviceAudit");
        } else {
          this.$message({
            showClose: true,
            message: "添加失败" + response.message,
            type: "error"
          });
        }
      });
    },
    formatDate() {
      var now = new Date();
      var year = now.getFullYear();
      var month = now.getMonth() + 1;
      var date = now.getDate();
      var hour = now.getHours();
      var minute = now.getMinutes();
      var second = now.getSeconds();
      return (
        year +
        "-" +
        month +
        "-" +
        date +
        " " +
        hour +
        ":" +
        minute +
        ":" +
        second
      );
    }
  }
};
</script>
