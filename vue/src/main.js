// src/main.js
import { createApp } from 'vue';
import App from '@/App.vue';
import router from '@/router'; // 라우터 설정 파일 불러오기
import '@/assets/normalize.css';

createApp(App).use(router).mount('#app');