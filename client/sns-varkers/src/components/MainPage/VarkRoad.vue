<template>
  <div>
    <div v-for="varkData in varkList" :key="varkData.id">
      <vark :data="varkData" />
    </div>
  </div>
</template>

<script setup>
import { ref, watch, onBeforeUnmount } from 'vue';
import { readVarkRoad } from '@/api/vark';
import { readAccount, readAccounts } from '@/api/account';
import Vark from './Vark.vue';
import { readReceiver } from '@/api/receiver';

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
  const newEventSourcee = new EventSource(`http://localhost:7002/notify/subscribe/${accountId}`);
  newEventSourcee.addEventListener('create', async (e) => {
    const vark = JSON.parse(e.data);
    const account = await readAccount(vark.accountId);

    // receiver 불러오는 로직
    vark.account = account.data;

    const receiver = await readReceiver(vark.id);
    let accounts = null;
    if (receiver.data.accountIds.length !== 0) {
      console.log(receiver.data);
      const accountsRes = await readAccounts(receiver.data.accountIds);
      accounts = accountsRes.data;
    }
    vark.receiver = accounts;
    varkList.value.unshift(vark);
  });

  newEventSourcee.onopen = async () => {
    const { data } = await readVarkRoad(props.accountId);
    const promises = data.map(async (vark) => {
      const account = await readAccount(vark.accountId);
      const receiver = await readReceiver(vark.id);
      let accounts = null;
      if (receiver.data.accountIds.length !== 0) {
        const accountsRes = await readAccounts(receiver.data.accountIds);
        accounts = accountsRes.data;
      }
      return {
        id: vark.id,
        account: account.data,
        content: vark.content,
        receiver: accounts,
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
