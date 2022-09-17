import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', () => {
  const currentOnboardingQuestion = ref(true)
  // const doubleCount = computed(() => count.value * 2)

  function quitOnboarding() {
    inOnboarding.value = false
  }

  return { currentOnboardingQuestion, goToNext }
})
