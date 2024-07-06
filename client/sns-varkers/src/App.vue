<template>
    <router-view></router-view>
</template>

<script setup>
import { onUnmounted } from 'vue';

onUnmounted(()=>{
    console.log('언마운트');
});

</script>

<style>
@import './assets/css/reset.css';
@import './assets/css/common.css';
</style>
