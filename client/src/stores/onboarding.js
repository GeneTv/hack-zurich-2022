import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

export const useOnboardingStore = defineStore('onboarding', () => {
  const currentQuestionIndex = ref(0);
  const questions = ref([
    {
      title: 'Hello user!',
      description: 'To determine what projects may fit for you, we are going to ask some questions.',
      answers: [
        {
          id: 'ea360017-bb64-4a12-8c3c-afc202a8ba9b',
          text: 'Let\'s go!',
        }
      ],
    },

    {
      title: 'How is your mood?',
      description: '',
      answers: [
        {
          id: 'b8bd3598-051c-444a-a9da-918b14661e6b',
          text: 'Super hyped',
        },
        {
          id: '8ed9afd7-64a3-4282-8248-e9f4aec57686',
          text: 'Happy',
        },
        {
          id: 'd1d46a46-3533-4fc2-81c0-bb5e839d53c9',
          text: 'Sad',
        },
        {
          id: '013c126d-6547-4806-b2f8-279fc2b624f4',
          text: 'Suicidal',
        },
      ],
    },
  ])

  function goToNextQuestion(skip = false) {
    currentQuestionIndex.value += skip ? -(currentQuestionIndex.value + 1) : 1;
  }
  
  const isInOnboarding = computed(() => currentQuestionIndex.value < questions.value.length && currentQuestionIndex.value !== -1);
  const currentQuestion = computed(() => questions.value[currentQuestionIndex.value] || null)


  return { currentQuestion, goToNextQuestion, isInOnboarding };
});
