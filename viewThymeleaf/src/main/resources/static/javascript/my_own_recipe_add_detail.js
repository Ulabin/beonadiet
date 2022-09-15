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