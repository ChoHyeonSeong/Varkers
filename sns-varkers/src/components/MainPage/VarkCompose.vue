<template>
  <Teleport to="body">
    <form @submit.prevent="registerVark">
      <modal-base :show="store.showVarkCompose" @close="store.toggleVarkCompose">
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

const content = ref('');

const store = useMainStore();

function registerVark() {
  store.toggleVarkCompose();
  console.log(content.value);
}
</script>
