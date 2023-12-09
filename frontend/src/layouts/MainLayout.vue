<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated class="justify-between">
      
      
        <q-toolbar>
          <router-link to="/">
          <q-icon
            name="home"
            size="lg"/>
          </router-link>

        <q-toolbar-title>
          StudUp
        </q-toolbar-title>

        <div>StudUp v0.0.1-alpha</div>
        <q-btn class="q-mx-sm" color="positive" label="Войти" @click="loginAction"/>
      </q-toolbar>
    </q-header>
    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import { defineComponent, ref } from 'vue'
import LoginDialog from 'components/LoginDialog.vue'
import { useQuasar } from 'quasar'

export default defineComponent({
  name: 'MainLayout',

  components: {
  },

  setup () {
    
    const $q=useQuasar();
    const leftDrawerOpen = ref(false)

    return {
      leftDrawerOpen,
      loginAction() {
        $q.dialog({
          component: LoginDialog
      }).onOk(() => {
        // console.log('OK')
      }).onCancel(() => {
        // console.log('Cancel')
      }).onDismiss(() => {
        // console.log('I am triggered on both OK and Cancel')
      })
      }
    }
  }
})
</script>
