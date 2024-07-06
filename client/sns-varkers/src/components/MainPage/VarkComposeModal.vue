<template>
  <Teleport to="body">
    <div class="vark-box">
      <!-- <account v-if="varkStore.replyData != null" :data="varkStore.replyData.account" /> -->
      <div class="content-box left-space">
        <!-- 콘텐츠 영역 -->
        <div>
          <!-- 텍스트 영역 -->
          {{ varkStore.headVark.content }}
        </div>
        <div>
          <!-- 이미지 영역 -->
        </div>
      </div>
    </div>
    <form @submit.prevent="registerVark">
      <modal-base :show="mainStore.showVarkComposeModal">
        <template #header>
          <button type="button" @click="cancelCompose">X</button>
        </template>
        <template #body>
          <input type="text" v-model="content" />
        </template>
        <template #footer>
          <button type="submit">Register</button>
        </template>
      </modal-base>
    </form>
  </Teleport>
</template>

<script setup>
import { ref } from 'vue';
import ModalBase from '../common/ModalBase.vue';
import { useMainStore } from '@/stores/main';
import { createVark } from '@/api/vark';
import { useVarkStore } from '@/stores/vark';
import Account from './Account.vue';
import { createReceiver } from '@/api/receiver';
import { sendVark } from '@/api/notify';

const content = ref('');

const mainStore = useMainStore();
const varkStore = useVarkStore();

async function registerVark() {
  try {
    mainStore.toggleVarkComposeModal();
    const varkData = {
      accountId: mainStore.currentAccount.id,
      content: content.value,
    };
    const responseVark = await createVark(varkData);

    const accountIds = new Set([varkStore.headVark.account.id]);
    if (varkStore.headVark.receiver !== null) {
      varkStore.headVark.receiver.forEach((r) => {
        if (r.id !== mainStore.currentAccount.id) accountIds.add(r.id);
      });
    }

    const receiverData = {
      varkId: responseVark.data.id,
      accountIds: Array.from(accountIds),
    };

    const receiver = await createReceiver(receiverData);
    const notify = await sendVark(responseVark.data.id);
  } catch (error) {
    console.log(error);
  }
  initVark();
}

function cancelCompose() {
  mainStore.toggleVarkComposeModal();
  initVark();
}

function initVark() {
  content.value = '';
}
</script>
