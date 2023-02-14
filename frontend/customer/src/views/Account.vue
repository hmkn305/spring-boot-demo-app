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

    <b-modal id="editor" title="体重確認" hide-footer>
      <b-form>
        <div v-if="!isCompletedWeightInfo">
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
            <div>
              <b-button
                  @click="changeWeightInfo">{{ insertOrModifyButton }}
              </b-button>
            </div>
          </b-form-group>
        </div>
        <div v-if="isCompletedWeightInfo">
          <p>登録が完了しました</p>
          <div>
            <b-button @click="$bvModal.hide('editor')">
              閉じる
            </b-button>
          </div>
        </div>
      </b-form>
    </b-modal>
  </b-container>
</template>

<script>
import {getHealthDiaryByIdAndDate, postWeightInfo} from "@/service/HealthDiaryService";
import {getTrainingOfTheWeek} from "@/service/TrainingOfTheWeekService";

export default {
  name: 'Account',
  data() {
    return {
      selectedDate: '',
      insertOrModifyButton: '修正',
      userInfo: {
        id: '',
        name: ''
      },
      returnInfo: {
        weight: '',
        distinctDate: ''
      },
      isCompletedWeightInfo: false,
    }
  },
  async created() {
    this.userInfo.name = this.$route.params.name;
    this.userInfo.id = this.$route.params.id;
    this.getTrainingOfTheWeek(this.userInfo.id);
  },
  methods: {
    setDate() {
      this.getHealthDiaryByIdAndDate(this.selectedDate);
      this.returnInfo.distinctDate = this.selectedDate;
      this.isCompletedWeightInfo = false;
    },
    async getTrainingOfTheWeek(id) {
      let done;
      let results = [];
      done = await getTrainingOfTheWeek(id);
      results = done.data;
      console.log(results);
    },
    async getHealthDiaryByIdAndDate() {
      let done;
      let results = [];
      try {
        done = await getHealthDiaryByIdAndDate(this.userInfo.id, this.selectedDate);
        results = done.data;
        this.returnInfo.weight = results.weight;
        this.returnInfo.distinctDate = results.distinctDate;
        this.insertOrModifyButton = '修正'
        if (this.returnInfo.weight == null) {
          this.returnInfo.weight = '';
          this.insertOrModifyButton = '追加';
        }
      } catch {
        console.log("error");
      }
    },
    changeWeightInfo() {
      let request = [];
      request = {id: this.userInfo.id, weight: this.returnInfo.weight, date: this.selectedDate};
      postWeightInfo(request);
      this.isCompletedWeightInfo = true;
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