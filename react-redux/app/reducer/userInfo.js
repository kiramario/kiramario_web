import * as types from "../constant/actionTypes"

let initState = {
	wxheadImg:"",
	wxnickName:"",
	openid:""
}


export default function(state = initState, action){
	let {type,info} = action;
	
	switch (type){
		case types.USER_INFO_GET:
			return {...state,wxheadImg:info.headimgurl,wxnickName:info.nickname};
        default:
            return state
    }
}