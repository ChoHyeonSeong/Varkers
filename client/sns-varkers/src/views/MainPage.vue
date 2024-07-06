<template>
  <div class="main-page flex-horizontal-center">
    <div class="side-box sticky-box">
      <div class="header-box symbolic-bg-color flex-horizontal-right">
        <left-header class="side-components-width" />
      </div>
      <div class="flex-horizontal-right">
        <left-body class="side-components-width" />
      </div>
    </div>
    <div class="main-box">
      <div class="fixed-box main-header side-border">
        <main-header class="symbolic-bg-color" />
      </div>
      <div
        class="side-border main-body"
        :class="mainStore.showVarkComposeBox ? 'compose-padding' : 'default-padding'"
      >
        <main-body />
      </div>
    </div>
    <div class="side-box sticky-box">
      <div class="header-box symbolic-bg-color">
        <right-header class="side-components-width" />
      </div>
      <div>
        <right-body class="side-components-width" />
      </div>
    </div>
    <vark-compose-modal />
  </div>
</template>

<script setup>
import LeftHeader from '@/components/MainPage/Frame/LeftHeader.vue';
import LeftBody from '@/components/MainPage/Frame/LeftBody.vue';
import MainHeader from '@/components/MainPage/Frame/MainHeader.vue';
import MainBody from '@/components/MainPage/Frame/MainBody.vue';
import RightHeader from '@/components/MainPage/Frame/RightHeader.vue';
import RightBody from '@/components/MainPage/Frame/RightBody.vue';
import VarkComposeModal from '@/components/MainPage/VarkComposeModal.vue';
import { useMainStore } from '@/stores/main';

const mainStore = useMainStore();
</script>

<style scoped>
.main-page {
  height: 100vh;
  overflow-x: hidden;
  overflow-y: scroll;
}
.main-box {
  height: 100vh;
  width: 600px;
}
.side-box {
  flex-grow: 1;
}

.side-components-width {
  width: 300px;
}

.sticky-box {
  position: sticky;
  top: 0px; /* 도달했을때 고정시킬 위치 */
}

.fixed-box {
  position: fixed;
  top: 0px; /* 도달했을때 고정시킬 위치 */
}

.main-header {
  width: inherit;
}
.side-border {
  border: 1px solid rgb(248, 249, 250);
  border-top: none;
  border-bottom: none;
}

.flex-horizontal-right {
  display: flex;
  justify-content: flex-end;
}

.default-padding {
  margin-top: 80px;
}
.compose-padding {
  margin-top: 280px;
}

.main-body {
  height: 100vh;
}
</style>
