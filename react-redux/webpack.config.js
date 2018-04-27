var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var UglifyJSPlugin = require('uglifyjs-webpack-plugin');
module.exports = {
    entry: {
        bundle: ['babel-polyfill','./index.js'],
		common: ['react', 'react-dom', 'react-router','react-router-dom']
    },
    output: {
        path: __dirname + '/build/',
        filename: '[name].js',
		publicPath: "./"
    },
	module: {
		loaders: [
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
		new ExtractTextPlugin('prefixer_main.css', {
		   disable: false,
		   allowChunks: true
		}),
		new webpack.optimize.CommonsChunkPlugin({
            names: ["common"]
        }),
		new UglifyJSPlugin(),
		new webpack.DefinePlugin({
			"process.env": {
				NODE_ENV: JSON.stringify("production")
			}
		})
	]
}