<template>
  <div>
    <h1>메인 헤더</h1>
    <button @click="toggleBarkCompose">BARK</button>
    <bark-compose :showModal="showBarkCompose" @close="toggleBarkCompose" />
  </div>
</template>

<script setup>
import BarkCompose from './BarkCompose.vue';
import { ref } from 'vue';

const showBarkCompose = ref(false);

function toggleBarkCompose() {
  showBarkCompose.value = !showBarkCompose.value;
}
</script>

<style scoped></style>
