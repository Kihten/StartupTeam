<template>
    <div class="example-column-equal-width">
        <div style="height: 140px; background: #62BFAB">
            <div style="padding: 15px 450px;
                background: #62BFAB;
                color: white;
                border: 20px;
                font-size: 10px;
                text-transform: uppercase;
                font-weight: bolder">
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
            </div>
            <q-img src="https://raw.githubusercontent.com/Kihten/StartupTeam/main/frontend/public/icons/top.png"
                style="height: 110px; max-width: 110px ; margin-left: 600px; margin-top: -160px;  ">
            </q-img>
        </div>
    </div>

    <div id="q-app" style="min-height: 100vh;">
        <div class="q-pa-md row items-start q-gutter-md">
            <q-card class="my-card" flat bordered>
                <q-item>
                    <q-item-section avatar>
                        <q-avatar>
                            <img src="https://cdn.quasar.dev/img/boy-avatar.png">
                        </q-avatar>
                    </q-item-section>

                    <q-item-section>
                        <q-item-label>ФИО</q-item-label>
                        <q-item-label caption>
                            Факультет, группа
                        </q-item-label>
                    </q-item-section>
                </q-item>

                <q-separator></q-separator>

                <q-card-section horizontal>
                    <q-card-section>
                        инфа о себе
                    </q-card-section>

                    <q-separator vertical></q-separator>

                    <q-card-section class="col-4">
                        Навыки
                    </q-card-section>
                </q-card-section>
            </q-card>
        </div>
    </div>

</template>
  
<script>
import { useCounterStore } from 'stores/example-store'
import { mapActions, mapState } from 'pinia'
import { ref } from 'vue'

export default {
    data() {
        return {
            name: 'PersonPage',
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

.my-card
  width: 100%
 
.title_image
  width: 250px
  height: 250px
  margin-left: 150px
  margin-top: 80px
</style>
  