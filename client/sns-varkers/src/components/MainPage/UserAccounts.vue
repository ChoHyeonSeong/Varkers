<template>
  <div class="accounts-box relative">
    <ul>
      <template v-for="account in accounts" :key="account.id">
        <li>
          <div><account :data="account" /></div>
        </li>
      </template>
      <li><div>계정추가</div></li>
    </ul>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import { ref } from 'vue';
import Account from './Account.vue';
const mainStore = useMainStore();
const accounts = ref([]);
mainStore.accountMap.forEach((a) => {
  if (mainStore.currentAccount.id !== a.id) accounts.value.push(a);
});
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
