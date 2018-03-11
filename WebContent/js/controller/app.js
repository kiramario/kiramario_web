/*
 * 公共方法
 */


function postAjax(url,data,func,errFuc){
	if (typeof errFuc === 'undefined'){
		var errFuc = function(res){}
	}
	if (typeof func === 'undefined'){
		var func = function(res){}
	}
	var ajaxHandler = $.ajax({
		type: 'POST',
		dataType: "json",
		url: url,
		data: data,
		contentType:'application/x-www-form-urlencoded; charset=UTF-8',
		success: function(res){
			func(res)
		},
		error: function(res){
			errFuc(res)
		},
		complete: function(){}
	});
}