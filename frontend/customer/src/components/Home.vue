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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>