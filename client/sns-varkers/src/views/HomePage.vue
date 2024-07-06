<template>
  <div class="full-screen">
    <div class="top-color-box symbolic-bg-color"> </div>
    <div>
      <home-navigation />
    </div>
  </div>
</template>

<script setup>
import HomeNavigation from '@/components/HomePage/HomeNavigation.vue';
</script>

<style scoped>
.top-color-box {
  height: 40%;
}

.full-screen {
  height: 100vh;
  width: 100vw;
}
</style>
