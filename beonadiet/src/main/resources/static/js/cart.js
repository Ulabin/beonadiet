$(".check-all-1").click(function() {
  if($(".check-all-1").is(":checked")){
    $("input[name='selected-item']").prop("checked", true);
    $(".check-all-2").prop("checked", true);
  }else{
    $("input[name='selected-item']").prop("checked", false);
    $(".check-all-2").prop("checked", false);
  }
});

$(".check-all-2").click(function() {
  if($(".check-all-2").is(":checked")){
    $("input[name='selected-item']").prop("checked", true);
    $(".check-all-1").prop("checked", true);
  }else{
    $("input[name='selected-item']").prop("checked", false);
    $(".check-all-1").prop("checked", false);
  }
});

$("input[name='selected-item']").click(function() {
  var total = $("input[name='selected-item']").length;
  var checked = $("input[name='selected-item']:checked").length;
  
  if(total != checked){
    $(".check-all-1").prop("checked", false);
    $(".check-all-2").prop("checked", false);
  }else{
    $(".check-all-1").prop("checked", true);
    $(".check-all-2").prop("checked", true);
  } 
});

var increment;
var decrement;
var plusBtn = $('.up');
var minusBtn = $('.down');
var increment = plusBtn.click(function(){
  var $n = $(this).parent('.form-number').find('.num');
  $n.val(Number($n.val())+1 );
})
var decrement = minusBtn.click(function(){
  var $n = $(this).parent('.form-number').find('.num');
  var numVal = Number($n.val());
  if(numVal > 1){
    $n.val(numVal-1);
  }
})
