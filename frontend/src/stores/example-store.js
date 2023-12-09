import { defineStore } from 'pinia';
import { api } from 'boot/axios'

export const useCounterStore = defineStore('counter', {
  state: () => ({
    counter: 0,
    projects: [],
    project: {},
  }),
  getters: {
    doubleCount: (state) => state.counter * 2,
  },
  actions: {
    increment() {
      this.counter++;
    },
    async loadData(){
      const response = await api.get('/projects', { method:'get' });
      console.log(response);
      this.projects = response.data;
    },
    async loadProject(project_id){
      const response = await api.get(`/project/${project_id}`, { method:'get' });
      // const response = await api.get(`/project/${project_id}`, { method:'post', data: {id: 1} });
      console.log(response);
      this.project = response.data;
    }
  }
});
