const path = require("path");

module.exports = {
    transpileDependencies: ['vuetify'],

    devServer: {
        proxy: {
            "/lol/summoner/v4": {
                target: "https://kr.api.riotgames.com/",
                ws: true,
                changeOrigin: true
            },
            "/https://ddragon.leagueoflegends.com": {
                target: "https://ddragon.leagueoflegends.com",
                ws: true,
                changeOrigin: true
            }
        },
        port: 9000
    },
    outputDir: path.resolve("__dirname", "../../main/resources/static"),
};
