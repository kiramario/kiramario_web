var webpack = require('webpack');
var path = require('path');
var WebpackDevServer = require('webpack-dev-server');

var config = require('./webpack.config.dev.js')

new WebpackDevServer(webpack(config),{
	publicPath:'http://127.0.0.1:9090/storage',
	hot: true,
	inline : true,
	historyApiFallback: true,
}).listen(9090,'127.0.0.1',function(err, result){
	if(err){
		console.log(err)
	}else{
		console.log('Listening at 127.0.0.1:9090'); 
	}
})