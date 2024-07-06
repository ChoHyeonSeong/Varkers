<template>
  <Teleport to="body">
    <form @submit.prevent="createAccount">
      <modal-base :show="mainStore.showAccountCompose" class="compose-box">
        <template #header>
          <button type="button" @click="cancelCompose">X</button>
        </template>
        <template #body>
          <div> 닉네임 : <input type="text" v-model="nickname" /> </div>
          <div> 계정이름 : <input type="text" v-model="name" /> </div>
          <div> 자기소개 : <input type="text" v-model="description" /> </div>
        </template>
        <template #footer>
          <button type="submit">Register</button>
        </template>
      </modal-base>
    </form>
  </Teleport>
</template>

<script setup>
import { ref } from 'vue';
import ModalBase from '../common/ModalBase.vue';
import { useMainStore } from '@/stores/main';

const nickname = ref('');
const name = ref('');
const description = ref('');

const mainStore = useMainStore();

async function createAccount() {
  const accountData = {
    userId: mainStore.user.id,
    name: name.value,
    nickname: nickname.value,
    description: description.value,
  };
  mainStore.toggleAccountCompose();
  await mainStore.createAccount(accountData);
  initCompose();
}

function cancelCompose() {
  mainStore.toggleAccountCompose();
  initCompose();
}

function initCompose() {
  nickname.value = '';
  name.value = '';
  description.value = '';
}
</script>

<style scoped></style>
