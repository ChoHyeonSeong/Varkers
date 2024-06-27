<template>
  <vark-road :accountId="mainStore.currentAccount.id" />
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import VarkRoad from '../VarkRoad.vue';

const mainStore = useMainStore();
</script>

<style scoped>
</style>
