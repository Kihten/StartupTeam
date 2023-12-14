import { Notify } from 'quasar'
import { axios } from './axios'

const notifyAuthenticationError = (message) => Notify.create({
  color: 'negative',
  position: 'top',
  icon: 'report_problem',
  message: `Error de autentificación: ${message || 'Por favor revisa tus permisos'}`
})

function validateAxiosAuthHeader (to, from, next) {
  const jsonWebToken = localStorage.getItem('token')

  if (jsonWebToken) {
    localStorage.setItem('token', jsonWebToken)
    axios.setJsonWebToken(jsonWebToken)
  }

  next()
}

// to, from and next and route objects (see https://router.vuejs.org/api/#the-route-object)
// router.matched or to.matched
//   returns an Array containing route records for
//   all nested path segments of the current route.
// Array.prototype.some()
//   tests whether at least one element in the array passes the test implemented by the provided function.
function validateRouteAuthentication (to, from, next) {
  const requiresAuthorization = to.matched.some(route => route.meta.requiresAuth)
  const jsonWebToken = localStorage.getItem('token')

  // this route requires auth
  if (requiresAuthorization) {
    if (jsonWebToken) {
      return next()
    } else {
      const redirect = {
        path: '/login',
        query: { redirect: to.fullPath }
      }

      console.log(`validateRouteAuthentication failed, redirecting to ${redirect.path} (trying to access ${redirect.query.redirect})`)
      notifyAuthenticationError('Por favor inicia sesión con tus credenciales de Softtek')
      return next(redirect)
    }
  }

  // route doesn't require authentication
  return next()
}

function validateRouteAuthorization (to, from, next) {
  const requiresAuthorization = to.matched.some(route => route.meta.allowedRoles)
  const user = JSON.parse(localStorage.getItem('user'))

  // this route requires auth
  if (requiresAuthorization) {
    for (var i = 0; i < to.matched.length; i++) {
      const route = to.matched[i]

      if (route.allowedRoles) {
        const userHasValidRole = route.meta.allowedRoles.some(allowedRole => user.roles.some(userRole => userRole === allowedRole))

        if (userHasValidRole) {
          return next()
        } else {
          const redirect = {
            path: '/login',
            query: { redirect: to.fullPath }
          }

          console.log(`validateRouteAuthorization failed, redirecting to ${redirect.path} (trying to access ${redirect.query.redirect})`)
          notifyAuthenticationError('No autorizado')
          return next(redirect)
        }
      }
    }
  }

  // route doesn't require authentication
  return next()
}

// leave the export, even if you don't use it
export default ({ app, router, Vue }) => {
  router.beforeEach(validateAxiosAuthHeader)
  router.beforeEach(validateRouteAuthentication)
  router.beforeEach(validateRouteAuthorization)
}