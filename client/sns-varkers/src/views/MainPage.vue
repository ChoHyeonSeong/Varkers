<template>
  <div class="page">
    <div class="left-box sticky-box">
      <left-header/>
      <left-body/>
    </div>
    <div class="main-box">
      <main-header class="sticky-box"/>
      <main-body />
    </div>
    <div class="right-box sticky-box">
      <right-header/>
      <right-body/>
    </div>
  </div>
</template>

<script setup>
import LeftHeader from '@/components/MainPage/LeftHeader.vue';
import LeftBody from '@/components/MainPage/LeftBody.vue';
import MainHeader from '@/components/MainPage/MainHeader.vue';
import MainBody from '@/components/MainPage/MainBody.vue';
import RightHeader from '@/components/MainPage/RightHeader.vue';
import RightBody from '@/components/MainPage/RightBody.vue';
</script>

<style scoped>
.page {
  text-align: center;
  display: flex;
  justify-content: center;
  overflow-x: hidden;
  overflow-y: scroll; 
}
.main-box{
  width: 600px;
}
.box-header{
  background-color: lightgreen;
}
.right-box,
.left-box{
  flex-grow: 1;
}

.sticky-box{
  position: sticky;
  top: 0px; /* 도달했을때 고정시킬 위치 */
}
</style>
