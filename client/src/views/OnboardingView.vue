<template>
  <div class="page-wrapper">
    <div class="container">
      <div class="onboardin-popover" v-if="isInOnboarding">
      <h3>{{ currentQuestion.title }}</h3>
      <p v-if="currentQuestion.description.length > 0">{{ currentQuestion.description }}</p>
      <div class="onboarding-answers">
        <div class="selectable" v-for="answer in currentQuestion.answers" @click="selectAnswer(answer.id)">{{ answer.text }}</div>
      </div>

      <hr>
      <p @click="goToNextQuestion(true)">I know what I want</p>
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

.container{
  background-color: #fff;
  padding: 30px;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 0px 0px 1px;
}

.onboarding-answers {
  
  display: flex;
  gap: 8px;
}
.selectable {
  background-color: #C27DFC;
  font-weight: 700;
  border: 1px solid #C27DFC;
  border-radius: 24px;
  padding: 8px;
}

h3{
  margin-bottom: 10px;
}
</style>
