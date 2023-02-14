<template>
  <div class="login">
    <h1>新規登録画面</h1>
    <div>
      <b-alert
          variant="danger"
          dismissible
          fade
          :show="showDismissibleAlert"
      >
        {{  errorMessage }}
      </b-alert>
      <b-form-group
          id="name"
          label="名前">
        <b-form-input
            id="name"
            v-model="form.name"
            type="text"
            required>
        </b-form-input>
      </b-form-group>
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
          @click="postAccountInfo(form.email, form.password)"
      >GO</b-button>
    </div>
  </div>
</template>

<script>
import {postAccountInfo} from "@/service/SignService";
import router from "@/router";

export default {
  name: 'SignUp',
  data(){
    return{
      form: {
        name: '',
        email: '',
        password: '',
      },
      showDismissibleAlert: false,
      errorMessage: '',
    }
  },
  methods: {
     async postAccountInfo(){
       let results = [];
       const res = await postAccountInfo(this.form);
       results = res.data;
       console.log(results);
       if(results.errorType == null){
         await router.push({name: 'Account', params: {name: this.form.name}});
       } else {
         this.showDismissibleAlert = true;
         this.errorMessage = results.errorType;
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