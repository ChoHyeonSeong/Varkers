<template>
  <div class="vark-box">
    <div class="flex">
      <!-- 프로필 영역 -->
      <div class="profile-image-box symbolic-bg-color">
        <!-- 이미지 영역 -->
      </div>
      <div>
        <!-- 텍스트 영역 -->
        <div class="nickname-block">{{ data.account.nickname }}</div>
        <div class="name-block">@{{ data.account.name }}</div>
      </div>
    </div>
    <div class="content-box left-space"> 
      <!-- 콘텐츠 영역 -->
      <div>
        <!-- 텍스트 영역 -->
        {{ data.content }}
      </div>
      <div>
        <!-- 이미지 영역 -->
      </div>
    </div>
    <div class="flex left-space btn-box">
      <!-- 버튼 영역 -->
       <div>답글</div>
       <div>재게시</div>
       <div>북마크</div>
       <div>공유</div>
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
.nickname-block {
  font-weight: bold;
}

.name-block {
  color: gray;
}

.content-box{
  margin-bottom: 8px;
  margin-top: 8px;
}

.btn-box{
  justify-content: space-around;
}

.left-space {
  margin-left: 44px;
}

.vark-box {
  border-bottom: 1px solid var(--boundaryColor);
  padding: 8px;
}
</style>
