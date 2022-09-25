var popupWidth = 500;
var popupHeight = 350;
var popupX = (window.screen.width / 2) - (popupWidth / 2);
var popupY= (window.screen.height / 2) - (popupHeight / 2);

$('.find-pwd').click(function() {
  window.open('find_pwd', '비밀번호 찾기', 
  'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
  window.close();
});
