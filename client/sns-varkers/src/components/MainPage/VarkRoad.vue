<template>
  <div>
    <h3>바크 로드</h3>
    <button type="button" @click="fetchVarkRoad">새로고침</button>
    <ul>
      <li v-for="vark in varkData" :key="vark.id">
        <p>{{ vark.content }}</p>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useMainStore } from '@/stores/main';
import { readVarkOfAccount } from "@/api/vark";

const mainStore = useMainStore();
const varkData = ref('');

async function fetchVarkRoad() {
  const { data } = await readVarkOfAccount(mainStore.currentAccountId);
  console.log(data[0].content);
  varkData.value = data;
}
</script>

<style scoped></style>
