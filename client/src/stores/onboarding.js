import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router'

export const useOnboardingStore = defineStore('onboarding', () => {

  const isOnboarding = ref(true);

  const question = ref('You will be asked some questions');
  const description = ref('Please answer some questions to help us match you with the suitable programs.');
  const answers = ref([
    {
      type: 1,
      id: 'e5767121-cb60-4cd1-b4e5-480859b95b80',
      text: 'Let\'s start'
    }
  ]);

  const submitResponse = async (answerId) => {
    console.debug('Submitting', answerId)
    try {
      const newQuestion = (await axios.get('https://f69a-212-126-165-37.eu.ngrok.io/question/')).data;
      description.value = newQuestion.description;
      question.value = newQuestion.question;
      answers.value = newQuestion.answers;
      isOnboarding.value = newQuestion.onboarding;
    } catch(e) {
      console.error('oboarding.js error: ', e);
      isOnboarding.value = false
      setTimeout(() => router.push('/'), 1500);
    }
  }

  return { answers, description, isOnboarding, question, submitResponse };
});
