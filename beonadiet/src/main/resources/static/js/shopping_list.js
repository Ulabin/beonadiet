/* 수빈 전체 복붙 추천 */
$(document).ready(function () {

var $btn = $('.search-time');
$('.default').addClass('active');
$btn.click(function() {
  $btn.removeClass('active');
  $(this).addClass('active');
});

$('.search-time-box div').click(function(){
  var tab_id = $(this).attr('data-tab');

  $('ul.tabs li').removeClass('current');
  $('.tab-content').removeClass('current');

  $(this).addClass('current');
  $("#"+tab_id).addClass('current');
})

  
  $(".date-item").slice(0, 2).show(); 
  $(".viewmore-btn").click(function(e){ 
  $(".date-item:hidden").slice(0, 2).show(); 
  if($(".date-item:hidden").length == 0){ 
  $(".viewmore-btn-section").addClass('remove-btn');
  }
});

  $(".date-item-2").slice(0, 2).show(); 
  $(".viewmore-btn").click(function(e){ 
  $(".date-item-2:hidden").slice(0, 2).show();
  if($(".date-item-2:hidden").length == 0){ 
  $(".viewmore-btn-section2").addClass('remove-btn');
  }
});

  $(".date-item-3").slice(0, 2).show(); 
  $(".viewmore-btn").click(function(e){ 
  $(".date-item-3:hidden").slice(0, 2).show();
  if($(".date-item-3:hidden").length == 0){ 
  $(".viewmore-btn-section3").addClass('remove-btn');
  }
});

  $(".date-item-4").slice(0, 2).show(); 
  $(".viewmore-btn").click(function(e){ 
  $(".date-item-4:hidden").slice(0, 2).show();
  if($(".date-item-4:hidden").length == 0){ 
  $(".viewmore-btn-section4").addClass('remove-btn');
  }
});

$('.pay-cancel').click(function(){
  if(!confirm("주문 취소하시겠습니까?")){
    alert('취소버튼을 눌렀습니다.'); 
  }else{
    alert('주문이 취소되었습니다.');
  }
});

$('.start-cancel').click(function(){
  if(!confirm('1:1문의게시판을 통해 교환/반품이 가능합니다.\n확인버튼을 누르시면 1:1문의게시판으로 이동합니다.')){
    alert('취소버튼을 눌렀습니다.'); 
  }else{
    alert('1:1 문의게시판 이동');
  }
});

})
