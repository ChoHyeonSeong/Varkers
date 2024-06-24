<template>
  <div>
    <h2>메인 바디</h2>
    <vark-road :accountId="mainStore.currentAccountId"/>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import VarkRoad from './VarkRoad.vue';

const mainStore = useMainStore();
</script>

<style scoped></style>
