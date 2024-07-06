<template>
  <div class="flex-vertical-center nav-box">
    <h1>VARKERS</h1>
    <div class="nav-btn symbolic-bg-color flex-center">
      <router-link to="/signin">로그인</router-link>
    </div>
    <div class="nav-btn symbolic-bg-color flex-center">
      <router-link to="/signup">회원가입</router-link>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.nav-box {
  height: 300px;
  width: 400px;
  flex-direction: column;
  position: relative;
  left: 60%;
  bottom: 20vh;
  background-color: white;
  justify-content: space-evenly;
  border-radius: 10px;
}

.nav-btn {
  width: 300px;
  height: 50px;
  border-radius: 10px;
}
</style>
