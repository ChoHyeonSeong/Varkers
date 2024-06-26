<template>
  <div class="vark-box">
    <div class="profile-box">
      <div class="image-block"></div>
      <div>
        <div class="nickname-block">{{ data.account.nickname }}</div>
        <div class="name-block">@{{ data.account.name }}</div>
      </div>
    </div>
    <div class="content-box"> {{ data.content }}</div>
  </div>
</template>

<script setup>
const props = defineProps({
  data:Object,
});
</script>

<style scoped>
.profile-box{
  display: flex;
}

.image-block{
  width: 40px;
  height: 40px;
  margin-right: 4px;
  background-color: lightgreen;
}
.nickname-block{
  font-weight: bold;
}

.name-block{
  color: gray;
}

.content-box{
  margin-left: 44px;
  margin-bottom: 8px;
  margin-top: 8px;
}

.vark-box{
  border-bottom: 1px solid rgb(209, 255, 216);
  padding: 8px;
}
</style>
