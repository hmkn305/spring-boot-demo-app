<template>
  <div class="login">
    <h1>ログイン画面</h1>
  </div>
</template>

<script>

export default {
  name: 'Login',

  async created() {
    console.log("ログイン画面");
  },
}
</script>

<style scoped>
div {
  margin-top: 100px;
  text-align: center;
}
</style>