import Vue from 'vue'
import Router from 'vue-router'
import login from '@/page/login.vue'
import hello from '@/components/HelloWorld.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    }
  ]
})
