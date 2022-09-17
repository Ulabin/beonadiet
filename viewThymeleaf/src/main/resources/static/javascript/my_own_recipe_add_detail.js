$("input[id=ex_file]").change(function () {
  if ($(this).val() != "") {
    //확장자체크
    var ext = $(this).val().split(".").pop().toLowerCase();
    if ($.inArray(ext, ["gif", "jpg", "jpeg", "png"]) == -1) {
      alert("gif, jpg, jpeg, png 파일만 업로드 가능합니다.");
      $(this).val("");
      return;
    }

    //용량체크
    for (var i = 0; i < this.files.length; i++) {
      var fileSize = this.files[i].size;
      var fsMB = (fileSize / (1024 * 1024)).toFixed(2);
      var maxSize = 1024 * 1024 * 5;
      var mSMB = (maxSize / (1024 * 1024));
      if (fileSize > maxSize) {
        alert(this.files[i].name + "(이)가 용량 5MB를 초과했습니다.\n\n<font color='red'>" + fsMB + "MB</font> / " + mSMB + "MB");
        $(this).val("");
      }
    }
  }
})

$("#ex_file").on("change", function (event) {
  
  for(var i= 0; i<4; i++){
    if(i==0){
      
      var file = event.target.files[i];
      
      var reader = new FileReader();
        reader.onload = function (e) {
          $(".my-own-recipe-add-detail-addition-img1").attr("src", e.target.result);
          $(".my-own-recipe-add-detail-thumbnail-img").attr("src", e.target.result);
        }
        reader.readAsDataURL(file);
    } else if(i==1){
      var file = event.target.files[i];
      
      var reader = new FileReader();
        reader.onload = function (e) {
          $(".my-own-recipe-add-detail-addition-img2").attr("src", e.target.result);
        }
        reader.readAsDataURL(file);
    }else if(i==2){
      var file = event.target.files[i];
      
      var reader = new FileReader();
        reader.onload = function (e) {
          $(".my-own-recipe-add-detail-addition-img3").attr("src", e.target.result);
        }
        reader.readAsDataURL(file);
    }else if(i==3){
      var file = event.target.files[i];
      
      var reader = new FileReader();
        reader.onload = function (e) {
          $(".my-own-recipe-add-detail-addition-img4").attr("src", e.target.result);
        }
        reader.readAsDataURL(file);
    }
  }
  // varimg = $(".my-own-recipe-add-detail-addition-img1").attr('src');
  
  // $(".my-own-recipe-add-detail-thumbnail-img").attr("src", varimg);
      
});


$(document).ready(function(){
  // var listVar = $('input[name=my-own-recipe-register-orderhistory-item-check]:checked').val();
  $('.my-own-recipe-add-detail-register-button').click(function(){


    var textarea = $('.my-own-recipe-add-detail-explanation-textarea');
    if(textarea.val() == ""){
      alert("설명을 추가해 주십시오")
      return false;
    } else if (textarea.val().length > 200){
      alert("글자수 최대 200자 입니다.")
      return false;
    } 
    else if (textarea.val().length < 20) {
       console.log(textarea.val());
       alert("글자수 최소 20자 입니다.")
       return false;
      } else {
      console.log(textarea.val());
      return  $trim(textarea.val())
    }
  
  })
  
});  
