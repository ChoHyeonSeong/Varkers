<template>
  <div class="box-body">
    <div class="left-box-block">
      <div class="accounts-block">
        <div>이미지</div>
        <div><div>계정 닉네임</div><div>계정 이름</div></div>
      </div>
      <nav class="others-block">
        <a class="link-block">
          <div class="link-content-block align-items-center">프로필</div>
        </a>
        <a class="link-block">
          <div class="link-content-block align-items-center">북마크</div>
        </a>
        <a class="link-block">
          <div class="link-content-block align-items-center">쪽지</div>
        </a>
        <a class="link-block">
          <div class="link-content-block align-items-center">설정</div>
        </a>
      </nav>
      <div class="vark-btn align-items-center">외치기</div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.box-body {
  display: flex;
  justify-content: flex-end;
}
.left-box-block {
  width: 300px;
}
.accounts-block {
  display: flex;
  border: 1px solid black;
  margin-top: 20px;
}
.others-block {
  list-style: none;
  border: 1px solid black;
  margin-top: 20px;
}
.vark-btn{
  width: 300px;
  height: 50px;
  background-color: lightgreen;
  border-color: rgb(209, 255, 216);
  margin-top: 20px;
  justify-content: center;
}
.align-items-center{
  display: flex;
  align-items: center;
}
.link-content-block{
  height: 50px;
}
.link-block{
  display: block;
  padding-top: 4px;
  padding-bottom: 4px;
  font-size: 20px;
}
</style>
