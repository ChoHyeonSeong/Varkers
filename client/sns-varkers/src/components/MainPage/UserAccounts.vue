<template>
  <div class="accounts-box relative">
    <ul>
      <template v-for="account in accounts" :key="account.id">
        <li>
          <a href="#">{{ account.name }}</a>
        </li>
      </template>
      <li><a href="#">계정추가</a></li>
    </ul>
  </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main';
import { ref } from 'vue';
const mainStore = useMainStore();
const accounts = ref([]);
mainStore.accountMap.forEach((a) => accounts.value.push(a));
</script>

<style scoped>
.accounts-box {
  width: 300px;
  position: relative;
}

.accounts-box > ul {
  display: block;
  position: absolute;
  width: 100%;
  border: 1px solid black;
  background-color: white;
}

.item-box {
  height: 50px;
}
</style>
