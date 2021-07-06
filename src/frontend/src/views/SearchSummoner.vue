<template>
  <div>
    <template>
      <v-text-field
          v-model="summonerName"
          label="Search (UPPER CASE ONLY)"
          class="mx-4"
      ></v-text-field>
      <v-btn
          @click="searchByName">
        submit
      </v-btn>
    </template>
    <br><br>
    <template>
      id : {{summonerDto.id}}<br>
      accountId : {{summonerDto.accountId}}<br>
      puuid : {{summonerDto.puuid}}<br>
      name : {{summonerDto.name}}<br>
      profileIconId : {{summonerDto.profileIconId}}<br>
      revisionDate : {{summonerDto.revisionDate}}<br>
      summonerLevel : {{summonerDto.summonerLevel}}<br>
    </template>
  </div>
</template>
<script>
import {mapActions} from "vuex";

export default {
  data() {
    return {
      summonerName: '',
      summonerDto: this.$store.state.lol.summonerDto,
    }
  },
  computed: {
    headers() {
      return [
        {
          text: 'Dessert (100g serving)',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        {
          text: 'Calories',
          value: 'calories',
          filter: value => {
            if (!this.calories) return true

            return value < parseInt(this.calories)
          },
        },
        {text: 'Fat (g)', value: 'fat'},
        {text: 'Carbs (g)', value: 'carbs'},
        {text: 'Protein (g)', value: 'protein'},
        {text: 'Iron (%)', value: 'iron'},
      ]
    },
  },
  methods: {
    ...mapActions({getSummonerByName: "lol/getSummonerByName"}),
    filterOnlyCapsText(value, search) {
      return value != null &&
          search != null &&
          typeof value === 'string' &&
          value.toString().toLocaleUpperCase().indexOf(search) !== -1
    },
    async searchByName() {
      await this.getSummonerByName(this.summonerName);
      this.summonerDto = this.$store.state.lol.summonerDto
    }
  },
}
</script>