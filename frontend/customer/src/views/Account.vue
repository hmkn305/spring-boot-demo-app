<template>
  <b-container>
    <div>
      <h1>マイページ</h1>
      <h2>こんにちは、{{ userInfo.name }}さん</h2>
      <h2>あなたのidは、{{userInfo.id}}です</h2>
    </div>
        <b-calendar
            @context="onContext"
            class="calender mb-5"
            selected-variant="primary"
            locale="ja"
            label-help=""
            hide-header
            label-prev-year="前年"
            label-prev-month="前月"
            label-current-month="当月"
            label-next-month="次月"
            label-next-year="次年"
            nav-button-variant="dark"
            block
        ></b-calendar>
        <div class="row justify-content-center mb-3">
          <b-button id="date-cancel-btn" type="reset" variant="outline-primary" class="w-25 mr-5">キャンセル</b-button>
          <b-button id="date-submit-btn" type="submit" variant="primary" class="w-25">変更</b-button>
        </div>
  </b-container>
</template>

<script>
import {getHealthDiaryByIdAndDate} from "@/service/HealthDiaryService";

export default {
  name: 'Account',
  data() {
    return {
      userInfo: {
        id: '',
        name: '',
        context: null
      }
    }
  },
  async created() {
    console.log(this.$route.params.name);
    console.log(this.$route.params.id);
    this.userInfo.name = this.$route.params.name;
    this.userInfo.id = this.$route.params.id;
  },
  methods: {
    onContext(ctx) {
      let done;
      this.context = ctx
      done = getHealthDiaryByIdAndDate(this.userInfo.id, this.context.selectedYMD);
      console.log(done);
      console.log(this.userInfo.id);
      console.log(this.context.selectedYMD);
    }
  }
};

</script>

<style scoped>
div {
  margin-top: 100px;
  text-align: center;
}
</style>