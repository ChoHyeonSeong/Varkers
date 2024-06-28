<template>
  <div class="flex-vertical-center account-box">
    <div class="image-box symbolic-bg-color"></div>
    <div>
      <div class="nickname-box">{{ mainStore.currentAccount.nickname }}</div>
      <div class="name-box">@{{ mainStore.currentAccount.name }}</div>
    </div>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
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
