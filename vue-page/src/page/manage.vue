<template>
  <div class="manage_page fillcontain">
    <el-row style="height: 100%;">
      <el-col :span="4" style="min-height: 100%; background-color: #324057;">
        <el-menu
          :default-active="defaultActive"
          style="min-height: 100%;"
          theme="dark"
          router
          background-color="#0000"
          text-color="#fff"
        >
          <el-menu-item index="manage"
            ><i class="el-icon-menu"></i>首页</el-menu-item
          >
          <el-submenu index="2">
            <template slot="title"
              ><i class="el-icon-document"></i>用户信息</template
            >
            <el-menu-item index="studuentList">学生列表</el-menu-item>
            <el-menu-item index="teacherList">教师列表</el-menu-item>
            <el-menu-item index="managerList">管理员列表</el-menu-item>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"
              ><i class="el-icon-plus"></i>设备管理</template
            >
            <el-menu-item index="deviceList">设备清单</el-menu-item>
            <el-menu-item index="deviceManager">设备明细</el-menu-item>
          </el-submenu>
          <el-submenu index="4" v-if="role == 3">
            <template slot="title"
              ><i class="el-icon-star-on"></i>实验室管理</template
            >
            <el-menu-item index="libInfo">实验室清单</el-menu-item>
            <el-menu-item index="libManager">实验室借用</el-menu-item>
          </el-submenu>
          <el-submenu index="5">
            <template slot="title"
              ><i class="el-icon-setting"></i>操作菜单</template
            >
            <el-menu-item index="userAudit" v-if="role == 3"
              >教师审核</el-menu-item
            >
            <el-menu-item index="deviceAudit">设备操作</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-col>
      <el-col :span="20" style="height: 100%;overflow: auto;">
        <keep-alive>
          <router-view></router-view>
        </keep-alive>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      role: this.$store.getters.role
    };
  },
  computed: {
    defaultActive: function() {
      return this.$route.path.replace("/", "");
    }
  }
};
</script>

<style lang="less" scoped>
@import "../style/mixin";
</style>
