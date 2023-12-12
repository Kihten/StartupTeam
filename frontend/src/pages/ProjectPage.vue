<template>
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
        <q-img src="https://raw.githubusercontent.com/Kihten/StartupTeam/main/frontend/public/icons/top.png" style="height: 250px; max-width: 250px ; margin-left: 250px;
        margin-right: 50px;  margin-top: -230px;  ">
        </q-img>
      </div>
    </div>
  </div>


  <div id="q-app" style="min-height: 100vh;">
    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card" flat bordered>
        <q-card-section horizontal>
          <q-card-section class="col-8 flex">
            <q-img class="title_image rounded-borders" :src="project.image"></q-img>
          </q-card-section>
          <q-card-section class="q-pt-xs">
            <div class="text-h5" style="margin-left: -600px; text-align:center">{{ project.name }}</div>
            <div class="text-overline q-mt-sm q-mb-xs" style="margin-left: -400px; margin-top: 40px;font-size: 20px">
              Цель: {{ project.target }}</div>
            <div class="text-caption" style="margin-left: -400px; 
          margin-top: 30px;
          font-size: 15px;
          white-space: ;
          font-style: italic">
              Задачи: {{ project.tasks }}
            </div>
            <div class="text-caption" style="margin-left: -400px; text-align:center;">Автор: {{ project.author }}</div>
          </q-card-section>
        </q-card-section>
        <q-card-actions>
          <q-btn label="Присоединиться" color="#cee5de" text-color="black" style="margin-left: 500px;"
            @click="alert = true">
          </q-btn>
          <q-dialog v-model="alert">
            <q-card>
              <q-card-section>
                <div class="text-h6">Поздравляем!</div>
              </q-card-section>

              <q-card-section class="q-pt-none">
                Вы присоединились к команде. В ближайшее время с вами свяжется автор проекта.
              </q-card-section>

              <q-card-actions align="right">
                <q-btn flat label="OK" color="primary" v-close-popup></q-btn>
              </q-card-actions>
            </q-card>
          </q-dialog>
          <q-btn flat round color="red" icon="favorite"></q-btn>
          <q-btn flat round color="teal" icon="bookmark"></q-btn>
          <q-btn flat round color="primary" icon="share"></q-btn>
        </q-card-actions>
      </q-card>
      <q-inner-loading :showing="isLoading" label="Please wait..." label-class="text-teal"
        label-style="font-size: 1.1em" />
    </div>
  </div>
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

export default {
  data() {
    return {
      name: 'IndexPage',
      slide: ref(0),
      isLoading: false,
      lorem: 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Itaque voluptatem totam, architecto cupiditate officia rerum, error dignissimos praesentium libero ab nemo.',
    }
  },
  async beforeMount() {
    this.isLoading = true;
    await this.loadProject(this.$route.params.id);
    this.isLoading = false;

  },
  setup() {
    return {
      alert: ref(false)
    }
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
.example-column-equal-width
  .column > div
    padding: 30px 400px
    background: #62BFAB
    color: white
    border: 10px
    font-size: 20px
    text-transform: uppercase
    font-weight: bolder

.title_image
  width: 250px
  height: 250px
  margin-left: 150px
  margin-top: 80px

.my-card
  width: 100%
  margin-bottom: 0px
  
</style>