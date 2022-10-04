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

//   setTimeout(function() {   
//     opener.location.reload();
//     window.close();
//  }, 5000);


  // var result='';
  // $('input[name=address]').map(function(){
  //   result +=($(this).val()+" ");
  // });
  // alert(result);
  // document.getElementById("adr_all").value = result;


  // $('#send_form').submit();
  // setTimeout(function() {   
  //     opener.location.reload();
  //     window.close();
  //  }, 500);


  // var form = $("#send_form").serialize();
  // $.ajax({
  //   type: "POST",
  //   url: "http://localhost:8081/beonadiet/mypage/adr_popup",
  //   data: form,
  //   contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
  //   success: function (data) {
  //   opener.location.reload();
  //   window.close();
  //   }, error: function (jqXHR, textStatus, errorThrown) {
  //   // alert(jqXHR + ' ' + textStatus.msg);
  //           alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
  //   }
  //   });


//   $.ajax({
//     url:"/mypage/address",
//     type:'POST',
//     data: form,
//     success:function(data){
//         alert("완료!");
//         window.opener.location.reload();
//         self.close();
//     },
//     error:function(jqXHR, textStatus, errorThrown){
//         self.close();
//     }
// });
// function fn_editFL()
// 	{
// 		var params = $("#send_form").serialize();
// 		$.ajax(
// 		{
// 			url : "",
// 			data : params,
// 			success : function(xh)
// 					{									
// 						window.close();
// 					}
// 		});
// 	}


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
