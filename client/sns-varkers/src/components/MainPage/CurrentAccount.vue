<template>
  <div class="align-items-center">
    <div class="image-block bg-real-lightgreen"></div>
    <div>
      <div class="nickname-block">{{ mainStore.currentAccount.nickname }}</div>
      <div class="name-block">@{{ mainStore.currentAccount.name }}</div>
    </div>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
const mainStore = useMainStore();
</script>

<style scoped>
.align-items-center {
  display: flex;
  align-items: center;
}

.nickname-block {
  font-weight: bold;
}

.name-block {
  color: gray;
}
.image-block {
  width: 40px;
  height: 40px;
  margin-right: 4px;
}
.bg-real-lightgreen {
  background-color: rgb(171, 220, 170);
}
</style>
