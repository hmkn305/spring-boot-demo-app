<template>
  <div class="login">
    <h1>ログイン画面</h1>
    <div>
      <div >
        <b-alert
            variant="danger"
            dismissible
            fade
            :show="showDismissibleAlert"
        >
          {{ errorMessage }}
        </b-alert>
      </div>
      <b-form-group
          id="email"
          label="メールアドレス">
        <b-form-input
            id="email"
            v-model="form.email"
            type="email"
            required>
        </b-form-input>
      </b-form-group>
      <b-form-group
          id="password"
          label="パスワード">
        <b-form-input
            id="password"
            v-model="form.password"
            type="password"
            required>
        </b-form-input>
      </b-form-group>
      <b-button
          type="submit"
          variant="primary"
          @click="findByEmailAndPassword(form.email, form.password)"
      >GO
      </b-button>
    </div>
  </div>
</template>

<script>

import {findByEmailAndPassword} from "@/service/SignService";
import router from "@/router";

export default {
  name: 'Login',
  data() {
    return {
      form: {
        email: '',
        password: '',
      },
      showDismissibleAlert: false,
      errorMessage: '',
    }
  },
  methods: {
    async findByEmailAndPassword() {
      let results = [];
      let done;
      try {
        done = await findByEmailAndPassword(this.form.email, this.form.password);
        results = done.data;
        if (results.errorType == null) {
          await router.push({name: 'Account', params: {name: results.name, id: results.id}});
        } else {
          this.showDismissibleAlert = true;
          this.errorMessage = results.errorType;
          setTimeout(() => this.showDismissibleAlert = false,
              3000);
        }
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