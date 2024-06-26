<template>
  <div class="box-header">
    <div class="left-box-block align-center">
      <img id="logo" src="/varkers-bg.png"/>
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
  justify-content: flex-end;
  align-items: center;
}

.left-box-block{
  width: 300px;
}

.align-center {
  display: flex;
  align-items: center;
}

#logo{
  width: 44px;
  height: 44px;
  margin-left: 10px;
}
</style>