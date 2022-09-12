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
