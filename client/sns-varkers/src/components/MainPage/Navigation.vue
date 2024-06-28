<template>
  <div class="navigaion-box">
    <nav>
      <a class="link-box">
        <div class="link-content-block flex-vertical-center">프로필</div>
      </a>
      <a class="link-box">
        <div class="link-content-block flex-vertical-center">북마크</div>
      </a>
      <a class="link-box">
        <div class="link-content-block flex-vertical-center">쪽지</div>
      </a>
      <a class="link-box">
        <div class="link-content-block flex-vertical-center">설정</div>
      </a>
    </nav>
  </div>
</template>

<script setup></script>

<style scoped>
.navigaion-box {
  border: 1px solid black;
  margin-top: 20px;
}
.link-content-block {
  height: 50px;
}
.link-box {
  display: block;
  padding-top: 4px;
  padding-bottom: 4px;
  font-size: 20px;
}
</style>
