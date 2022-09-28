  document.getElementById("calc1").onclick = function (){
  
    var num1 = document.getElementById('height').value * 0.01;
    var num2 = document.getElementById('male').value;
    var num3 = document.getElementById('female').value;
    var num4 = document.getElementById('activity').value;
    var male = document.getElementById('male');
    var female = document.getElementById('female');
    
    if(male.checked){
      document.getElementById('standard-weight').value = (Number(num1) * Number(num1) * Number(num2)).toFixed(1);
    }else if(female.checked){
      document.getElementById('standard-weight').value = (Number(num1) * Number(num1) * Number(num3)).toFixed(1);
    }
    
    var num5 = document.getElementById('standard-weight').value;
    document.getElementById('daily-calorie-require').value = (Number(num4) * Number(num5)).toFixed();
  };
  
  var popupWidth = 800;
  var popupHeight = 500;
  var popupX = (window.screen.width / 2) - (popupWidth / 2);
  var popupY= (window.screen.height / 2) - (popupHeight / 2);

  $('.detail-info').click(function() {
    window.open('active_page', '활동지수 참고사항', 
    'status=no, height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY);
  });
  
  document.getElementById('calc2').onclick = function (){
    var num6 = document.getElementById('body-fat').value;
    var bodyFat = document.getElementById('body-fat');
    var carb = document.getElementById('carb');
    var protein = document.getElementById('protein');
    var fat = document.getElementById('fat');
    
    if(num6==""||num6<=0){
      alert('숫자를 입력해주세요.')
      bodyFat.focus();
    }else if((num6<=13&&num6>0&&male2.checked)||(num6<=21&&num6>0&&female2.checked)){
      carb.value = 15;
      protein.value = 45;
      fat.value = 40;
    }else if((num6<=17&&male2.checked)||(num6<=25&&female2.checked)){
      carb.value = 20;
      protein.value = 40;
      fat.value = 40;
    }else if((num6<22&&male2.checked)||(num6<29&&female2.checked)){
      carb.value = 25;
      protein.value = 40;
      fat.value = 35;
    }else if((num6>=22&&male2.checked)||(num6>=29&&female2.checked)){
      carb.value = 30;
      protein.value = 40;
      fat.value = 30;
    }
  };

  $('.btn-add').click(function() {
      var checkedList = "";
      var checkedConsole = "";

      $("input[name='allergy-item']:checkbox:checked").each(function() {
          checkedList += $(this).val() + "\t";
          checkedConsole += $(this).val() + "\t";
      });
      $('#result').html(checkedList);  
      $('#allergyList').html(checkedList);  

      console.log(checkedConsole);

      var inputs = $('#add-item-input').val();
      $('#result').append(inputs);
      $('#allergyList').append(inputs);
      console.log(inputs);
  });
