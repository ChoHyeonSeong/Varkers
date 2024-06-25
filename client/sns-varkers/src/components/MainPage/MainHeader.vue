<template>
  <div class="box-header">
    <div class="menu align-center">
      <div id="selected-tab" class="tab align-center">
        <span class="tab-text"> 로드 </span>
        <div id="select-bar"></div>
      </div>
      <div class="tab align-center">반응</div>
    </div>
    <div class="btn-box align-center" @click="mainStore.toggleVarkCompose">
      <p>외치기</p>
    </div>
    <vark-compose />
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import VarkCompose from './VarkCompose.vue';
const mainStore = useMainStore();
</script>

<style scoped>
.box-header {
  height: 80px;
  border: 1px solid rgb(209, 255, 216);
  border-bottom: none;
  border-top: none;
}
.menu {
  height: 50px;
  border-bottom: 1px solid rgb(209, 255, 216);
}
.tab {
  width: 50%;
  height: 100%;
  flex-direction: column;
}
.btn-box {
  background-color: lightgreen;
  border-bottom: 1px solid rgb(209, 255, 216);
  height: 29px;
}
.align-center {
  display: flex;
  justify-content: center;
  align-items: center;
}
.tab-text{
  display: flex;
  align-items : center;
  height: 50px;
}

#selected-tab {
  background-color: rgb(209, 255, 216);
  font-weight: bold;
}

#select-bar {
  height: 5px;
  width: 50px;
  background-color: cornflowerblue;
}
</style>
