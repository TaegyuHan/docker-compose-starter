import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import LoginView from "@/views/LoginView.vue";
import JoinView from "@/views/JoinView.vue";
import TestView from "@/views/TestView.vue";

const routes = [
  {
    path: '/',
    component: HomeView,
  },
  {
    path: '/login',
    component: LoginView,
  },
  {
    path: '/join',
    component: JoinView,
  },
  {
    path: '/test',
    component: TestView,
  },
];

const router = createRouter({
  history: createWebHistory(), // history 모드 사용
  routes,
});

export default router;