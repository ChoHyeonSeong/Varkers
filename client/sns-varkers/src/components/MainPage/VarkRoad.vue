<template>
  <div>
    <div v-for="vark in varkList" :key="vark.id">
      <vark :data="vark" />
    </div>
  </div>
</template>

<script setup>
import { ref, watch, onBeforeUnmount } from 'vue';
import { readVarkRoad } from '@/api/vark';
import { readAccount } from '@/api/account';
import Vark from './Vark.vue';

const varkList = ref([]);

const props = defineProps({
  accountId: Number,
});

const sseConnection = ref(createEventSource(props.accountId));

watch(
  () => props.accountId,
  (newAccountId) => {
    sseConnection.value.close();
    console.log('계정변경!');
    sseConnection.value = createEventSource(newAccountId);
  },
);
onBeforeUnmount(() => {
  sseConnection.value.close();
});

function createEventSource(accountId) {
  const newEventSourcee = new EventSource(
    `http://localhost:7002/notification/subscribe/${accountId}`,
  );
  newEventSourcee.addEventListener('create', async (e) => {
    const vark = JSON.parse(e.data);
    const account = await readAccount(vark.accountId);
    // receiver 불러오는 로직
    vark.account = account.data;
    varkList.value.unshift(vark);
  });

  newEventSourcee.onopen = async () => {
    const { data } = await readVarkRoad(props.accountId);
    const promises = data.map(async (vark) => {
      const account = await readAccount(vark.accountId);
      return {
        id: vark.id,
        account: account.data,
        content: vark.content,
        createdAt: vark.createdAt,
        updatedAt: vark.updatedAt,
      };
    });
    varkList.value = await Promise.all(promises);
  };

  newEventSourcee.onerror = async () => {
    newEventSourcee.close();
  };

  return newEventSourcee;
}
</script>
