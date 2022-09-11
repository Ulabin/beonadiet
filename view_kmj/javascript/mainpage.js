// 베스트상품 좌우 이동 부트스트랩
$('.main-carousel').flickity({
  // options
  cellAlign: 'left',
  wrapAround: true,
  freeScroll: true
});

// 인스타그램 태그 생성 반복문
var insta = document.querySelector('.intagram-item-wrapper');
for (let i = 2; i < 5; i++) {
  insta.innerHTML += `<div class="main-page-instagram-item" id="main-page-instainstagram-item${i}"></div>`;
}

$(document).ready(function(){
  let i = 0;
  
  var bannerChangeInterval = setInterval(function(){
      $(".main-page-banner-a>a").eq(i).css("display","block");
      $(".main-page-banner-a>a").eq(i).siblings().css("display","none");
      $(".main-page-banner-hover>li").eq(i).css("border"," rgb(0, 211, 135) 2px solid");
      $(".main-page-banner-hover>li").eq(i).css("box-sizing"," border-box");
      $(".main-page-banner-hover>li").eq(i).siblings().css("border"," none");
      $(".main-page-banner-hover>li").eq(i).siblings().css("box-sizing"," border-box");
    i++;
    if(i ==5){
      i = 0;  
    }
   },3000);

  for(let i = 0; i<5; i++){
    $(".main-page-banner-hover>li").eq(i).mouseenter(function(){
      $(".main-page-banner-hover>li").eq(i).css("border"," rgb(0, 211, 135) 2px solid");
      $(".main-page-banner-hover>li").eq(i).css("box-sizing"," border-box");
      $(".main-page-banner-a>a").eq(i).css("display","block");
      $(".main-page-banner-a>a").eq(i).siblings().css("display","none");
      clearInterval(bannerChangeInterval)
      $(".main-page-banner-hover>li").eq(i).siblings().css("border"," none");
      $(".main-page-banner-hover>li").eq(i).siblings().css("box-sizing"," border-box");
    
    });
  }
    for(let i = 0; i<5; i++){
    $(".main-page-banner-hover>li").eq(i).mouseleave(function(){
      bannerChangeInterval = setInterval(function(){
      $(".main-page-banner-a>a").eq(i).css("display","block");
      $(".main-page-banner-a>a").eq(i).siblings().css("display","none");
      $(".main-page-banner-hover>li").eq(i).css("border"," rgb(0, 211, 135) 2px solid");
      $(".main-page-banner-hover>li").eq(i).css("box-sizing"," border-box");
      $(".main-page-banner-hover>li").eq(i).siblings().css("border"," none");
      $(".main-page-banner-hover>li").eq(i).siblings().css("box-sizing"," border-box");
    i++;
    if(i ==5){
      i = 0;  
    }
   },3000);
    });
  }
  // clearInterval(변수)
});