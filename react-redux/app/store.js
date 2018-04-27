import { createStore, applyMiddleware, combineReducers, compose } from 'redux'
import thunkMiddleware from 'redux-thunk'
import * as reducers from "./reducer"
import * as types from './constant/actionTypes'



let reducer = combineReducers({
	userInfo:reducers.userInfo,
	ajaxFetch:reducers.ajaxFetch
});

// let store = createStore(
				// reducer,
				// applyMiddleware(),
				// initStore
			// )
			
let finalCreateStore = compose.apply(this, [thunkMiddleware].map(md =>
        applyMiddleware(md)))(createStore);

let store = finalCreateStore(reducer);

export default store 