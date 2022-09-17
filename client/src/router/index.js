import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import ResultsView from '../views/ResultsView.vue'
import OnboardingView from '../views/OnboardingView.vue'
import handler from './handler'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'results',
      component: ResultsView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/onboarding',
      name: 'onboarding',
      component: OnboardingView
    },
    {
      path: '/:_(.*)*',
      name: 'none',
      redirect: '/'
    }
  ]
})

router.beforeEach(handler)

export default router
