import axios from 'axios';

export const postHeightInfo = (request) => {
  const url = `http://localhost:8080/api/height`;
  console.log("バックエンドへ身長を送信");
  return axios.post(url, {
    id: request.id,
    height: request.height,
  }, {
    headers: {
      'content-type': 'application/json',
    },
  });
};

export const getBMIForThreeMonths = (id) => {
  const url = `http://localhost:8080/api/height`;
  return axios.get(url, {
    params: {
      id: id,
    }
  });
};