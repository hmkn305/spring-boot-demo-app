import Vue from "vue";
import VueRouter from "vue-router";
import Login from "@/views/Login.vue";
import Home from "@/views/Home.vue";
import Account from "@/views/Account.vue";

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
    },
    {
      path: '/account',
      name: 'Account',
      component: Account,
    }
  ]
});

export default router;
