<template>
  <div>
    <form @submit.prevent="submitForm">
      <div>
        <input type="text" v-model="email" placeholder="이메일" />
      </div>
      <div>
        <input type="password" v-model="password" placeholder="비밀번호" />
      </div>
      <div>
        <input type="date" v-model="birth" placeholder="생일" />
      </div>
      <button type="submit">회원가입</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { signUpUser } from '@/api/auth';

const email = ref('');
const password = ref('');
const birth = ref('');
const router = useRouter();

async function submitForm() {
  try {
    const userData = {
      email: email.value,
      password: password.value,
      birth: birth.value,
    };
    const { data } = await signUpUser(userData);
    console.log(data);
    router.push('/');
  } catch (error) {
    console.log(error);
  }
}
</script>

<style scoped></style>
