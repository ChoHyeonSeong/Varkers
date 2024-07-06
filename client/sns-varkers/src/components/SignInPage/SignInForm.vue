<template>
  <div>
    <form @submit.prevent="submitForm">
      <div>
        <input type="text" v-model="email" placeholder="이메일" />
      </div>
      <div>
        <input type="password" v-model="password" placeholder="비밀번호" />
      </div>
      <button type="submit">로그인</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useSignStore } from '@/stores/sign';
import { useRouter } from 'vue-router';

const email = ref('');
const password = ref('');
const signStore = useSignStore();
const router = useRouter();

async function submitForm() {
  const userData = {
    email: email.value,
    password: password.value,
  };
  const result = await signStore.signInUser(userData);
  if (result === 'PASS') router.push('/main');
}
</script>

<style scoped></style>
