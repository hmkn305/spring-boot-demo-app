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

export const postWeightInfo = (request) => {
  const url = `http://localhost:8080/api/diary`;
  console.log(request.id);
  console.log(request.weight);
  console.log(request.date);
  return axios.post(url, {
    id: request.id,
    weight: request.weight,
    date: request.date,
  }, {
    headers: {
      'content-type': 'application/json',
    },
  });
};