<template>
  <div>
    <span>메인 헤더</span>
    <button @click="store.toggleVarkCompose">VARK</button>
    <vark-compose />
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import VarkCompose from './VarkCompose.vue';
const store = useMainStore();

</script>

<style scoped></style>
