<template>
  <div class="page-wrapper">
    <div class="event-list">
  
      <div class="event-card" v-for="event in sortedEvents">
        <div class="event-rating">
          <div class="rating-text">Compatibility:</div>

          <div class="rating-stars">
            <span v-for="_ in event.matchRating">⭐</span>
          </div>
          
        </div>
        <hr>
        <div class="event-details">
          <h3 class="details-title"> {{ event.title }}</h3>
          <p class="details-description">{{ event.description }}</p>
          <div class="details-skills">
            <div class="skill-pill" v-for="skill in event.skills">{{ skill }}</div>
          </div>
        </div>
      </div>
  
    </div>
  </div>
</template>

<script>
  export default {
    data: () => ({
      events: [
        {
          title: 'HackZurich 2022',
          matchRating: 5,
          description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut, nam nulla aliquid illum veritatis. Contact me via: name@gmail.com',
          skills: ['tech', 'english']
        }, {
          title: 'Funny Farming',
          matchRating: 4,
          description: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut, nam nulla aliquid illum veritatis.',
          skills: []
        }
      ]
    }),
    computed: {
      sortedEvents() {
        return this.events.sort((a, b) => b.matchRating - a.matchRating);
      }
    }
  }
</script>

<style scoped>
h3{
  color: #635bff;
  margin-top: 10px;
}

.page-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.event-list {
  display: flex;
  flex-direction: column;
  gap: 24px;
  max-width: 1000px;
  margin: 20px 20px;
}

.event-card {
  background-color: #fff;
  border-radius: 4px;
  box-shadow: rgba(0, 0, 0, 0.05) 0px 0px 0px 1px;
  padding: 24px;
}

.event-rating {
  display: flex;
  justify-content: space-between;
  margin-bottom: 12px;
}

.rating-text {
  font-size: 14px;
}

.rating-stars {
  display: flex;
  gap: 4px;
}

.event-details {}

.details-title {
  font-size: 24px;
  margin-bottom: 2px;
}

.details-description {
  font-size: 15px;
  margin: 10px 0;
  font-weight: 400;
}

.details-skills {
  display: flex;
  gap: 4px;
}

.skill-pill{
  background-color: #635bff;
  border: none;
  border-radius: 16px;
  color: white;
  cursor: pointer;
  display: inline-block;
  font-size: 14px;
  margin: 4px 2px;
  padding: 2px 16px;
  text-align: center;
  text-decoration: none;
}

</style>