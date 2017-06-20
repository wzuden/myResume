/*
   * 初始化页面函数
   */
  $(function(){
	  /*
	   * 通过username查询数据库，是否已经存在数据
	   * 如果存在，显示出来
	   */
	  $.ajax({
		  type:"post",
		  url:"MyResume/baseInfo!query",
		  dataType:"json",
		  success:function(data,statusText){
			//alert(data);
			$("#baseInfoEdit").hide();
			$("#show").height(180)
				.width(240)
				.empty();
			if(data != null){
				for(var par in data)
				{
					if(par=="name"){
						$("#show").append("姓名: &nbsp &nbsp"+data[par] + "<br/>");
					}else if(par=="gender"){
						$("#show").append("性别: &nbsp &nbsp"+data[par] + "<br/>");
					}else if(par=="birthday"){
						$("#show").append("出生日期: &nbsp &nbsp"+data[par] + "<br/>");
					}else if(par=="city"){
						$("#show").append("所在城市: &nbsp &nbsp"+data[par] + "<br/>");
					}else if(par=="email"){
						$("#show").append("邮箱地址: &nbsp &nbsp"+data[par] + "<br/>");
					}else if(par=="cellphone"){
						$("#show").append("手机号码: &nbsp &nbsp"+data[par] + "<br/>");
					}
				}
				$("#show").append("<input type='button' id='toEdit' value='编辑'/>");
				$("#show").show(600);
			}
			
		  }
	  });
	  
	  //通过append生成的标签，添加动态事件，要先得到其父类标签
	  $("#show").on("click","#toEdit",function(){
		  //alert("edit..");
		  $("#show").hide();
		  $("#baseInfoEdit").show();
	  });
  });


//提交基本信息模块
  function baseInfoSub(){
  	if(checkBaseInfo()){
  		$("#baseInfoEdit").hide();
  	  	$.post(
  	  		"MyResume/baseInfo!init",
  	  		$("#baseInfo").serialize(),//序列化表单值
  	  		function(data,statusText){
  	  			$("#show").height(180)
  	  				.width(240)
  	  				.empty();
  	  			for(var par in data)
  	  			{
  	  				if(par=="name"){
  	  					$("#show").append("姓名: &nbsp &nbsp"+data[par] + "<br/>");
  	  				}else if(par=="gender"){
  	  					$("#show").append("性别: &nbsp &nbsp"+data[par] + "<br/>");
  	  				}else if(par=="birthday"){
  	  					$("#show").append("出生日期: &nbsp &nbsp"+data[par] + "<br/>");
  	  				}else if(par=="city"){
  	  					$("#show").append("所在城市: &nbsp &nbsp"+data[par] + "<br/>");
  	  				}else if(par=="email"){
  	  					$("#show").append("邮箱地址: &nbsp &nbsp"+data[par] + "<br/>");
  	  				}else if(par=="cellphone"){
  	  					$("#show").append("手机号码: &nbsp &nbsp"+data[par] + "<br/>");
  	  				}
  	  			}
  	  			$("#show").append("<input type='button' id='toEdit' value='编辑'/>");
  	  			$("#show").show(600);
  	  			
  	  		},
  	  		//指定服务器数据为JSON
  	  		"json");
  	}
  }
  
  /*
   * 取消按钮，返回显示页面
   */
  function cancel(){
	  $("#baseInfoEdit").hide();
	  $("#show").show();
  }
  

//表单校验  
  function checkBaseInfo(){
  	if(!$("#name").val()){
  		alert("姓名不能为空！");
  		$("#name").focus();
  		return false;
  	}
  	if(!$("#datepicker").val()){
  		alert("出生日期不能为空！");
  		$("#datepicker").focus();
  		return false;
  	}
  	if(!$("#city").val()){
  		alert("城市不能为空！");
  		$("#city").focus();
  		return false;
  	}
  	if(!$("#cellphone").val()){
  		alert("手机号不能为空！");
  		$("#cellphone").focus();
  		return false;
  	}
  	if(!$("#email").val()){
  		alert("邮箱不能为空！");
  		$("#email").focus();
  		return false;
  	}
  	return true;
  }