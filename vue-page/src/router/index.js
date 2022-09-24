import Vue from 'vue'
import Router from 'vue-router'
import login from '@/page/login.vue'
import register from '@/page/register.vue'
import registerTeacher from '@/page/registerTeacher.vue'
import manage from '@/page/manage.vue'
import home from '@/page/home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/registerTeacher',
      name: 'registerTeacher',
      component: registerTeacher
    },
    {
      path: '/manage',
      name: 'manage',
      component: manage,
      children:[{
        path: '',
        component: home,
        meta: [],
      }]
    }
  ]
})
