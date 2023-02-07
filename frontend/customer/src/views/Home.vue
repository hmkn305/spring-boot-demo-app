<template>
  <div class="home">
    <h1>HOME画面</h1>
  </div>
</template>

<script>
import {findById} from "@/service/login";

export default {
  name: 'Home',
  props: {
    msg: String
  },
  async created() {
    await this.findById(1);
  },
  methods: {
    async findById(id) {
      let results = [];
      let done;
      try {
        done = await findById(id);
        results = done.data;
        console.log(results);
      } catch {
        console.log("エラー");
      }
    }
  }
}
</script>

<style scoped>
div {
  margin-top: 100px;
  text-align: center;
}
</style>