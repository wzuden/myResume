//提交基本信息模块
  function baseInfoSub(){
  	checkBaseInfo();
  	$("#baseInfo").submit();
  }

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
  	
  }