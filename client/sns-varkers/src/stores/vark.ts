import { defineStore } from "pinia";

export const useVarkStore=defineStore('vark',{
    state: () => ({
        replyData: Object
      }),
})