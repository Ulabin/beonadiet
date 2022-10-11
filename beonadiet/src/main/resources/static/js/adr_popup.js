$('.btn-search').click(function() {

  new daum.Postcode({
    oncomplete: function(data) { //선택시 입력값 세팅
        document.getElementById("adrMain").value = data.address; // 주소 넣기
        // document.querySelector("input[name=adrSub]").focus(); //상세입력 포커싱
        document.getElementById("adrSub").focus(); //상세입력 포커싱
    }
  }).open();

});

$('.btn-send').click(function() {
  
  if($('#receiverName').val()==""){
    alert("받는 분 이름을 입력해주세요.")
    $('#receiverName').focus();
    return false;
  }
  if($('#receiverPhone').val()==""){
    alert("연락처를 입력해주세요.")
    $('#receiverPhone').focus();
    return false;
  }

  if($('#adrMain').val()==""){
    alert("검색 버튼을 눌러 주소를 입력해주세요.")
    return false;
  }
  
  if($('#adrSub').val()==""){
    alert("나머지 주소를 입력해주세요.")
    $('#adrSub').focus();
    return false;
  }
});

$('#btn_exit').click(function() {
  opener.location.reload();
  window.close();
});
function fn_onClose(){
  $('#btn_exit').click();
}
  // btnClose 버튼이 종료 이벤트 호출}
  window.onbeforeunload = fn_onClose;
