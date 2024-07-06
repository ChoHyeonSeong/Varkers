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
      <div>
        <input
          type="text"
          v-model="accountName"
          pattern="[A-Za-z]+"
          @input="validationAccountName"
          maxlength="20"
          placeholder="계정 이름"
        />
        <div class="text-bold" :class="validationClass">{{ validationMsg }}</div>
      </div>
      <button type="submit">회원가입</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { signUpUser } from '@/api/auth';
import { checkName } from '@/api/account';

const email = ref('');
const password = ref('');
const birth = ref('');
const accountName = ref('');
const router = useRouter();
const regExp = /^[a-zA-Z0-9_]+$/;
const validationMsg = ref('');
const validationClass = ref('');
const isPossibleSignUp = ref(false);

async function submitForm() {
  if (isPossibleSignUp.value) {
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
}

async function validationAccountName() {
  if (regExp.test(accountName.value)) {
    const { data } = await checkName(accountName.value);
    if (!data) {
      validationMsg.value = '사용 가능한 계정이름 입니다.';
      validationClass.value = 'enable-name';
      isPossibleSignUp.value = true;
    } else {
      validationMsg.value = '중복 된 계정이름 입니다.';
      validationClass.value = 'disable-name';
      isPossibleSignUp.value = false;
    }
  } else {
    validationMsg.value = '유효하지 않은 계정이름 입니다.';
    validationClass.value = 'disable-name';
    isPossibleSignUp.value = false;
  }
}

validationAccountName();
</script>

<style scoped>
.enable-name {
  color: skyblue;
}

.disable-name {
  color: crimson;
}

.text-bold {
  font-weight: bold;
}
</style>
