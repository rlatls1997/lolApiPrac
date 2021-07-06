import Vue from "vue";
import Vuex from "vuex";
import summoners from "./modules/summoners";
import champions from "./modules/champions";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {},
    mutations: {},
    actions: {},
    modules: {summoners, champions},
});