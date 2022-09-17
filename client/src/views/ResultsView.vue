<template>
  <div>

    <div class="card" v-for="event in events">
      <h3> {{ event.title }}</h3>
      <p>Based on <span>{{ event.basedSong.title }}</span></p>
    </div>

  </div>
</template>

<script>
export default {
  data: () => ({
    events: [
      {
        title: 'HackZurich 2022',
        basedSong: {
          title: 'HOT PURSUIT',
          author: 'JDSLVT'
        }
      },{
        title: 'Funny Farming',
        basedSong: {
          title: 'Eye of the tiger ',
          author: 'Survivor'
        }
      }
    ]
  })
}
</script>