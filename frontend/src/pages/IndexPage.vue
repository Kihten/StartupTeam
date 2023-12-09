<template>
  <q-page class="flex flex-center">
    <div class="q-gutter-md" v-if="!isLoading">
      <q-carousel
        v-model="slide"
        transition-prev="scale"
        transition-next="scale"
        swipeable
        animated
        control-color="white"
        navigation
        padding
        arrows
        height="300px"
        class="bg-primary text-white shadow-1 rounded-borders"
      >
        <q-carousel-slide :name="index" class="column no-wrap flex-center" v-for="(item, index) in projects" :key="index">
          <q-icon name="style" size="56px" />
          <div class="q-mt-md text-center col">
            <p>{{ item.name }}</p>
            <router-link :to="`/project/${item.id}`">Подробнее</router-link>
          </div>
        </q-carousel-slide>
      </q-carousel>
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
    await this.loadData();
    this.isLoading=false;

  },
  methods: {
    ...mapActions(useCounterStore, ['loadData']),
  },
  computed: {
    ...mapState(useCounterStore, ['projects']),
  }
}
</script>
