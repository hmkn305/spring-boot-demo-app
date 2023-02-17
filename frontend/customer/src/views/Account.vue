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

    <b-modal id="editor" title="体重確認" class="modal-lg" hide-footer>
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
              <div class="container mt-5">
                <div class="row">
                  <label class="font-weight-bold text-center">トレーニング</label>
                  <b-form-select
                      v-model="trainingMenuDecided"
                      :options="trainingMenu"
                  ></b-form-select>
                  <label class="font-weight-bold text-center">回数</label>
                  <b-form-select
                      v-model="trainingTimesDecided"
                      :options="trainingTimes"
                  ></b-form-select>
                  <label class="font-weight-bold text-center">セット数</label>
                  <b-form-select
                      v-model="trainingRepsDecided"
                      :options="trainingReps"
                  ></b-form-select>
                  <b-button class="my-3"
                            @click="postTrainingMenu">メニュー送信
                  </b-button>
                </div>
              </div>
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
    <div>
      <b-table :items="items" :fields="fields" caption-top>
        <template #table-caption>今週のトレーニング記録</template>
      </b-table>
    </div>
    <div>
      <label class="font-weight-bold">身長入力</label>
      <b-form-input
          id="height"
          v-model="height"
      >
        kg
      </b-form-input>
      <b-button
          @click="registerHeightInfo"
          class="mt-3">{{ insertOrModifyHeightButton }}
      </b-button>
    </div>
    <div class="pb-10">
      <b-table :items="itemsBmi" :fields="fieldsBmi" caption-top>
        <template #table-caption>BMIの推移</template>
      </b-table>
    </div>
  </b-container>
</template>

<script>
import {getHealthDiaryByIdAndDate, postWeightInfo} from "@/service/HealthDiaryService";
import {getTrainingOfTheWeek, postTrainingInfo} from "@/service/TrainingOfTheWeekService";
import {getBMIForThreeMonths, postHeightInfo} from "@/service/HeightService";

export default {
  name: 'Account',
  data() {
    return {
      selectedDate: '',
      insertOrModifyButton: '修正',
      insertOrModifyHeightButton: '登録',
      userInfo: {
        id: '',
        name: ''
      },
      returnInfo: {
        weight: '',
        distinctDate: ''
      },
      isCompletedWeightInfo: false,
      trainingMenu: ['ダンベルフライ', 'ベンチプレス', 'インクラインベンチプレス', 'ケーブルフライ', 'ショルダープレス', 'ラットプルダウン',
        'レッグプレス'],
      trainingTimes: [7, 8, 9, 10, 11, 12, 13, 14, 15],
      trainingReps: [1, 2, 3, 4, 5],
      trainingMenuDecided: '',
      trainingTimesDecided: '',
      trainingRepsDecided: '',
      fields: [
        {
          key: 'trainingDay',
          label: '日付'
        },
        {
          key: 'trainingMenu',
          label: 'トレーニング'
        },
        {
          key: 'trainingTimes',
          label: '回数'
        },
        {
          key: 'trainingReps',
          label: 'セット数'
        },
      ],
      fieldsBmi: [
        {
          key: 'Month',
          label: '月'
        },
        {
          key: 'Bmi',
          label: 'BMI'
        },
        {
          key: 'MarginByLastMonth',
          label: '先月比'
        }
      ],
      itemsBmi: [],
      items: [],
      height: '',
    }
  },
  async created() {
    this.userInfo.name = this.$route.params.name;
    this.userInfo.id = this.$route.params.id;
    await this.getTrainingOfTheWeek(this.userInfo.id);
    await this.getBMIForThreeMonths(this.userInfo.id);
  },
  methods: {
    setDate() {
      this.getHealthDiaryByIdAndDate(this.selectedDate);
      this.returnInfo.distinctDate = this.selectedDate;
      this.isCompletedWeightInfo = false;
    },
    async getBMIForThreeMonths(id) {
      let done;
      let results = [];
      let months = [];
      done = await getBMIForThreeMonths(id);
      results = done.data;
      months = ['今月', '先月', '先々月'];
      console.log(months[0]);
      console.log(results[0]);
      console.log(results);
      for (let i = 0; i < 3; i++) {
        this.itemsBmi.push({
          Month: months[i],
          Bmi: results[i],
          MarginByLastMonth: results[i] - results[i + 1],
        });
      }
    },
    async getTrainingOfTheWeek(id) {
      let done;
      let results = [];
      done = await getTrainingOfTheWeek(id);
      results = done.data;
      console.log(results);
      console.log(results[2].training_of_the_week_detail_list.length);
      console.log(results[2].training_of_the_week_detail_list[0].training_menu);
      console.log(results.length);
      for (let i = 0; i < results.length; i++) {
        this.items.push({trainingDay: results[i].training_date});
        for (let j = 0; j < results[i].training_of_the_week_detail_list.length; j++) {
          this.items.push({
            trainingMenu: results[i].training_of_the_week_detail_list[j].training_menu,
            trainingTimes: results[i].training_of_the_week_detail_list[j].times,
            trainingReps: results[i].training_of_the_week_detail_list[j].reps
          });
        }
      }
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
    },
    postTrainingMenu() {
      let request = [];
      request = {
        id: this.userInfo.id,
        trainingMenu: this.trainingMenuDecided,
        times: this.trainingTimesDecided,
        reps: this.trainingRepsDecided,
        date: this.selectedDate
      };
      postTrainingInfo(request);
    },
    registerHeightInfo() {
      let request = [];
      request = {id: this.userInfo.id, height: this.height};
      postHeightInfo(request);
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