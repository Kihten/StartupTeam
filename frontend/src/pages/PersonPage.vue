<template>
    <div class="example-column-equal-width">
        <div class="column" style="height: 140px">
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
                <q-img src="https://raw.githubusercontent.com/Kihten/StartupTeam/main/frontend/public/icons/top.png" style="height: 110px; max-width: 110px ; margin-left: 200px;
          margin-right: 50px;  margin-top: -120px;  ">
                </q-img>
            </div>
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

}
</script>
  
<style lang="sass">
.example-column-equal-width
  .column > div
    padding: 15px 450px
    background: #62BFAB
    color: white
    border: 20px
    font-size: 10px
    text-transform: uppercase
    font-weight: bolder

</style>