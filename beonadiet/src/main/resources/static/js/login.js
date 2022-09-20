$('#signin').on('submit',()=>{
  let idVal = $('#username').val();
  let idCheck = /^(?=.*[a-z])(?=.*[0-9])/;
  let pwdVal = $('#password').val();
  let pwdCheck = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;

  if(!idCheck.test(idVal)) {
    alert('아이디는 영어소문자, 숫자로 입력하세요.');
    $('#username').focus();
    return false;
  }
  if (!pwdCheck.test(pwdVal)){
    alert('비밀번호는 영대소문자,숫자,특수문자로 구성된 8글자 이상으로 입력하세요.');
    $('#password').focus();
    return false;
  } 

})

var popupWidth = 500;
var popupHeight = 350;
var popupX = (window.screen.width / 2) - (popupWidth / 2);
var popupY= (window.screen.height / 2) - (popupHeight / 2);

$('.find_id').click(function() {
  window.open('find_id.html', '아이디찾기', 
  'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
});

$('.find_pw').click(function() {
  window.open('find_pwd.html', '비밀번호 찾기', 
  'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
});
