import { defineStore } from 'pinia';

export const useMainStore = defineStore('main', {
  state: () => ({
    showVarkCompose: false,
    currentAccountId: -1,
  }),
  actions: {
    toggleVarkCompose() {
      this.showVarkCompose = !this.showVarkCompose;
    },
    initMainStore(currentAccountId:number) {
      this.currentAccountId = currentAccountId;
    },
  },
});
