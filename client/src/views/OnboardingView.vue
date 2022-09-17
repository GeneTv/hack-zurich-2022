<template>
  <div class="page-wrapper">
    <div class="container">
      <div class="onboardin-popover" v-if="isOnboarding">
        <h3 class="question">{{ question }}</h3>
        <p class="description" v-if="description?.length > 0">{{ description }}</p>
        <div class="onboarding-answers">
          <button class="answer-button" v-for="answer in answers" @click="selectResponse(answer.id)">{{ answer.text }}</button>
        </div>

        <p @click="selectResponse(null)" class="onboarding-skip-button">I know what I want</p>

        <button @click="submitResponse">Submit</button>
      </div>

      <div v-else>
        <h2>You're all set!</h2>
        <p>You will be redirected shortly.</p>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { useOnboardingStore } from '../stores/onboarding';

// User should not be able to open this page while not in onboarding

export default {
  computed: {
    ...mapState(useOnboardingStore, { answers: 'answers', description: 'description', isOnboarding: 'isOnboarding', question: 'question' }),
  },
  methods: {
    ...mapActions(useOnboardingStore, { selectResponse: 'selectResponse', submitResponse: 'submitResponse' }),
  },
};
</script>

<style scoped>
.page-wrapper {
  align-items: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  min-height: 100vh;
}

.container {
  background-color: #fff;
  padding: 30px;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 0px 0px 1px;
}

.onboarding-answers {
  display: flex;
  gap: 8px;
  justify-content: space-evenly;
  padding: 26px 0 18px;
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

.description {
  font-size: 15px;
}

.onboarding-skip-button {
  color: #333;
  cursor: pointer;
  font-size: 14px;
  text-align: center;
  text-decoration: underline;
}
</style>
