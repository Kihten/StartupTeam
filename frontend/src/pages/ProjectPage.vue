<template>
  <q-page class="flex flex-center">
    <div class="q-gutter-md fit" v-if="!isLoading">
      <q-card class="my-card text-center">
        <q-img class="title_image" :src="project.image"  :ratio="16/9">
          <div class="text-subtitle2 absolute-top text-center">
            {{ project.name }}
          </div>
        </q-img>
        <p>{{ project.description }}</p>
        <h4>Author: {{ project.author }}</h4>
      </q-card>
    </div>
    <q-inner-loading
      :showing="isLoading"
      label="Please wait..."
      label-class="text-teal"
      label-style="font-size: 1.1em"
    />
  </q-page>
</template>

<script>
import { useCounterStore } from 'stores/example-store'
import { mapActions, mapState } from 'pinia'
import { ref } from 'vue'

export default{
  data() {
    return {
      name: 'IndexPage',
      slide: ref(0),
      isLoading: false,
      lorem: 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Itaque voluptatem totam, architecto cupiditate officia rerum, error dignissimos praesentium libero ab nemo.',
    }
  },
  async beforeMount(){
    this.isLoading=true;
    await this.loadProject(this.$route.params.id);
    this.isLoading=false;

  },
  methods: {
    ...mapActions(useCounterStore, ['loadProject']),
  },
  computed: {
    ...mapState(useCounterStore, ['project']),
  }
}
</script>
<style lang="sass">

.title_image
  width: 80vw
</style>