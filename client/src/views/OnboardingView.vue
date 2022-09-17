<template>
  <div class="page-wrapper">
    <div class="container">
      <div class="onboardin-popover" v-if="isInOnboarding">
      <h3 class="question">{{ currentQuestion.title }}</h3>
      <p v-if="currentQuestion.description.length > 0">{{ currentQuestion.description }}</p>
      <div class="onboarding-answers">
        <button class="answer-button" v-for="answer in currentQuestion.answers" @click="selectAnswer(answer.id)">{{ answer.text }}</button>
      </div>

      <hr>
      <p @click="goToNextQuestion(true)" class="onboarding-skip-button">I know what I want</p>
      </div>
      <h2 v-else>Onboarding complete!</h2>
    </div>
    
  </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useOnboardingStore } from '../stores/onboarding';

export default {
  computed: {
    ...mapState(useOnboardingStore, { isInOnboarding: 'isInOnboarding', currentQuestion: 'currentQuestion' })
  },
  methods: {
    ...mapActions(useOnboardingStore, { goToNextQuestion: 'goToNextQuestion' }),
    selectAnswer(answerId) {
      alert('user selected ' + answerId);
      this.goToNextQuestion();
    }
  }
};
</script>

<style>
body {
  background-color: #EAEBED;
}

.container {
  background-color: #fff;
  padding: 30px;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 0px 0px 1px;
}

.question {
  margin-bottom: 10px;
}

.onboarding-answers {
  display: flex;
  gap: 8px;
  margin: 18px;
}
.answer-button {
  background-color: rgb(0, 72, 255);
  border: none;
  border-radius: 18px;
  color: #fff;
  cursor: pointer;
  font-weight: 500;
  padding: 10px;
}

.onboarding-skip-button {
  color: #333;
  cursor: pointer;
  font-size: 14px;
  text-align: center;
  text-decoration: underline;
}
</style>
