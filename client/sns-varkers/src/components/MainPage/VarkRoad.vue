<template>
  <div>
    <ul>
      <li v-for="vark in varkList" :key="vark.id">
        <div>{{ vark.account.nickname }}</div>
        <div>{{ vark.account.name }}</div>
        <div>{{ vark.content }}</div>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { readVarkRoad } from '@/api/vark';
import { readAccount } from '@/api/account';
const varkList = ref([]);

const props = defineProps({
  accountId: Number,
});

const eventSourcee = new EventSource(`http://localhost:7002/subscribe/${props.accountId}`);
eventSourcee.addEventListener('create', async (e) => {
  const vark = JSON.parse(e.data);
  const account = await readAccount(vark.accountId);
  vark.account=account.data;
  varkList.value.unshift(vark);
});

eventSourcee.onopen = async () => {
  const { data } = await readVarkRoad(props.accountId);
  const promises = data.map(async (vark) => {
    const account = await readAccount(vark.accountId);
    return {
      id:vark.id,
      account:account.data,
      content:vark.content,
      createdAt:vark.createdAt,
      updatedAt:vark.updatedAt,
    };
  });
  varkList.value = await Promise.all(promises);
  console.log(varkList.value);
};
</script>

<style scoped>
li {
  list-style: none;
}
</style>
