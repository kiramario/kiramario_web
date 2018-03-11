var TextList = function(){
	var _this = this;
	
	/***********
	 * postData
	 * 运行
	 **********/
	var postData = function(data){
		if(typeof data === 'undefined'){
			var data = {}
		}
		var url = "../servlet/readebooks";
		var func = function(res){
			renderBook(res)
		}
		postAjax(url,data,func,func);
	}
	
	/***********
	 * renderBook
	 * 读出书籍进行渲染
	 **********/
	var renderBook = function(res){
		$("#filecontent .panel-body").html(res.responseText)
	}
	
	/************
	 * bindEvent
	 * 绑定事件
	 ***********/
	var bindEvent = function(){
		$("li.filename").on("click",function(){
			var data = {"filename": $(this).attr("filename")}
			postData(data);
		})
	}
	
	/******
	 * run
	 * 运行
	 *****/
	_this.run = function(){
		bindEvent();
		
	}
}


$(function(){
	var textList = new TextList();
	textList.run();
})