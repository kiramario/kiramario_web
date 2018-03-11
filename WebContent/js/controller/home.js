
function Home(){
	var _this = this;
	
	
	/************
	 * ajax提交
	 * postAjax
	 ************/
	var postAjax = function(postData){
		 $.ajax({
             type: "POST",
             url: "./servlet/signin",
             data: postData,
             dataType: "json",
             success: function(data){
            	 if(data['results'][0]['login']){
            		 location.href = "./html/textList.html";
            	 }
             },
             error: function(){
            	 console.log("Home error:");
             }
         });
	}
	
	
	/************
	 * 提交登陆请求
	 * submitlogin
	 ************/
	var submitlogin = function(){
		$("#loginSubmitBtn").on("click",function(){
			var postData = {};
			$(".login_wraper input[name]").each(function(index,item){
				var key = $(item).attr("name");
				var value = $(item).val();
				postData[key] = value;
			});
			postAjax(postData);
		})
	}
	
	_this.run = function(){
		submitlogin();
	}
}

var home = new Home();
home.run();