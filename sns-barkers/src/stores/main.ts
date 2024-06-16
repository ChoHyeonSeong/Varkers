import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useMainStore = defineStore('main', () => {
  const showBarkCompose = ref(false);

  function toggleBarkCompose() {
    showBarkCompose.value = !showBarkCompose.value;
  }

  return { showBarkCompose, toggleBarkCompose };
});
