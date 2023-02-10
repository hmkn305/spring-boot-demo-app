<template>
  <b-container fluid="md">
    <div>
      <h1>マイページ</h1>
      <h2>こんにちは、{{ userInfo.name }}さん</h2>
    </div>
    <b-calendar
        v-model="selectedDate"
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
    <b-button v-b-modal.editor
              @click="setDate">確認
    </b-button>

    <b-modal id="editor" title="体重確認">
      <b-form>
        <b-form-group>
          <label class="font-weight-bold">日付</label>
          <p id="date">{{ selectedDate }} </p>

          <b-form-group>
            <label class="font-weight-bold">体重</label>
            <b-form-input
                id="weight"
                v-model="returnInfo.weight"
            >
              kg
            </b-form-input>
          </b-form-group>
        </b-form-group>

        <div>
          <b-button
          @click="changeWeightInfo">{{ insertOrModifyButton }}</b-button>
        </div>
      </b-form>
    </b-modal>
  </b-container>
</template>

<script>
import {getHealthDiaryByIdAndDate} from "@/service/HealthDiaryService";
import {postWeightInfo} from "@/service/HealthDiaryService";

export default {
  name: 'Account',
  data() {
    return {
      selectedDate: '',
      insertOrModifyButton: '修正',
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
    setDate() {
      this.getHealthDiaryByIdAndDate(this.selectedDate);
      this.returnInfo.distinctDate = this.selectedDate;
    },
    async getHealthDiaryByIdAndDate() {
      let done;
      let results = [];
      try{
        done = await getHealthDiaryByIdAndDate(this.userInfo.id, this.selectedDate);
        results = done.data;
        console.log(results);
        this.returnInfo.weight = results.weight;
        this.returnInfo.distinctDate = results.distinctDate;
        console.log(this.returnInfo.weight);
        this.insertOrModifyButton = '修正'
        if (this.returnInfo.weight == null) {
          this.returnInfo.weight = '';
          this.insertOrModifyButton = '追加';
        }
      }catch {
        console.log("error");
      }
    },
    changeWeightInfo(){
      let request = [];
      request = {id: this.userInfo.id, weight: this.returnInfo.weight, date: this.selectedDate};
      postWeightInfo(request);
    }
  },
}

</script>

<style scoped>
div {
  margin-top: 100px;
  text-align: center;
}
</style>