$('.btnCancel').click(function() {
  location.href = 'userinfo';
})
$('.btnDelete').click(function() {
  if(!$("input:checked[id='check_agree']").is(":checked")){
    alert('탈퇴동의에 체크해주세요.');
    return false;
  }
  if($("input:password[name='password']").val()==""){
    alert('현재 비밀번호를 입력해주세요.');
    return false;
  }
})
