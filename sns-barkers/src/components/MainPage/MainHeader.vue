<template>
  <div>
    <span>메인 헤더</span>
    <button @click="store.toggleBarkCompose">BARK</button>
    <bark-compose />
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import BarkCompose from './VarkCompose.vue';
const store = useMainStore();

</script>

<style scoped></style>
