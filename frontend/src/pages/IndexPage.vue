<template>
  <q-page >
    <div class="q-gutter-md" v-if="!isLoading">
      <div class="example-column-equal-width">
        <div class="column" style="height: 280px">
          <div class="col" style="background: #62BFAB">
            <div class="text-left ">
            Расширение
            </div>
            <div class="text-left ">
            возможностей 
            </div>
            <div class="text-left ">
            завтрашнего 
            </div>
            <div class="text-left ">
            дня: 
            </div>
            <div class="text-left ">
            объединение
            </div>
            <div class="text-left ">
            студентов для
            </div>
            <div class="text-left ">
            успеха 
            </div>
            <q-img 
              src="https://raw.githubusercontent.com/Kihten/StartupTeam/main/frontend/public/icons/top.png"
               style="height: 250px; max-width: 250px ; margin-left: 250px;
        margin-right: 50px;  margin-top: -230px;  ">
            </q-img>
          </div>
        </div>
      </div>
      <q-input dense outlined square v-model="search" placeholder="Поиск"  
        style="width: 450px;  margin-left: 450px; background: #b2b9b8"  />
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
<style lang="sass">
.example-column-equal-width
  .column > div
    padding: 30px 400px
    background: #62BFAB
    color: white
    border: 10px
    font-size: 20px
    text-transform: uppercase
    font-weight: bolder
  .column + .column

</style>