$('#signup').on('submit',()=>{
// $('#btnjoin').on('click',()=>{
  let idVal = $('#userid').val();
  let idCheck = /^(?=.*[a-z])(?=.*[0-9])/;
  let pwdVal = $('#pwd1').val();
  let pwdOkVal = $('#pwd2').val();
  let pwdCheck = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;
  let mobileVal = $('#mobile').val();
  let mobileCheck = /^01([0|1|6|7|8|9])?([0-9]{3,4})?([0-9]{4})$/;
  let birthVal = $('#birth').val();
  let birthCheck =  /^(19[0-9][0-9]|20\d{2})?(0[0-9]|1[0-2])?(0[1-9]|[1-2][0-9]|3[0-1])$/;

  // if(!idCheck.test(idVal)) {
  //   alert('아이디는 영어소문자, 숫자로 입력하세요.');
  //   $('#userid').focus();
  //   return false;
  // }

  // if(!pwdCheck.test(pwdVal)){
  //   alert('비밀번호는 영대소문자,숫자,특수문자로 구성된 8글자 이상으로 입력하세요.');
  //   $('#pwd1').focus();
  //   return false;
  // } 

  if(pwdVal !== pwdOkVal){
    alert('비밀번호가 맞지 않습니다.')
    $('#pwd1').val("");
    $('#pwd2').val("");
    $('#pwd1').focus();
    return false;
  }

  if(!mobileCheck.test(mobileVal)){
    alert('휴대폰번호 형식에 맞게 입력하세요.( - 제외)');
    $('#mobile').val("");
    $('#mobile').focus();
    return false;
  }

  if(!birthCheck.test(birthVal)){
    alert('생년월일 형식에 맞게 입력하세요.');
    $('#birth').val("");
    $('#birth').focus();
    return false;
  }
  $("#signup").submit();
})


$('.btncheck').click(function() {
  $.ajax({
    url: 'join/id/check',
    type: 'GET',
    contentType: 'application/json',
    headers: {
      // 스프링 시큐리티를 위한 헤더 설정
      "X-CSRF-TOKEN": $("meta[name='_csrf']").attr("content")
    },
    data: {
      username: $('#username').val()
    },
    success: function (result) {
      // 성공 시 실패 메시지 hide, 성공 메시지 show
        $('#idNotAvailable').hide();
        $('#idAvailable').show().text(result).append($('<br />'));
    }, error: function(error) {
      // 실패 시 실패 메시지 show, 성공 메시지 hide
        $('#idAvailable').hide();
        $('#idNotAvailable').show().text(error.responseJSON['message']).append($('<br />'));
    }
  });
});

$('.btncheck2').click(function() {
  $.ajax({
    url: 'join/nickname/check',
    type: 'GET',
    contentType: 'application/json',
    headers: {
      // 스프링 시큐리티를 위한 헤더 설정
      "X-CSRF-TOKEN": $("meta[name='_csrf']").attr("content")
    },
    data: {
      nickname: $('#nickname').val()
    },
    success: function (result) {
      // 성공 시 실패 메시지 hide, 성공 메시지 show
        $('#idNotAvailable2').hide();
        $('#idAvailable2').show().text(result).append($('<br />'));
    }, error: function(error) {
      // 실패 시 실패 메시지 show, 성공 메시지 hide
        $('#idAvailable2').hide();
        $('#idNotAvailable2').show().text(error.responseJSON['message']).append($('<br />'));
    }
  });
});

$('.btncheck3').click(function() {
  $.ajax({
    url: 'join/email/check',
    type: 'GET',
    contentType: 'application/json',
    headers: {
      // 스프링 시큐리티를 위한 헤더 설정
      "X-CSRF-TOKEN": $("meta[name='_csrf']").attr("content")
    },
    data: {
      email: $('#email').val()
    },
    success: function (result) {
      // 성공 시 실패 메시지 hide, 성공 메시지 show
        $('#idNotAvailable3').hide();
        $('#idAvailable3').show().text(result).append($('<br />'));
    }, error: function(error) {
      // 실패 시 실패 메시지 show, 성공 메시지 hide
        $('#idAvailable3').hide();
        $('#idNotAvailable3').show().text(error.responseJSON['message']).append($('<br />'));
    }
  });
});

