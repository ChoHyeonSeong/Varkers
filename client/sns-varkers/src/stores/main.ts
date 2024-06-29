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
    accountMap: {} as Map<number,ResponseAccount>,
  }),
  actions: {
    toggleVarkCompose() {
      this.showVarkCompose = !this.showVarkCompose;
    },
    async initMainStore(user: ResponseUser) {
      this.user = user;
      const { currentAccount } = await readAccount(user.currentAccountId);
      const { datas } = await readUserAccounts(user.id);
      datas.
      this.accountMap.set()
      this.currentAccount = currentAccount;
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
