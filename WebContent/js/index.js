/*
   * 初始化页面函数
   */
  $(function(){
	  
	  /*
	   * ******************************
	   * 基本信息部分
	   * ******************************
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
				$("#show").append("姓名: &nbsp &nbsp"+data["name"] + "<br/>");
				$("#show").append("性别: &nbsp &nbsp"+data["gender"] + "<br/>");
				$("#show").append("出生日期: &nbsp &nbsp"+data["birthday"] + "<br/>");
				$("#show").append("所在城市: &nbsp &nbsp"+data["city"] + "<br/>");
				$("#show").append("邮箱地址: &nbsp &nbsp"+data["email"] + "<br/>");
				$("#show").append("手机号码: &nbsp &nbsp"+data["cellphone"] + "<br/>");
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
	  
	  
	  /*
	   ************************************* 
	   * 实习经历部分
	   * ***********************************
	   */
	  $.ajax({
		  type:"post",
		  url:"MyResume/internExp!query",
		  dataType:"json",
		  success:function(data,statusText){
			console.info(data);
			$("#internExperience").hide();
			$("#showIntern").height(180)
				.width(240)
				.empty();
			if(data != null){
				$("#showIntern").append("公司名称: &nbsp &nbsp"+data["companyName"] + "<br/>");
				$("#showIntern").append("工作职位: &nbsp &nbsp"+data["job"] + "<br/>");
				$("#showIntern").append("开始日期: &nbsp &nbsp"+data["startTime"] + "<br/>");
				$("#showIntern").append("结束日期: &nbsp &nbsp"+data["endTime"] + "<br/>");
				$("#showIntern").append("工作内容: &nbsp &nbsp"+data["jobContent"] + "<br/>");
				$("#showIntern").append("<input type='button' id='toEditInternExp' value='编辑'/>");
				$("#showIntern").show(600);
			}
		  }
	  });
	  
	  
	  //通过append生成的标签，添加动态事件，要先得到其父类标签
	  $("#showIntern").on("click","#toEditInternExp",function(){
		  //alert("edit..");
		  $("#showIntern").hide();
		  $("#internExperience").show();
	  });
  });

/*
 * ************************
 * 基本信息
 * ************************
 */
  
//提交基本信息模块
  function baseInfoSub(){
  	if(checkBaseInfo()){
  		$("#baseInfoEdit").hide();
  	  	$.post(
  	  		"MyResume/baseInfo!init",
  	  		$("#baseInfo").serialize(),//序列化表单值
  	  		function(data,statusText){
  	  			//console.info(data);
  	  			$("#show").height(180)
  	  				.width(240)
  	  				.empty();
	  	  		if(data != null){
					$("#show").append("姓名: &nbsp &nbsp"+data["name"] + "<br/>");
					$("#show").append("性别: &nbsp &nbsp"+data["gender"] + "<br/>");
					$("#show").append("出生日期: &nbsp &nbsp"+data["birthday"] + "<br/>");
					$("#show").append("所在城市: &nbsp &nbsp"+data["city"] + "<br/>");
					$("#show").append("邮箱地址: &nbsp &nbsp"+data["email"] + "<br/>");
					$("#show").append("手机号码: &nbsp &nbsp"+data["cellphone"] + "<br/>");
					$("#show").append("<input type='button' id='toEdit' value='编辑'/>");
					$("#show").show(600);
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
  function cancelBaseInfo(){
	  $("#baseInfoEdit").hide();
	  $("#show").show();
  }  

//基本信息基本表单校验  
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
  
  /*
   * *******************
   * 实习经历
   * *******************
   */
  
  function internExperienceSub(){
	  if(checkInternExp()){
	  		$("#internExperience").hide();
	  	  	$.post(
	  	  		"MyResume/internExp!init",
	  	  		$("#internExp").serialize(),//序列化表单值
	  	  		function(data,statusText){
	  	  			console.info(data);
	  	  			$("#showIntern").height(180)
	  	  				.width(240)
	  	  				.empty();
		  	  		$("#showIntern").append("公司名称: &nbsp &nbsp"+data["companyName"] + "<br/>");
					$("#showIntern").append("工作职位: &nbsp &nbsp"+data["job"] + "<br/>");
					$("#showIntern").append("开始日期: &nbsp &nbsp"+data["startTime"] + "<br/>");
					$("#showIntern").append("结束日期: &nbsp &nbsp"+data["endTime"] + "<br/>");
					$("#showIntern").append("工作内容: &nbsp &nbsp"+data["jobContent"] + "<br/>");
	  	  			$("#showIntern").append("<input type='button' id='toEditInternExp' value='编辑'/>");
	  	  			$("#showIntern").show(600);
	  	  			
	  	  		},
	  	  		//指定服务器数据为JSON
	  	  		"json");
	  	}
  }
  
  function cancelInternExp(){
	  $("#internExperience").hide();
	  $("#showIntern").show();
  }
  
  //对实习部分的简单校验
  function checkInternExp(){
	  	if(!$("#companyName").val()){
	  		alert("公司名称不能为空！");
	  		$("#companyName").focus();
	  		return false;
	  	}
	  	if(!$("#job").val()){
	  		alert("职位不能为空！");
	  		$("#job").focus();
	  		return false;
	  	}
	  	if(!$("#startTime").val()){
	  		alert("在职开始时间不能为空！");
	  		$("#startTime").focus();
	  		return false;
	  	}
	  	if(!$("#jobContent").val()){
	  		alert("工作内容不能为空！");
	  		$("#jobContent").focus();
	  		return false;
	  	}
	  	return true;
  }
  
  