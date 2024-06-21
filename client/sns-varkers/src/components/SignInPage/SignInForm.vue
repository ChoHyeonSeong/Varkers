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
import { useMainStore } from '@/stores/main';
import { useRouter } from 'vue-router';
import { signInUser } from "@/api/auth";

const email = ref('');
const password = ref('');
const router = useRouter();
const mainStore = useMainStore();

async function submitForm() {
  try {
    const userData = {
      email: email.value,
      password: password.value,
    };
    const { data } = await signInUser(userData);
    console.log(data.id);
    mainStore.setCurrentAccountId(data.currentAccountId);
    router.push('/main');
  } catch (error) {
    console.log(error);
  }
}
</script>

<style scoped></style>
