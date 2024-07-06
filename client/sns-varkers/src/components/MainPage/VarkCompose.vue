<template>
  <div class="flex-center compose-box" v-if="mainStore.showVarkComposeBox">
    <textarea class="compose-area" v-model="content"></textarea>
  </div>
  <div class="header-box flex-center" style="height: 30px" @click="toggleComposeBox">
    <div>외치기</div>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import { ref } from 'vue';
const mainStore = useMainStore();

const content = ref('');

async function toggleComposeBox() {
  mainStore.toggleVarkComposeBox();
  if (!mainStore.showVarkComposeBox && content.value !== '') {
    await mainStore.createVark(content.value);
    initContent();
  }
}

function initContent() {
  content.value = '';
}
</script>

<style scoped>
.compose-area {
  border: 1px solid black;
  margin: 10px;
  height: 180px;
  width: 95%;
}
.compose-box {
  height: 200px;
  background-color: white;
}
</style>
