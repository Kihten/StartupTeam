<template>
  <q-dialog ref="dialog" @hide="onDialogHide" >
    <q-card style="border-radius: 15px;"  class="q-dialog-plugin q-pa-xl">
      <q-img style="width: 120px; margin-left: 100px; margin-top: -20px" :ratio="0"
            src="https://raw.githubusercontent.com/Kihten/StartupTeam/main/frontend/public/icons/logo.png" />
      <q-input style="margin-top: 30px;" outlined v-model="text" label="Логин" />
      <q-input style="margin-top: 30px;" v-model="password" label="Пароль" filled :type="isPwd ? 'password' : 'text'" hint="Восстановить">
        <template v-slot:append>
          <q-icon
            :name="isPwd ? 'visibility_off' : 'visibility'"
            class="cursor-pointer"
            @click="isPwd = !isPwd"
          />
        </template>
      </q-input>
      <q-card-actions style="margin-top: 30px;" align="right">
        <q-btn  :to="`/PersonPage`" color="teal-5" label="Войти"  />
        <q-btn color="teal-5" label="Зарегистрироваться" @click="onDialogCancel" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>

<script>
import PersonPage from 'src/pages/PersonPage.vue'

export default {
  props: {
    // ...your custom props
  },

  emits: [
    // REQUIRED
    'ok', 'hide'
  ],

  methods: {
    // following method is REQUIRED
    // (don't change its name --> "show")
    show () {
      this.$refs.dialog.show()
    },

    // following method is REQUIRED
    // (don't change its name --> "hide")
    hide () {
      this.$refs.dialog.hide()
    },

    onDialogHide () {
      // required to be emitted
      // when QDialog emits "hide" event
      this.$emit('hide')
    },

    onOKClick () {
      // on OK, it is REQUIRED to
      // emit "ok" event (with optional payload)
      // before hiding the QDialog
      this.$emit('ok')
      // or with payload: this.$emit('ok', { ... })

      // then hiding dialog
      this.hide()
    },

    onCancelClick () {
      // we just need to hide the dialog
      this.hide()
    }
  }
}
</script>