
    
    window.onload = function(){

      var btnTest = document.querySelector('#my-post-modify-button');
      btnTest.addEventListener("click", function() {
    alert("Click!");
  });
    }
    $(document).ready(function(){
      $('.my-post-radiobox > button').click(function(){
        $(this).css("background-color", "#353535");
        $(this).css("color", "#C7DFAA");
        $(this).siblings().css("background-color","#C7DFAA");
        $(this).siblings().css("color","#353535");
        
    })
    })
    

    function getmypostlunchbox() {
      console.log("클릭")
      
        /*<![CDATA[*/
        $.ajax({
          type: "GET",
          url: "mypage/mypostlunchbox",
        })
          .done(function (result) {
            $('.my-post-posts').empty();
            $('.my-post-posts').html(result)
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
    function getmypostsandwich() {
      console.log("클릭")
      
        /*<![CDATA[*/
        $.ajax({
          type: "GET",
          url: "mypage/mypostsandwich",
        })
          .done(function (result) {
            $('.my-post-posts').empty();
            $('.my-post-posts').html(result)
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
    function getmypostsalad() {
      console.log("클릭")
      
        /*<![CDATA[*/
        $.ajax({
          type: "GET",
          url: "mypage/mypostsalad",
        })
          .done(function (result) {
            $('.my-post-posts').empty();
            $('.my-post-posts').html(result)
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