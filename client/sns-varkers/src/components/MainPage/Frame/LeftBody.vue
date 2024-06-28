<template>
  <div>
    <current-account/>  
    <navigation/>
    <!-- <div class="vark-btn bg-real-lightgreen align-items-center">외치기</div> -->
  </div>
</template>

<script setup>
import CurrentAccount from '../CurrentAccount.vue'
import Navigation from '../Navigation.vue';

</script>

<style scoped>
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
</style>
