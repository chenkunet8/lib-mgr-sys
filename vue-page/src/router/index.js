import Vue from "vue";
import Router from "vue-router";
import login from "@/page/login.vue";
import register from "@/page/register.vue";
import registerTeacher from "@/page/registerTeacher.vue";
import manage from "@/page/manage.vue";
import home from "@/page/home.vue";
import studuentList from "@/page/studuentList.vue";
import teacherList from "@/page/teacherList.vue";
import managerList from "@/page/managerList.vue";
import deviceList from "@/page/deviceList.vue";
import deviceManager from "@/page/deviceManager.vue";
import libInfo from "@/page/libInfo.vue";
import libManager from "@/page/libManager.vue";
import userAudit from "@/page/userAudit.vue";
import deviceAudit from "@/page/deviceAudit.vue";
import addDevice from "@/page/addDevice.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "login",
      component: login
    },
    {
      path: "/register",
      name: "register",
      component: register
    },
    {
      path: "/registerTeacher",
      name: "registerTeacher",
      component: registerTeacher
    },
    {
      path: "/manage",
      name: "manage",
      component: manage,
      children: [
        {
          path: "",
          component: home,
          meta: []
        },
        {
          path: "/studuentList",
          component: studuentList,
          meta: ["用户信息", "学生列表"]
        },
        {
          path: "/teacherList",
          component: teacherList,
          meta: ["用户信息", "教师列表"]
        },
        {
          path: "/managerList",
          component: managerList,
          meta: ["用户信息", "管理员列表"]
        },
        {
          path: "/deviceList",
          component: deviceList,
          meta: ["设备管理", "设备清单"]
        },
        {
          path: "/deviceManager",
          component: deviceManager,
          meta: ["设备管理", "设备明细"]
        },
        {
          path: "/libInfo",
          component: libInfo,
          meta: ["实验室管理", "实验室清单"]
        },
        {
          path: "/libManager",
          component: libManager,
          meta: ["实验室管理", "实验室借用"]
        },
        {
          path: "/userAudit",
          component: userAudit,
          meta: ["管理员菜单", "教师审核"]
        },
        {
          path: "/deviceAudit",
          component: deviceAudit,
          meta: ["操作菜单", "设备操作"]
        },
        {
          path: "/addDevice",
          component: addDevice,
          meta: ["操作菜单", "设备操作", "新增设备"]
        }
      ]
    }
  ]
});
