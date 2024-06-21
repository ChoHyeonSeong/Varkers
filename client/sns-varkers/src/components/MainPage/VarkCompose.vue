<template>
  <Teleport to="body">
    <form @submit.prevent="registerVark">
      <modal-base :show="mainStore.showVarkCompose" @close="mainStore.toggleVarkCompose">
        <template #header>
          <h3>Vark Register</h3>
        </template>
        <template #body>
          <input type="text" v-model="content" />
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
import axios from 'axios';

const content = ref('');

const mainStore = useMainStore();

function registerVark() {
  mainStore.toggleVarkCompose();
  const varkData = {
    accountId: mainStore.currentAccountId,
    content: content.value,
  };
  try {
    const { data } = axios.post('http://localhost:7002/vark', varkData);
    console.log(data);
  } catch (error) {
    console.log(error);
  }
  initVark();
}

function initVark() {
  content.value = '';
}
</script>
