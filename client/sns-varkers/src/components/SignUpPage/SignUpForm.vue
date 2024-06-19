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
const email = ref('');
const password = ref('');
const birth = ref('');

async function submitForm() {
  try {
    const userData = {
      email: this.email.value,
      password: this.password.value,
      birth: this.birth.value,
    };
    axios
      .post('http://localhost:7002/user/signup', userData)
      .then((res) => {
        console.log('성공' + res);
      })
      .catch((res) => {
        console.error('실패' + res);
      });
    router.push('/main');
  } catch (error) {
    console.log(error.response.data);
  }
}
</script>

<style scoped></style>
