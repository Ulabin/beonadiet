// var list = document.querySelector('.my-own-recipe-register-orderhistory');
//     for (let i = 0; i < 5; i++) {


//       list.innerHTML += `<div class="my-own-recipe-register-orderhistory-item">
//           <div class="my-own-recipe-register-orderhistory-item-img">
//              <img src="../images/salad.png" alt="image">
//           </div>
//           <div class="my-own-recipe-register-orderhistory-item-name">
//             <p>[나만의 샌드위치] 아삭모닝</p>
//           </div>
//           <div class="my-own-recipe-register-orderhistory-item-detail">
//             <div class="my-own-recipe-register-orderhistory-item-detail-list">
//               <ul>
//                 <li>화이트:15cm</li>
//                 <li>계란</li>
//                 <li>양상추</li>
//                 <li>케첩</li>
//                 <li>토마토</li>
//                 <li>햄</li>
//                 <li>오이</li>
//                 <li>치즈</li>
//               </ul>
//             </div> 
//           </div>
//           <div class="my-own-recipe-register-orderhistory-item-check">
//             <input type="radio" class="my-own-recipe-register-orderhistory-item-check-btn" name="my-own-recipe-register-orderhistory-item-check">
//           </div>

//         </div> <hr>`;

//     }

$(document).ready(function () {
  // var listVar = $('input[name=my-own-recipe-register-orderhistory-item-check]:checked').val();
  $('.my-own-recipe-register-btn').click(function () {
    var isValid = $("input[name=my-own-recipe-register-orderhistory-item-check]").is(":checked");
    if (isValid == 0) {
      alert("상품 중 하나를 선택해주십시오");
      return false;
    }
  })

  $('.my-own-recipe-register-radiobox > button').click(function () {
    $(this).css("background-color", "#353535");
    $(this).css("color", "#C7DFAA");
    $(this).siblings().css("background-color", "#C7DFAA");
    $(this).siblings().css("color", "#353535");
  })
});

// 나만의 도시락
function getMemberList1() {


  /*<![CDATA[*/
  $.ajax({
    type: "GET",
    url: "morlunchbox",

  })
    .done(function (result) {
      console.log(result);
      $('.uploadResult').empty();
      $('.uploadResult').html(result)
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
// 나만의 샌드위치
function getMemberList2() {


  /*<![CDATA[*/
  $.ajax({
    type: "GET",
    url: "morsandwich",

  })
    .done(function (result) {
      console.log(result);
      $('.uploadResult').empty();
      $('.uploadResult').html(result)
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
// 나만의 샐러드
function getMemberList3() {
  /*<![CDATA[*/
  $.ajax({
    type: "GET",
    url: "morsalad",

  })
    .done(function (result) {
      console.log(result);
      $('.uploadResult').empty();
      $('.uploadResult').html(result)
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
