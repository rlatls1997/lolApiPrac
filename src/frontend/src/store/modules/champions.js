import axios from 'axios';

const config = {
    baseUrl : "https://ddragon.leagueoflegends.com"
}
const state = {
    apiKey: "RGAPI-eb1b239c-0262-4acd-8b54-7225611044cc",
    championDto: {}
};
const mutations = {
    setChampionDto: (state, data) => {
        state.championDto = data;
    }
};

const actions = {
    async getChampionInfo({commit}, championName){
        await axios
            .get(`${config.baseUrl}/cdn/11.13.1/data/ko_KR/champion/${championName}.json`)
            .then(response => {
                commit("setChampionDto", response.data);
                alert("성공");
            })
            .catch(error => {
                alert(error.response);
            })
    }
};
export default {
    namespaced: true,
    state,
    mutations,
    actions
}