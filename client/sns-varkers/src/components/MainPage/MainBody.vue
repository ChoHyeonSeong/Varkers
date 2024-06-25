<template>
  <div class="container">
    <vark-road :accountId="mainStore.currentAccountId" />
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import VarkRoad from './VarkRoad.vue';

const mainStore = useMainStore();
</script>

<style scoped>
.container {
  border: 1px solid rgb(209, 255, 216);
  border-bottom: none;
  border-top: none;
  height: 100%;
}
</style>
