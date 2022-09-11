
    // document.querySelector
    $(document).ready(function () {

   
      var thumbNailCon = $('.my-own-recipe-thumbnail-img');
      varimgSrc1 = $('.my-own-recipe-addition-img img:nth-child(1)').attr('src');
      thumbNailCon.html(`<img src="`+varimgSrc1+`" alt="img" class="thumbPic">`);

      $('.my-own-recipe-addition-img>img').on({
        "click": function () {
          console.log("d");
          varimgSrc = $(this).attr('src');
          $('.my-own-recipe-thumbnail-img>img').attr('src', varimgSrc);
        }
      });

    });
