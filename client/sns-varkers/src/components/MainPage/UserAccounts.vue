<template>
  <div class="accounts-box relative">
    <ul>
      <template v-for="(account, i) in mainStore.accountList" :key="i">
        <li v-if="mainStore.currentAccount.id != mainStore.accountList[i].id">
          <div @click="mainStore.changeCurrentAccount(i)"><account :data="account" /></div>
        </li>
      </template>
      <li><div @click="mainStore.toggleAccountCompose">계정추가</div></li>
    </ul>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import { ref, watch } from 'vue';
import Account from './Account.vue';
const mainStore = useMainStore();
const accounts = ref([]);

// watch(
//   mainStore.accountMap,
//   (state) => {
//     fetchAccounts(state);
//     console.log(state);
//   },
//   { deep: true },
// );

// watch(
//   mainStore.currentAccount
// )

// function fetchAccounts(accountMap) {
//   accounts.value = [];
//   accountMap.forEach((a) => {
//     if (mainStore.currentAccount.id !== a.id) accounts.value.push(a);
//   });
// }

// fetchAccounts(mainStore.accountMap);
</script>

<style scoped>
.accounts-box {
  width: 300px;
  position: relative;
}

.accounts-box > ul {
  display: block;
  position: absolute;
  width: 100%;
  border: 1px solid black;
  background-color: white;
}

.item-box {
  height: 50px;
}
</style>
