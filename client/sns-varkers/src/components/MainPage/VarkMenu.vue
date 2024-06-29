<template>
  <div class="flex-center">
    <div class="tab-box flex-center" @click="clickRoadTab">
      <span :class="isRoad ? 'selected-tab' : ''" class="tab-text flex-vertical-center"> 로드 </span>
      <div v-if="isRoad" class="selected-bar"></div>
    </div>
    <div class="tab-box flex-center" @click="clickReactionTab">
      <span :class="!isRoad ? 'selected-tab' : ''" class="tab-text flex-vertical-center">반응</span>
      <div v-if="!isRoad" class="selected-bar"></div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
const isRoad = ref(true);

function clickRoadTab() {
  isRoad.value = true;
}

function clickReactionTab() {
  isRoad.value = false;
}
</script>

<style scoped>
.tab-box {
  width: 50%;
  height: 100%;
  flex-direction: column;
}
.tab-text {
  height: 50px;
}
.tab-box:hover {
  background-color: rgb(183, 255, 225);
}

.selected-tab {
  font-weight: bold;
}

.selected-bar {
  height: 5px;
  width: 50px;
  background-color: cornflowerblue;
}
</style>
