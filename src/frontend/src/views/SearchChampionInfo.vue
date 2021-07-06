<template>
  <div>
    <template>
      <v-text-field
          v-model="championName"
          label="Search (UPPER CASE ONLY)"
          class="mx-4"
      ></v-text-field>
      <v-btn
          @click="getChampionInfo">
        submit
      </v-btn>
    </template>
    <br><br>
    <template>
      id : {{championDto}}<br>
    </template>
  </div>
</template>
<script>
import {mapActions} from "vuex";

export default {
  data() {
    return {
      championName: '',
      championDto: this.$store.state.champions.championDto,
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
    ...mapActions({getChampion: "champions/getChampionInfo"}),
    filterOnlyCapsText(value, search) {
      return value != null &&
          search != null &&
          typeof value === 'string' &&
          value.toString().toLocaleUpperCase().indexOf(search) !== -1
    },
    async getChampionInfo() {
      await this.getChampion(this.championName);
      this.championDto = this.$store.state.champions.championDto;
    }
  },
}
</script>