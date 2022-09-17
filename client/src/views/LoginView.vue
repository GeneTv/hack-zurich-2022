<template>
  <div class="page-wrapper">
    <div class="login-form">
      <div class="login-form__title-container">
        <h2 class="login-form__title">Hello Hacker!</h2>
        <p class="login-form__subtitle">The app requires you to log in to Spotify to continue.</p>
      </div>
      

      <div class="form-controls">
        <button @click="initSpotifyOauthFlow" class="spotify-login">
          <img src="@/assets/spotify_logo_colored.png" alt="Spotify logo" class="spotify-login__logo" />
          <span class="spotify-login__text">Connect to Spotify</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
const initSpotifyOauthFlow = () => {
  console.log('Spotify flow');
};
</script>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  background-color: #fbfbfb;
}

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

.spotify-login {
  border: none;
  border-radius: 4px;
  cursor: pointer;
  display: flex;
  gap: 8px;
  justify-content: center;
  outline: none;
  padding: 12px;
}

.spotify-login__logo {
  height: 20px;
  width: 20px;
}

.spotify-login__text {
  color: #474747;
  font-size: 14px;
  line-height: 20px;
}
</style>
