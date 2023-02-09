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



