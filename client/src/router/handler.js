import { useOnboardingStore } from '../stores/onboarding';

export default (to, from, next) => {
  console.debug('[ROUTING]', from.fullPath, 'transition to', to.fullPath);
  const { isOnboarding } = useOnboardingStore();

  // If the user is currently onboarding, and not in one of the safe routes. Bring him back to onboarding.
  if (isOnboarding && (!['onboarding', 'login'].includes(to.name))) {
    return next('/onboarding');
  }

  // Prevent the user from visiting the onboarding once the onboarding is finished.
  if (!isOnboarding && to.name === 'onboarding') {
    return next('/');
  }
  next();
}