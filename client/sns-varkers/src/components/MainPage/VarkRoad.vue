<template>
  <div>
    <ul>
      <li v-for="vark in varkList" :key="vark.id">
        <div>{{ vark.content }}</div>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { readVarkRoad } from '@/api/vark';
const varkList = ref([]);

const props = defineProps({
  accountId: Number,
});

const eventSourcee = new EventSource(`http://localhost:7002/subscribe/${props.accountId}`);
eventSourcee.addEventListener('create', (e) => {
  varkList.value.unshift(JSON.parse(e.data));
});
eventSourcee.onopen = async () => {
  const { data } = await readVarkRoad(props.accountId);
  varkList.value = data;
};
</script>

<style scoped>
li{
  list-style: none;
}
</style>
