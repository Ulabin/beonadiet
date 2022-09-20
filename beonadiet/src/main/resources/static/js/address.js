var popupWidth = 500;
var popupHeight = 500;
var popupX = (window.screen.width / 2) - (popupWidth / 2);
var popupY= (window.screen.height / 2) - (popupHeight / 2);

function showPopupAdd() {
  window.open('adr_popup.html', '배송지 추가', 
  'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
}

function showPopupMod() {
  window.open('adr_modify.html', '배송지 수정', 
  'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
}