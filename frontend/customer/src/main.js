import Vue from 'vue'
import App from './App.vue'
import router from "@/router";
import {BootstrapVue, BootstrapVueIcons} from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import '@/assets/css/app.css'
import VueCompositionAPI from '@vue/composition-api'

Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)
Vue.config.productionTip = false
Vue.use(VueCompositionAPI)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')