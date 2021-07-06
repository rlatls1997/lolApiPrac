import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'


Vue.use(VueRouter)
const SearchSummoner = () => import("../views/SearchSummoner.vue");
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: "/summoner/by-name",
    name: 'SearchSummoner',
    component: SearchSummoner
  }

]

const router = new VueRouter({
  mode: "history",
  routes
})

export default router
