<template>
  <Teleport to="body">
    <form @submit.prevent="registerVark">
      <modal-base :show="mainStore.showVarkComposeModal">
        <template #header>
          <button type="button" @click="cancelCompose">X</button>
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
import { createVark } from '@/api/vark';

const content = ref('');

const mainStore = useMainStore();

async function registerVark() {
  try {
    mainStore.toggleVarkCompose();
    const varkData = {
      accountId: mainStore.currentAccountId,
      content: content.value,
    };
    const { data } = await createVark(varkData);
    console.log(data);
  } catch (error) {
    console.log(error);
  }
  initVark();
}

function cancelCompose(){
  mainStore.toggleVarkComposeModal();
  initVark();
}

function initVark() {
  content.value = '';
}
</script>
