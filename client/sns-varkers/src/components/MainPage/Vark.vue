<template>
  <div class="vark-box">
    <account :data="data.account" />
    <div class="content-box left-space">
      <!-- 콘텐츠 영역 -->
      <div>
        <!-- 텍스트 영역 -->
        {{ data.content }}
      </div>
      <div>
        <!-- 이미지 영역 -->
      </div>
    </div>
    <div class="flex left-space btn-box">
      <!-- 버튼 영역 -->
      <div @click="toggleVarkComposeModal">답글</div>
      <div>재게시</div>
      <div>북마크</div>
      <div>공유</div>
    </div>
  </div>
</template>

<script setup>
import { useVarkStore } from '@/stores/vark';
import Account from './Account.vue';
import { useMainStore } from '@/stores/main';


const mainStore = useMainStore();
const varkStore = useVarkStore();

const props = defineProps({
  data: Object,
});

function toggleVarkComposeModal(){
  varkStore.replyData = data;
  mainStore.toggleVarkComposeModal();
}

</script>

<style scoped>
.content-box {
  margin-bottom: 8px;
  margin-top: 8px;
}

.btn-box {
  justify-content: space-around;
}

.left-space {
  margin-left: 44px;
}

.vark-box {
  border-bottom: 1px solid var(--boundaryColor);
  padding: 8px;
}
</style>
