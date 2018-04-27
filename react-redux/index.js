import React,{Component} from 'react'
import {render} from 'react-dom'

import { Provider } from 'react-redux'
import store from './app/store'
import {fetchUserInfo} from "./app/actions/Operation"
require("./css/main.css")

import App from "./app/component/App"


const AppMain = document.getElementById("main");


// console.log(store.getState())

const unsubscribe = store.subscribe(() =>
  console.log("subscribe: ",store.getState())
)


let openid = (window.location.search).match(/\?openid=(.*)/)[1];	//参数通过url带过来
// console.log(openid)

render(
	<Provider store={store}>
		<App />
	</Provider>,
	AppMain
)

if (document.addEventListener) {
	document.addEventListener('DOMContentLoaded', function () {		
		store.dispatch(fetchUserInfo(openid))
	}, false)
}
//兼容IE
else if (document.attachEvent) {
	document.attachEvent('onreadystatechange', function () {
		if (document.readyState == "complete") {
			document.detachEvent("onreadystatechange", arguments.callee);
			alert("ie begin");
		}
	});
}else if (document.lastChild == document.body) {
	alert("i do not know")
}


















