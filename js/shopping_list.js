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





  $(".date-item").slice(0, 2).show(); // select the first two
  $(".viewmore-btn").click(function(e){ // click event for load more
  e.preventDefault();
  $(".date-item:hidden").slice(0, 2).show(); // select next 2 hidden divs and show them
  if($(".date-item:hidden").length == 0){ // check if any hidden divs still exist
  // alert("마지막 페이지입니다."); 
  // alert if there are none left
  $(".viewmore-btn-section").addClass('remove-btn');
  }
});
  $(".date-item-d").slice(0, 3).show(); // select the first two
  $(".viewmore-btn").click(function(e){ // click event for load more
  e.preventDefault();
  $(".date-item-d:hidden").slice(0, 3).show(); // select next 2 hidden divs and show them
  if($(".date-item-d:hidden").length == 0){ // check if any hidden divs still exist
  // alert("마지막 페이지입니다."); 
  // alert if there are none left
  $(".viewmore-btn-section2").addClass('remove-btn');
  }
});