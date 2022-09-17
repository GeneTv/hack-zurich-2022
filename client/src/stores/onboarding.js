import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router'


let currentFakeQuestion = -1;
const fakeQuestions = [
  {
    id: 1,
    type: 1,
    title: 'Question1?',
    description: '',
    answers: [
      {
        id: 3827839,
        text: 'Yes'
      },{
        id: 28738,
        text: 'No'
      },{
        id: 1752,
        text: 'Maybe'
      },
    ]
  },{
    id: 2,
    type: 2,
    title: 'Question2?',
    description: '',
    answers: [
      {
        id: 81727,
        text: 'Yes'
      },{
        id: 9172,
        text: 'No'
      }
    ]
  },{
    id: 3,
    type: 3,
    title: 'How do you feel?',
    description: 'Input a text'
  }
];


export const useOnboardingStore = defineStore('onboarding', () => {
  const isOnboarding = ref(true);

  const question = ref('Onboarding Test');
  const description = ref('Please answer some questions to help us match you with the suitable programs.');
  const type = ref(1); // 1 SC, 2 MP, 3 Freetext
  const answers = ref([
    {
      type: 1,
      id: 'e5767121-cb60-4cd1-b4e5-480859b95b80',
      text: 'Let\'s start'
    }
  ]);

  let providedAnswers = [];
  const selectResponse = (answerContext) => {

    if ([1, 2].includes(type.value) && !providedAnswers.includes(answerContext)) {
      providedAnswers.push(answerContext);
      if (type.value === 1 && providedAnswers.length > 1) {
        providedAnswers.shift();
      }

    } else if ([1, 2].includes(type.value) && providedAnswers.includes(answerContext)) {
      providedAnswers = providedAnswers.filter( entry => entry !== answerContext);
    }

    if(type === 3) {
      providedAnswers = answerContext;
    }

    console.log('New evaluated answer', providedAnswers);
  }

  const submitResponse = async () => {
    console.debug('Submitting', providedAnswers, 'for type', type.value)
    try {
      // const newQuestion = (await axios.get('https://f69a-212-126-165-37.eu.ngrok.io/question/')).data;
      // description.value = newQuestion.description;
      // question.value = newQuestion.question;
      // answers.value = newQuestion.answers;
      // isOnboarding.value = newQuestion.onboarding;


      // Fake the data
      currentFakeQuestion += 1;
      isOnboarding.value = currentFakeQuestion < fakeQuestions.length;
      const newQuestion = fakeQuestions[currentFakeQuestion];
      description.value = newQuestion.description;
      question.value = newQuestion.title;
      answers.value = newQuestion.answers;
      type.value = newQuestion.type;

      providedAnswers = []

    } catch(e) {
      console.error('oboarding.js error: ', e);
      isOnboarding.value = false
    }

    if(!isOnboarding) setTimeout(() => router.push('/'), 1500);
  }

  return { answers, description, isOnboarding, question, selectResponse, submitResponse };
});
