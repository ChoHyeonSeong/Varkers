<template>
  <div>
    <h1>로그인 페이지</h1>
    <form>
      <div>
        <input type="text" placeholder="이메일" />
      </div>
      <div>
        <input type="text" placeholder="비밀번호" />
      </div>
      <router-link to="/main">로그인</router-link>
      <!-- <button type="submit">로그인</button> -->
    </form>
  </div>
</template>

<script>
export default {
  setup(props) {},
}
</script>

<style scoped></style>
