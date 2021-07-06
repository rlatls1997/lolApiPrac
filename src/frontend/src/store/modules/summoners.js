import axios from 'axios';

const config = {
    baseUrl : "/lol/summoner/v4"
}
const state = {
    apiKey: "RGAPI-eb1b239c-0262-4acd-8b54-7225611044cc",
    summonerDto: {},
};
const mutations = {
    setSummonerDto: (state, data) => {
        state.summonerDto = data;
    },
};

const actions = {
    async getSummonerByName({commit}, summonerName) {
        let isSuccess = true;
        await axios
            .get(`${config.baseUrl}/summoners/by-name/${summonerName}`, {
                headers: {"X-Riot-Token": `${state.apiKey}`},
            })
            .then(response => {
                commit("setSummonerDto", response.data);
                alert("성공");
            })
            .catch(error => {
                alert(error.response);
                console.log(error);
                isSuccess = false;
            });
        return isSuccess
    }
};
export default {
    namespaced: true,
    state,
    mutations,
    actions
}