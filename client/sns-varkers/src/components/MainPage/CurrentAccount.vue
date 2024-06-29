<template>
  <div class="flex-vertical-center account-box" @click="toggleUserAccounts">
    <div class="image-box symbolic-bg-color"></div>
    <div>
      <div class="nickname-box">{{ mainStore.currentAccount.nickname }}</div>
      <div class="name-box">@{{ mainStore.currentAccount.name }}</div>
    </div>
  </div>
  <user-accounts v-if="showUserAccounts" />
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import UserAccounts from './UserAccounts.vue';

const mainStore = useMainStore();
const showUserAccounts = ref(false);

function toggleUserAccounts() {
  showUserAccounts.value = !showUserAccounts.value;
}
</script>

<style scoped>
.account-box {
  border: 1px solid black;
  margin-top: 20px;
}
.nickname-box {
  font-weight: bold;
}

.name-box {
  color: gray;
}
.image-box {
  width: 40px;
  height: 40px;
  margin-right: 4px;
}
</style>
