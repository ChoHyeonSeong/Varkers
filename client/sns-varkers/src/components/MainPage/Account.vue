<template>
  <div class="flex-vertical-center">
    <!-- 프로필 영역 -->
    <div class="profile-image-box symbolic-bg-color">
      <!-- 이미지 영역 -->
    </div>
    <div>
      <!-- 텍스트 영역 -->
      <div class="nickname-box">{{ data.nickname }}</div>
      <div class="name-box">@{{ data.name }}</div>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  data: Object,
});
</script>

<style scoped>
.profile-image-box {
  width: 40px;
  height: 40px;
  margin-right: 4px;
}
.nickname-box {
  font-weight: bold;
}

.name-box {
  color: gray;
}
</style>
