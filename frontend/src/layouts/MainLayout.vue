<template >
  <q-layout view="lHh Lpr lFf">
    <q-header elevated class="justify-between" style="background: #ffffff">
      <q-toolbar>

        <div class="col-12 col-md-8">
          <q-img style="width: 120px; margin-left: 60px" :ratio="0"
            src="https://raw.githubusercontent.com/Kihten/StartupTeam/main/frontend/public/icons/logo.png" />
        </div>
        <q-btn class="absolute-right" color="blue" label="Войти" @click="loginAction"/>
      </q-toolbar>
    </q-header>
    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
  
</template>

<script >
import { defineComponent, ref } from 'vue'
import LoginDialog from 'components/LoginDialog.vue'
import { useQuasar } from 'quasar'

export default {

  components: {
  },
  data() {
    return {
      name: 'MainLayout',
     }
  },
  methods: {
    loginAction() {
        this.$q.dialog({
          component: LoginDialog
        })
      }
  },
}
</script>

