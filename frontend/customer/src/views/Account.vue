<template>
  <b-container fluid="md">
    <div>
      <h1>マイページ</h1>
      <h2>こんにちは、{{ userInfo.name }}さん</h2>
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
        <div>
          <b-button v-b-modal.modal-1>確認</b-button>
          <b-modal id="modal-1" title="体重確認">
            <p class="my-4">日付 : {{ returnInfo.distinctDate }}
                            体重  :  {{ returnInfo.weight}} kgです</p>
          </b-modal>
        </div>
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
      },
      returnInfo: {
        weight: '',
        distinctDate: ''
      },
    }
  },
  async created() {
    this.userInfo.name = this.$route.params.name;
    this.userInfo.id = this.$route.params.id;
  },
  methods: {
    onContext(ctx) {
      this.context = ctx;
      if(this.context.selectedYMD !== '') {
        try {
          this.getHealthDiaryByIdAndDate(this.context);
        } catch {
          console.log("エラー");
        }
      } else {
        console.log("日付なし");
      }
    },
    async getHealthDiaryByIdAndDate(x) {
      let done;
      let results = [];
      console.log(x.selectedYMD);
      console.log(this.userInfo.id);
      try {
        done = await getHealthDiaryByIdAndDate(this.userInfo.id, this.context.selectedYMD);
        results = done.data;
        this.returnInfo.weight = results.weight;
        this.returnInfo.distinctDate = results.distinctDate;
        console.log(results)
      } catch {
        console.log("error");
      }
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