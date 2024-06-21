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
import { useMainStore } from '@/stores/main';
import axios from 'axios';
import { ref } from 'vue';

const mainStore = useMainStore();
const varkData = ref('');

async function fetchVarkRoad() {
  const { data } = await axios.get('http://localhost:7002/vark/account/' + mainStore.currentAccountId);
  console.log(data[0].content);
  varkData.value = data;
}
</script>

<style scoped></style>
