<template>
  <div class="home">
    <h1>HOME画面</h1>
    <b-button
        size="lg"
        variant="outline-primary">
      <router-link to="/login">
        ログイン
      </router-link>
    </b-button>
    <b-button
        size="lg"
        variant="outline-primary">
      <router-link to="/signup">
        新規登録
      </router-link>
    </b-button>
  </div>
</template>

<script>

export default {
  name: 'Home',
  props: {
    msg: String
  },
}
</script>

<style scoped>
div {
  margin-top: 100px;
  text-align: center;
}
</style>