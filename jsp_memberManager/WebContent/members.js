/**
 * 
 */

//join.jsp에서 회원가입시 활용 메서드
function updateInfoConfirm(){
	if(document.reg_frm.pw.value==""){
		alert("패스워드를 입력하십시오");
		reg_firm.pw.focus();
		return
	}
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		
		alert("패스워드가 일치하지 않습니다");
		reg_frm.pw_check.focus();
		return
	}
	if(document.reg_frm.email.value.length==0){
		alert("메일은 필수사항입니다");
		reg_frm.email.focus();
		return
	}
	//상기조건들 모두 만족시 비로소 submit();
	document.reg_frm.submit();
}