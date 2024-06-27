<template>
  <div class="box-body">
    <div class="left-box-block">
      <div class="accounts-block">
        <current-account/>  
      </div>

      <div class="vark-btn bg-real-lightgreen align-items-center">외치기</div>
    </div>
  </div>
</template>

<script setup>
import CurrentAccount from './AccountList.vue'

</script>

<style scoped>
.bg-real-lightgreen {
  background-color: rgb(171, 220, 170);
}
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
.vark-btn {
  width: 300px;
  height: 50px;
  border-color: rgb(209, 255, 216);
  margin-top: 20px;
  justify-content: center;
}
.align-items-center {
  display: flex;
  align-items: center;
}
.link-content-block {
  height: 50px;
}
.link-block {
  display: block;
  padding-top: 4px;
  padding-bottom: 4px;
  font-size: 20px;
}
</style>
