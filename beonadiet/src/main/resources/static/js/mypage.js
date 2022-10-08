$(document).ready(function () {
  $('.my-page-list button').hover(function(){
    $(this).css("font-weight", "bold");
    
    
  }, function () {
    $(this).css("font-weight",400);
    
  });

  
})
function getMyPosts() {
  console.log("클릭")
  
    /*<![CDATA[*/
    $.ajax({
      type: "GET",
      url: "mypage/mypost",
    })
      .done(function (result) {
        $('.my-page-detail').empty();
        $('.my-page-detail').html(result)
      })
      .fail(function (jqXHR) {
        console.log(jqXHR);
        console.log("에러");
      })
      .always(function () {
        console.log("요청, 응답 결과에 상관없이, 이건 항상 실행됩니다.");
      })
    /*]]*/
  }