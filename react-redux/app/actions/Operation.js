import * as types from  '../constant/actionTypes'

export const fetchPost = function(){
	
	return function(dispatch){
		dispatch(submitAns())
		
		// fetch("/search/project/", {
		  // method: "POST",
		  // headers: {
			// 'Content-Type': 'application/x-www-form-urlencoded'
		  // },
		  // body: "q=参数q"
		// }).then(function(response) {

		// });
	}
}


export const fetchOP = function(op){
	switch(op){
		case 'start':
			return { type:types.FETCH_START};
		case 'failure':
			return { type:types.FETCH_FAILURE};
		case 'success':
			return { type:types.FETCH_SUCCESS};
		default:
			return { type:types.FETCH_INIT};
	}
}

/* *******************USER INFO S******************* */
export const UpdateUserInfo = function(info){
	return {
		type:types.USER_INFO_GET,
		info
	}
}

export const fetchUserInfo = function(openid){
	const asyncFetchWxInfo = async function(openid,dispatch){
		let info = await fetch("http://www.kiramario.com/kw/s/wb/getUserInfo?openid="+openid);
		info.json().then(v=>{
			if(v['errcode']){
				throw new Error(v['errmsg']);
			}else{
				dispatch(fetchOP('success'));
				dispatch(UpdateUserInfo(v));
			}
		}).catch((e) => {
			console.log(e)
			dispatch(fetchOP('failure'));
		}).finally(()=>{
			dispatch(fetchOP());
		})
	}

	return function(dispatch){
		dispatch(fetchOP('start'))
		
		
		asyncFetchWxInfo(openid,dispatch)
	}
}


/* *******************USER INFO E******************* */