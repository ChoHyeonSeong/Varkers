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
      <div class="sticky-box">
        <main-header class="symbolic-bg-color" />
      </div>
      <main-body />
    </div>
    <div class="side-box sticky-box">
      <div class="header-box symbolic-bg-color">
        <right-header class="side-components-width" />
      </div>
      <div>
        <right-body class="side-components-width" />
      </div>
    </div>
  </div>
</template>

<script setup>
import LeftHeader from '@/components/MainPage/Frame/LeftHeader.vue';
import LeftBody from '@/components/MainPage/Frame/LeftBody.vue';
import MainHeader from '@/components/MainPage/Frame/MainHeader.vue';
import MainBody from '@/components/MainPage/Frame/MainBody.vue';
import RightHeader from '@/components/MainPage/Frame/RightHeader.vue';
import RightBody from '@/components/MainPage/Frame/RightBody.vue';
</script>

<style scoped>
.main-page {
  height: 100%;
  overflow-x: hidden;
  overflow-y: scroll;
}
.main-box {
  height: 100%;
  width: 600px;
  border: 1px solid rgb(248,249,250);
  border-top: none;
  border-bottom: none;
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

.flex-horizontal-right {
  display: flex;
  justify-content: flex-end;
}
</style>
