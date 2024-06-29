import { readAccount, readUserAccounts } from '@/api/account';
import { createVark } from '@/api/vark';
import { defineStore } from 'pinia';
import type { ResponseAccount } from '@/api/account';
import type { ResponseUser } from '@/api/auth';

export const useMainStore = defineStore('main', {
  state: () => ({
    user:{} as ResponseUser,
    showVarkCompose: false,
    currentAccount: {} as ResponseAccount,
    accountMap: new Map<number,ResponseAccount>,
  }),
  actions: {
    toggleVarkCompose() {
      this.showVarkCompose = !this.showVarkCompose;
    },
    async initMainStore(user: ResponseUser) {
      this.user = user;
      const currentAccount = await readAccount(user.currentAccountId);
      const userAccounts = await readUserAccounts(user.id);
      userAccounts.data.forEach(a=> this.accountMap.set(a.id,a));
      this.currentAccount = currentAccount.data;
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
