import axios from 'axios';

export const findById = (id) => {
  const url = `http://localhost:8080/api/users/${id}`;
  console.log(id);
  return axios.get(url, {
    params: {
      id: id
    }
  });
};