import { readAccount } from '@/api/account';
import { defineStore } from 'pinia';

export const useMainStore = defineStore('main', {
  state: () => ({
    showVarkCompose: false,
    currentAccount: Object,
  }),
  actions: {
    toggleVarkCompose() {
      this.showVarkCompose = !this.showVarkCompose;
    },
    async initMainStore(currentAccountId: number) {
      const { data } = await readAccount(currentAccountId);
      this.currentAccount = data;
    },
  },
});
