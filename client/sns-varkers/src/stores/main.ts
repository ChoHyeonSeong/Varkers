import { defineStore } from 'pinia';

export const useMainStore = defineStore('main', {
  state: () => ({
    showVarkCompose: false,
  }),
  actions: {
    toggleVarkCompose() {
      this.showVarkCompose = !this.showVarkCompose;
    },
  },
});
