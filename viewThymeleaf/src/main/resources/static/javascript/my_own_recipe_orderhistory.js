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

$(document).ready(function(){
  // var listVar = $('input[name=my-own-recipe-register-orderhistory-item-check]:checked').val();
  $('.my-own-recipe-register-btn').click(function(){
    var isValid = $("input[name=my-own-recipe-register-orderhistory-item-check]").is(":checked");
    if(isValid == 0){
      alert("상품 중 하나를 선택해주십시오");
      return false;
    } 
  })
  
$('.my-own-recipe-register-radiobox > a').click(function(){
    $(this).css("background-color", "#353535");
    $(this).css("color", "#C7DFAA");
    $(this).siblings().css("background-color","#C7DFAA");
    $(this).siblings().css("color","#353535");

    
  })
  
// $('.my-own-recipe-register-radiobox > a').eq(0).click(function(){
//   $(".my-own-recipe-register-orderhistory-item").attr("th:if", "${list.category == '1'}");
// })
// $('.my-own-recipe-register-radiobox > a').eq(1).click(function(){
//   $(".my-own-recipe-register-orderhistory-item").attr("th:if", "${list.category == '2'}");
// })
// $('.my-own-recipe-register-radiobox > a').eq(2).click(function(){
//   $(".my-own-recipe-register-orderhistory-item").attr("th:if", "${list.category == '3'}");
// })


});  

window.onload = document(function () {
  function showUploadedImages(arr){
    const divArea = document.querySelector(".uploadResult");
    const url = /*[[@{/display}]]*/'url'
    let str='';
    for(let i=0;i<arr.length;i++){
      // str += `<div>
      //           <img src="${url}?fileName=${arr[i].thumbnailURL}">
      //           <button class='removeBtn' 
      //             data-name='${arr[i].imageURL}'>REMOVE</button>
      //         </div>
      //       `

      str += `
      <div class="my-own-recipe-register-orderhistory-item" th:each="list : ${list}" th:if="${list.category == '1'}">
      <div class="my-own-recipe-register-orderhistory-item-img">
         <img src="../images/salad.png" alt="image">
      </div>
      <div th:text="${list.category}"> </div>
      <div class="my-own-recipe-register-orderhistory-item-name" th:text="${list.name}" >
        <!-- <p>[나만의 샌드위치] 아삭모닝</p> -->
      </div>
      
      
      <div class="my-own-recipe-register-orderhistory-item-detail">
        <div class="my-own-recipe-register-orderhistory-item-detail-list" th:text="${list.explanation}">
       
        </div> 
      </div>
      <div class="my-own-recipe-register-orderhistory-item-check">
        <input type="radio" class="my-own-recipe-register-orderhistory-item-check-btn" name="my-own-recipe-register-orderhistory-item-check">
      </div>

    </div> <hr>
      `
     
    }
    divArea.innerHTML = str;
  }
  showUploadedImages(res.data);
});
