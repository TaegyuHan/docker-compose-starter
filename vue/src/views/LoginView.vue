<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';
import Header from '@/components/Header.vue';

let email = ref("");
let password = ref("");
const router = useRouter()

function submitForm() {

      alert(email.value);

      const loginData = {
        email: email.value,
        password: password.value
      };

      // API에 POST 요청 보내기
      axios.post('http://localhost:8080/api/v1/login', loginData)
        .then(response => {
          console.log('응답 상태 코드:', response.status);
          console.log('응답 데이터:', response.data);

          router.push('/join');
        })
        .catch(error => {
          if (error.response) {
            console.error('응답 상태 코드:', error.response.status);
            console.error('응답 데이터:', error.response.data);
          } else {
            console.error('요청 실패:', error.message);
          }
        });
};

</script>

<template>
    <Header />

    <main class="login-main">
      <div class="login-form">
        <fieldset>

          <legend class="login-legend">Login</legend>

          <div class="login-box">

            <div class="selection-box">
              <button class="main-color">배우</button>
              <button class="gray-color">스태프 / 감독</button>
            </div>

            <div class="login-input-box">
              <input v-model="email" placeholder="이메일">
              <p>{{ email }}</p>
              <input v-model="password" type="password" placeholder="비밀번호">
              <p>{{ password }}</p>
            </div>
            
            <div class="login-help-link">
              <p>
                <a href="">비밀번호 찾기</a> |
                <a href="">아이디 찾기</a> |
                <a href="">회원가입</a>
              </p>
            </div>

            <button class="login-button" @click="submitForm">로그인</button>
            
          </div>
        </fieldset>
      </div>
      <div>
        {{  }}
      </div>

    </main>

</template>

<style>

  .login-main {
    width: 100%;
    display: flex;
    justify-content: center;
  }

  .login-box {
    border-radius: 0.25rem;
    border: 1px solid #79747E;
  }

  main > .login-form {
    margin-top: 6.88rem;
    display: block;
    width: 28.5rem;
    height: auto;
    text-align: center;
  }

  .selection-box > button {
    display: inline-block;
    width: 9.375rem;
    margin: 0.31rem;
    flex-direction: column;
    align-items: center;
    margin-top: 1.56rem;
    padding: 0.625rem 1.5rem;
    border-radius: 6.25rem;
    border: none;
    color:#ffffff;
  }

  .main-color {
    background-color: #6750A4;
    
  }

  .gray-color {
    background-color: #938F99;
  }

  .login-form {
    display: flex;
    padding: 1.5625rem 1.75rem;
    flex-direction: column;    
  }

  fieldset {
    border: none;
    padding: 0;
    margin: 0;
  }

  .login-input-box > input {

    display: flex;
    width: 25rem;
    height: 2.5rem;

    margin: 0.31rem 1.75rem;

    padding: 0.5rem 0rem 0.5rem 1rem;
    align-items: center;
    align-self: stretch;

    border-radius: 0.25rem;
    border: 1.5px solid #79747E;
  }

  .login-legend {
    color: var(--m-3-black, #000);

    margin-bottom: 0.62rem;
    font-family: Roboto;
    font-size: 2rem;
    font-style: normal;
    font-weight: 400;
    line-height: 2.5rem;
  }

  .login-help-link > p {
    color: var(--m-3-sys-light-on-surface-variant, #49454F);
    text-align: right;

    margin-right: 1.75rem;

    font-family: Roboto;
    font-size: 0.75rem;
    font-style: normal;
    font-weight: 400;
    line-height: 1rem;
  }

  .login-help-link > p a {
    text-decoration: none;
  }

  .login-button {
    display: inline-block;
    width: 13.68rem;
    margin-bottom: 1.56rem;
    flex-direction: column;
    align-items: center;
    padding: 0.625rem 1.5rem;
    border-radius: 6.25rem;
    border: none;
    color:#ffffff;
    background-color: #6750A4;
  }

</style>