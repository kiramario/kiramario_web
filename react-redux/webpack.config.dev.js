var webpack = require('webpack')
var ExtractTextPlugin = require('extract-text-webpack-plugin')
// var HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
	entry: {
		bundle:['webpack-dev-server/client?http://127.0.0.1:9090','webpack/hot/dev-server','babel-polyfill','./index.js']
	},

	output: {
		path: __dirname + '/build/',
		filename:'bundle.js',
		publicPath: './'
	},
	module:{
		loaders:[
			{
				test: /\.js$/,			
				loader:'babel-loader',
				exclude: /node_modules/
			},
			{
				test: /\.css$/,
				loader: ExtractTextPlugin.extract("css-loader","style-loader")
			},
			{
				test: /\.(png|jpg)$/,
				loader: 'url-loader?limit=8192&name=distImg/[name].[ext]'
			}
		]
	},
	plugins:[
		// new HtmlWebpackPlugin({
			// template: './main.html'
		// }),
		new ExtractTextPlugin('prefixer_main.css', {
			disable: false,
			allowChunks: true
		}),
		new webpack.HotModuleReplacementPlugin()
	]
}