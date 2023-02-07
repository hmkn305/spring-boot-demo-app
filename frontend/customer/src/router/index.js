import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from "@/views/Home";
import Login from "@/views/Login";

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
    }
  ]
});

export default router