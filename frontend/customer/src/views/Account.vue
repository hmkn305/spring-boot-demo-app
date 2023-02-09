<template>
  <b-container>
    <div>
      <h1>マイページ</h1>
      <h2>こんにちは、{{ userInfo.name }}さん</h2>
    </div>
  </b-container>
</template>

<script>
export default {
  name: 'Account',
  data() {
    return {
      userInfo: {
        name: ''
      }
    }
  },
  async created() {
    console.log(this.$route.params.name);
    this.userInfo.name = this.$route.params.name;
  }
};

</script>

<style scoped>
div {
  margin-top: 100px;
  text-align: center;
}
</style>