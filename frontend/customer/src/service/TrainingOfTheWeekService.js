import axios from 'axios';

export const getTrainingOfTheWeek = (id) => {
  const url = `http://localhost:8080/api/training`;
  return axios.get(url, {
     params: {
       id: id,
     }
  });
};

export const getTimesOfTheMonthByPart = (id) => {
  const url = `http://localhost:8080/api/training/by-part`;
  console.log("バックエンドに送信");
  return axios.get(url, {
    params: {
      id: id,
    }
  });
};


export const postTrainingInfo = (request) => {
  const url = `http://localhost:8080/api/training`;
  return axios.post(url, {
    id: request.id,
    trainingMenu: request.trainingMenu,
    times: request.times,
    reps: request.reps,
    date: request.date,
  }, {
    headers: {
      'content-type': 'application/json',
    },
  });
};
