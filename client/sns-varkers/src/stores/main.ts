import { readAccount } from '@/api/account';
import { createVark } from '@/api/vark';
import { defineStore } from 'pinia';
import {ResponseAccount} from '@/api/account';

export const useMainStore = defineStore('main', {
  state: () => ({
    showVarkCompose: false,
    currentAccount: {},
  }),
  actions: {
    toggleVarkCompose() {
      this.showVarkCompose = !this.showVarkCompose;
    },
    async initMainStore(currentAccountId: number) {
      const { data } = await readAccount(currentAccountId);
      this.currentAccount = data;
    },
    async createVarkFromCurrentAccount(content:string){
      try {
        const varkData = {
          accountId:this.currentAccount.id,
          content:content
        };
        const { data } = await createVark(varkData);
        console.log(data);
      } catch (error) {
        console.log(error);
      }
    }
  },
});
