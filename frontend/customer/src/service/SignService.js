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

export const postAccountInfo = (form) => {
  const url = `http://localhost:8080/api/users/signup`;
  console.log(form.email);
  return axios.post(url, {
    name: form.name,
    email: form.email,
    password: form.password,
  }, {
    headers: {
      'content-type': 'application/json',
    },
  });
};
