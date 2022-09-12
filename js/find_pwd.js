var popupWidth = 500;
var popupHeight = 350;
var popupX = (window.screen.width / 2) - (popupWidth / 2);
var popupY= (window.screen.height / 2) - (popupHeight / 2);

$('.find-id').click(function() {
  window.open('find_id.html', '아이디 찾기', 
  'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
  window.close();
});
