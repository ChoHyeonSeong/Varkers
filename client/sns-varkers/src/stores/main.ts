import { createAccount, readAccount, readUserAccounts } from '@/api/account';
import { createVark } from '@/api/vark';
import { defineStore } from 'pinia';
import type { ResponseAccount } from '@/api/account';
import type { ResponseUser } from '@/api/auth';

export const useMainStore = defineStore('main', {
  state: () => ({
    user:{} as ResponseUser,
    showAccountCompose: false,
    showUserAccounts: false,
    showVarkComposeBox: false,
    showVarkComposeModal: false,
    currentAccount: {} as ResponseAccount,
    accountList: [] as ResponseAccount[],
  }),
  actions: {
    toggleAccountCompose() {
      this.showAccountCompose = !this.showAccountCompose;
    },
    toggleUserAccounts() {
      this.showUserAccounts = !this.showUserAccounts;
    },
    toggleVarkComposeBox() {
      this.showVarkComposeBox = !this.showVarkComposeBox;
    },
    toggleVarkComposeModal() {
      this.showVarkComposeModal = !this.showVarkComposeModal;
    },
    changeCurrentAccount(index : number){
      this.currentAccount = this.accountList[index];
    },
    async createAccount(accountData : ResponseAccount){
      const { data } = await createAccount(accountData);
      this.accountList.push(data);
    },
    async initMainStore(user: ResponseUser) {
      this.user = user;
      const userAccounts = await readUserAccounts(user.id);
      userAccounts.data.forEach(a=> {
        this.accountList.push(a)
        if(a.id == user.currentAccountId)
          this.currentAccount = a;
      });
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
