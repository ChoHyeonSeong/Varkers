import axios from 'axios';

function createInstance() {
    return axios.create({
      baseURL: import.meta.env.VUE_APP_API_URL,
  });
}

function createInstanceWithAuth(url:string) {
  const instance = axios.create({
    baseURL: `${import.meta.env.VUE_APP_API_URL}${url}`,
  });
  return instance;
  // return setInterceptors(instance);
}

export const instance = createInstance();
export const vark = createInstanceWithAuth('vark');