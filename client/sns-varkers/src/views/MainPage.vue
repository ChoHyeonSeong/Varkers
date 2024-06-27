<template>
  <div class="main-page flex-horizontal-center">
    <div class="left-box sticky-box">
      <!-- <left-header class="header-box symbolic-bg-color"/>
      <left-body/> -->
    </div>
    <div class="main-box">
      <div class="sticky-box" >
        <main-header class=" header-box symbolic-bg-color"  style="height: 80px"/>
      </div>
      <main-body />
    </div>
    <div class="right-box sticky-box">
      <right-header class="header-box symbolic-bg-color" />
      <right-body />
    </div>
  </div>
</template>

<script setup>
// import LeftHeader from '@/components/MainPage/Frame/LeftHeader.vue';
// import LeftBody from '@/components/MainPage/Frame/LeftBody.vue';
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
  border: 1px solid var(--boundaryColor);
  border-bottom: none;
  border-top: none;
}

.right-box,
.left-box {
  flex-grow: 1;
}

.sticky-box {
  position: sticky;
  top: 0px; /* 도달했을때 고정시킬 위치 */
}
</style>
