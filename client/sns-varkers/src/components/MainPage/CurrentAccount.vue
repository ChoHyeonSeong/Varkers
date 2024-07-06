<template>
  <div class="account-box" @click="mainStore.toggleUserAccounts">
    <account :data="mainStore.currentAccount" />
  </div>
  <user-accounts v-if="mainStore.showUserAccounts" />
  <account-compose-modal />
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import UserAccounts from './UserAccounts.vue';
import Account from './Account.vue';
import AccountComposeModal from './AccountComposeModal.vue';

const mainStore = useMainStore();
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
