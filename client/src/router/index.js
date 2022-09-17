import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import ResultsView from '../views/ResultsView.vue'
import OnboardingView from '../views/OnboardingView.vue'

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
      path: '/flow1',
      name: 'onboarding',
      component: OnboardingView
    }
  ]
})

export default router
