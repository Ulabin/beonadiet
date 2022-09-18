$(document).ready(function () {
  $('.my-page-list button').hover(function(){
    $(this).css("font-weight", "bold");
    
    
  }, function () {
    $(this).css("font-weight",400);
    
  });

  $(".change").click(function(){
    $(".my-page-detail").empty();
    
    $(".my-page-detail").html(` <div class="my-post-container" th:replace="mypage/mypost :: mypost"></div> `);
   
  });
  

  
})