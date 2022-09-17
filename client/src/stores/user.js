import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', () => {
  const username = ref('');
  const age = ref(0);
  
  const isInOnboarding = ref(true);
  // const doubleCount = computed(() => count.value * 2)

  const setInOnboarding = (userIsInOnboarding) => {
    isInOnboarding.value = userIsInOnboarding
  }

  return {
    isInOnboarding, setInOnboarding
  }
})
