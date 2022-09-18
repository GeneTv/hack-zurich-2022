import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import router from '@/router'

const isSelectInput = (type) => [1, 2].includes(type);

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

  const questionId = 0;
  const type = ref(1); // 1 SC, 2 MP, 3 Freetext
  const question = ref('Onboarding Test');
  const description = ref('Please answer some questions to help us match you with the suitable programs.');
  const answers = ref([{ type: 1, id: 0, text: 'Let\'s start' }]);
  const providedAnswers = ref([]);

  const selectResponse = (answerContext) => {
    if(answerContext === null || type.value === 3) return providedAnswers.value = answerContext;

    if (isSelectInput(type.value) && !providedAnswers.value.includes(answerContext)) {
      providedAnswers.value.push(answerContext);

      // If the question is limited to 1 answer, remove the previous answer if available.
      if (type.value === 1 && providedAnswers.value.length > 1) providedAnswers.value.shift();

    } else if (isSelectInput(type.value) && providedAnswers.value.includes(answerContext)) {
      providedAnswers.value = providedAnswers.value.filter( entry => entry !== answerContext);
    }

    console.log('New evaluated answer', providedAnswers.value);
  }

  const submitResponse = async () => {
    console.debug('Submitting', providedAnswers.value, 'for type', type.value)
    try {
      // const { isOnboarding } = (await axios.get('https://f69a-212-126-165-37.eu.ngrok.io/question/')).data;
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

    } catch(e) {
      console.error('[ONBOARDING STORE]', e);
      isOnboarding.value = false;
    }

    providedAnswers.value = [];
    if(!isOnboarding) setTimeout(() => router.push('/'), 1500);
  }

  return { answers, description, isOnboarding, providedAnswers, question, selectResponse, submitResponse, type };
});
