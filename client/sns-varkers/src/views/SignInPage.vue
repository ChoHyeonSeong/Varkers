<template>
  <div>
    <h1>로그인 페이지</h1>
    <form @submit.prevent="submitForm">
      <div>
        <input type="text" v-model="email" placeholder="이메일" />
      </div>
      <div>
        <input type="password" v-model="password" placeholder="비밀번호" />
      </div>
      <button type="submit">로그인</button>
      <h1>{{ email }}</h1>
      <h1>{{ password }}</h1>
    </form>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const email = ref('');
const password = ref('');

const router = useRouter();

function submitForm() {
  axios
    .post('http://localhost:7002/user/signin')
    .then((res) => {
      console.log("성공"+res);
    })
    .catch((res) => {
      console.error("실패"+res);
    });
  router.push('/main');
}
</script>

<style scoped></style>
