<template>
  <div class="box-body">
    <div class="left-box-block">
      <div class="accounts-block">
        <div>이미지</div>
        <div><p>계정 닉네임</p><p>계정 이름</p></div>
      </div>
      <ul class="others-block">
        <li>프로필</li>
        <li>북마크</li>
        <li>쪽지</li>
        <li>설정</li>
      </ul>
      <div class="vark-btn">외치기</div>
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
}
.others-block {
  list-style: none;
  border: 1px solid black;
}
.vark-btn{
  width: 300px;
  background-color: lightgreen;
  border-color: rgb(209, 255, 216);
}
</style>
