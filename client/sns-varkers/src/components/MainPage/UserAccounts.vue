<template>
  <div class="accounts-box relative">
    <ul>
      <template v-for="(account, i) in mainStore.accountList" :key="i">
        <li v-if="mainStore.currentAccount != mainStore.accountList[i]">
          <div @click="changeCurrentAccount(i)"><account :data="account" /></div>
        </li>
      </template>
      <li><div @click="mainStore.toggleAccountCompose">계정추가</div></li>
    </ul>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import Account from './Account.vue';
const mainStore = useMainStore();

function changeCurrentAccount(index) {
  mainStore.toggleUserAccounts();
  mainStore.changeCurrentAccount(index);
}
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
