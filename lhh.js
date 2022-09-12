/*F A Q*/
jQuery(function($){
    var article = $('.faq>.faqBody>.article');
    article.addClass('hide');
    article.find('.a').hide();
    //article.eq(0).removeClass('hide');
    //article.eq(0).find('.a').show();
    $('.faq>.faqBody>.article>.q>a').click(function(){
        var myArticle = $(this).parents('.article:first');
        if(myArticle.hasClass('hide')){
            article.addClass('hide').removeClass('show');
            article.find('.a').slideUp(100);
            myArticle.removeClass('hide').addClass('show');
            myArticle.find('.a').slideDown(100);
        } else {
            myArticle.removeClass('show').addClass('hide');
            myArticle.find('.a').slideUp(100);
        }
        return false;
    });
    $('.faq>.faqHeader>.showAll').click(function(){
        var hidden = $('.faq>.faqBody>.article.hide').length;
        if(hidden > 0){
            article.removeClass('hide').addClass('show');
            article.find('.a').slideDown(100);
        } else {
            article.removeClass('show').addClass('hide');
            article.find('.a').slideUp(100);
        }
    });
});

/*고객센터 문의글 작성*/ 
window.onload = function(){
    const centerRegistBtn = document.querySelector(".centerRegistBtn");
    const centerRegisTitle = document.querySelector("#centerTitle");
    const centerRegisTextarea = document.querySelector("#centerTextarea");
    const titleFalse = document.querySelector(".titleFalse");
    const textareaFalse = document.querySelector(".textareaFalse");

    centerRegistBtn.onclick = function(){
        if(centerRegisTitle.value.trim()==""){
            titleFalse.textContent="제목을 입력해주세요"
            return
        }
        if(centerRegisTextarea.value.trim()==""){
            textareaFalse.textContent="내용을 입력해주세요"
            return  
        }
    }
}