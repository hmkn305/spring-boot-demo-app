import axios from 'axios';

export const getTrainingOfTheWeek = (id) => {
  const url = `http://localhost:8080/api/training`;
  console.log("バックエンドに送信");
  return axios.get(url, {
     params: {
       id: id,
     }
  });
};