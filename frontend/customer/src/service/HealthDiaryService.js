import axios from 'axios';

export const getHealthDiaryByIdAndDate = (id, date) =>{
  const url = `http://localhost:8080/api/diary`;
  return axios.get(url, {
    params: {
      id: id,
      date: date,
    }
  });
};