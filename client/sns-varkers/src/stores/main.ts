import { defineStore } from 'pinia';

export const useMainStore = defineStore('main', {
  state: () => ({
    showVarkCompose: false,
    currentAccountId: BigInt(-1),
  }),
  actions: {
    toggleVarkCompose() {
      this.showVarkCompose = !this.showVarkCompose;
    },
    setCurrentAccountId(currentAccountId:bigint) {
      this.currentAccountId = currentAccountId;
    },
  },
});
