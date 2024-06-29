<template>
  <div class="account-box" @click="toggleUserAccounts">
    <account :data="mainStore.currentAccount" />
  </div>
  <user-accounts v-if="showUserAccounts" />
</template>

<script setup>
import { ref } from 'vue';
import { useMainStore } from '@/stores/main';
import UserAccounts from './UserAccounts.vue';
import Account from './Account.vue';

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
