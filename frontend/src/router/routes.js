
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    meta: {
      requiresAuth: true, allowedRoles: ['user', 'admin']
    },
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') },
      { path: 'project/:id', component: () => import('pages/ProjectPage.vue') },
      { path: '/:IndexPage', component: () => import('pages/PersonPage.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
