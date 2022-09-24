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
          meta: ["用户管理", "学生列表"]
        },
        {
          path: "/teacherList",
          component: teacherList,
          meta: ["用户管理", "教师列表"]
        },
        {
          path: "/managerList",
          component: managerList,
          meta: ["用户管理", "管理员列表"]
        },
        {
          path: "/deviceList",
          component: deviceList,
          meta: ["设备管理", "设备清单"]
        }
      ]
    }
  ]
});
