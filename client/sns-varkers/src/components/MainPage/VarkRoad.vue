<template>
  <div>
    <div v-for="vark in varkList" :key="vark.id">
        <vark :data="vark"/>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { readVarkRoad } from '@/api/vark';
import { readAccount } from '@/api/account';
import Vark from './Vark.vue';

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
};
</script>