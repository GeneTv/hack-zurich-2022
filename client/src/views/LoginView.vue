<template>
  <div class="page-wrapper">
    <div class="login-form">
      <div class="login-form__title-container">
        <h2 class="login-form__title">Hello Volunteer!</h2>
        <p class="login-form__subtitle">Please log in to continue.</p>
      </div>
      

      <div class="form-controls">

        <input type="text" v-model="username">
        <input type="text" v-model="age">

        <button @click="authenticateUser" class="linkedin-login">
          <img src="@/assets/icons/linkedin_colored.png" alt="LinkedIn logo" class="linkedin-login__logo" />
          <span class="linkedin-login__text">Sign in</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from '@vue/reactivity'

const username = ref('');
const age = ref(0);

const authenticateUser = async () => {
  if (username.value.length === 0) return;

  const auth = await axios.get('http://googlecloud.com/login');
  console.debug('[LOGIN] Logged in as', username);
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

.login-form {
  align-items: center;
  background-color: #fff;
  border-radius: 2px;
  /* box-shadow: 0px 4px 25px rgba(0, 0, 0, 0.1); */
  box-shadow: rgba(0, 0, 0, 0.05) 0px 0px 0px 1px;
  display: flex;
  flex-direction: column;
  gap: 4px;
  justify-content: center;
  max-width: 500px;
  padding: 48px 20px;
  width: 100%;
}

.login-form__title-container {
  margin-bottom: 32px;
}
.login-form__title {
  color: #578BF2;
  margin-bottom: 8px;
}
.login-form__subtitle {
  color: #ABABAC;
  font-size: 14px;
}

.linkedin-login {
  border: none;
  border-radius: 4px;
  cursor: pointer;
  display: flex;
  gap: 8px;
  justify-content: center;
  outline: none;
  padding: 12px;
}

.linkedin-login__logo {
  height: 20px;
  width: 20px;
}

.linkedin-login__text {
  color: #474747;
  font-size: 14px;
  line-height: 20px;
}
</style>
