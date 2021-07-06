const path = require("path");

module.exports = {
    transpileDependencies: ['vuetify'],

    devServer: {
        proxy: {
            "/": {
                target: "https://kr.api.riotgames.com/",
                ws: true,
                changeOrigin: true
            }
        },
        port: 9000
    },
    outputDir: path.resolve("__dirname", "../../main/resources/static"),
};
