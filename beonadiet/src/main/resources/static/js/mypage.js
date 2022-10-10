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

  /* 수빈 쇼핑리스트 추가 */
function getMyShoppingList() {
  console.log("클릭")
  
    /*<![CDATA[*/
    $.ajax({
      type: "GET",
      url: "mypage/shopping_list",
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

  /* 수빈 찜목록 추가 */
function getMyPick() {
  console.log("클릭")
  
    /*<![CDATA[*/
    $.ajax({
      type: "GET",
      url: "mypage/pick_list",
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
  /* 수빈 적립금 추가 */
function getMyPoint() {
  console.log("클릭")
  
    /*<![CDATA[*/
    $.ajax({
      type: "GET",
      url: "mypage/pointPage",
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
  /* 수빈 회원정보변경 추가 */
function getMyInfo() {
  console.log("클릭")
  
    /*<![CDATA[*/
    $.ajax({
      type: "GET",
      url: "mypage/userinfo",
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
  /* 수빈 칼로리,알러지 추가 */
function getMyHealth() {
  console.log("클릭")
  
    /*<![CDATA[*/
    $.ajax({
      type: "GET",
      url: "mypage/health_info",
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
  /* 수빈 배송지 추가 */
function getMyAddress() {
  console.log("클릭")
  
    /*<![CDATA[*/
    $.ajax({
      type: "GET",
      url: "mypage/address",
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