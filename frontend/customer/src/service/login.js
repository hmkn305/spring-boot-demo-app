import axios from 'axios';

export const findByEmailAndPassword = (email, password) => {
  const url = `http://localhost:8080/api/users`;
  return axios.get(url, {
    params: {
      email: email,
      password: password,
    }
  });
};