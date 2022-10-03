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
  
  if($('#adrMain').val()==""){
    alert("검색 버튼을 눌러 주소를 입력해주세요.")
    return false;
  }
  
  if($('#adrSub').val()==""){
    alert("나머지 주소를 입력해주세요.")
    $('#adrSub').focus();
    return false;
  }

  var result='';
  $('input[name=address]').map(function(){
    result +=($(this).val()+" ");
  });
  alert(result);
  document.getElementById("adr_all").value = result;

});
