import * as types from "../constant/actionTypes"

let initState = {
	isFetching:false,
	errcode:''
}

export default function(state = initState, action){
	let {type} = action;
	switch (type){
		case types.FETCH_INIT:
			return Object.assign({}, state, initState);
		case types.FETCH_START:
			return Object.assign({},state,{
				isFetching:true
			});
		case types.FETCH_FAILURE:
			return {...state,
				isFetching:false,
				errcode:-1
			};
		case types.FETCH_SUCCESS:
			return {...state,
				isFetching:false,
				errcode:0
			};
        default:
            return state
    }
}