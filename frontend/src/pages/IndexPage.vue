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
      <q-input rounded outlined v-model="text" label="Поиск"
        style="width: 450px;  margin-left: 450px; background: #cee5de; border-radius: 30px;">
        <template v-slot:append>
          <q-icon name="search" />
        </template>
      </q-input>
    
      
        <q-carousel
        v-model="slide"
        transition-prev="scale"
        transition-next="scale"
        swipeable
        animated
        control-color="black"
        navigation
        padding
        arrows
        height="250px"
        class="text-black"
      >
        <q-carousel-slide style="background-color: #cee5de;" :name="index" class="no-wrap flex-center" v-for="(item, index) in projects" :key="index">
          <div class="q-mt-md text-center col" >
            <q-img :src="item.image" style="width:190px; height:190px;border-radius: 50%; left: -400px; margin-top: -10px;"></q-img>
            <h6 style="margin-left: 300px; margin-top: -120px;">{{ item.description }} </h6>
            <router-link style="margin-inline-start: 300px;" :to="`/project/${item.id}`">Подробнее</router-link>
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

  <div style="columns: 4;  column-gap: 40px; margin-top: 40px; margin-left: 80px;">
    <b>Контакты</b>
    <p>644050, Российская федерация, город Омск, пр-т Мира д.11</p>
    <p>+7 (3812) 65-34-07 </p>
    <p>info@omgtu.ru</p>
    <b>Приемная комиссия</b>
    <p>+7 800-201-00-55</p>
    <p>+7 (3812) 72-90-55</p>
    <p>pk@omgtu.ru</p>
    <p>priem@omgtu.ru</p>
    <b>Управление внешних связей</b>
    <p>+7 (3812) 62-32-57</p>
    <p>+7 800 53-12-57</p>
    <p>press_omgtu@mail.ru</p>
    <p>644050</p>
    <b>Техническая поддержка</b>
    <p>webdev@omgtu.ru</p>
    <p>+7 800 62-98-34</p>
    <p>+7 (3812) 44-90-25</p>
    <p>tecno_omgtu@mail.ru</p>

  </div>


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
  },
  setup () {
    return {
      search: ref('')
    }
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

</style>