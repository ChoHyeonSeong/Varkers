import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useMainStore = defineStore('main', () => {
  const showVarkCompose = ref(false);

  function toggleVarkCompose() {
    showVarkCompose.value = !showVarkCompose.value;
  }

  return { showVarkCompose, toggleVarkCompose };
});
