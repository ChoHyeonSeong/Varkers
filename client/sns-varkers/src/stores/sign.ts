import { defineStore } from "pinia";
import { signInUser, type RequestUser } from "@/api/auth";
import { useMainStore } from "./main";

export const useUserStore = defineStore('sign', {
    state: () => ({
        mainStore: useMainStore(),
    }),
    actions: {
        async signInUser(userData:RequestUser) {
            try {
                const { data } = await signInUser(userData);
                await this.mainStore.initMainStore(data);
                return "PASS"
            } catch (error) {
                console.log(error);
                return "FAIL"
            }
        },
        async signUpUser(userData:RequestUser) {
            
        }
    },
  });