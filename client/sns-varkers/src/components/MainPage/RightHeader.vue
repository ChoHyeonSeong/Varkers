<template>
  <div class="box-header">
    <div class="right-box-block">
      <input class="search" type="text" placeholder="검색"/>
    </div>
  </div>
</template>

<script>
    export default {
        
    }
</script>

<style scoped>
.box-header {
  height: 50px;
  border-bottom: 1px solid rgb(209, 255, 216);

  display: flex;
  align-items: center;
}

.right-box-block{
  width: 300px;
}

.search{
  height: 40px;
  width: 250px;
}
</style>