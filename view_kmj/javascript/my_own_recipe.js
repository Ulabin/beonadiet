 // 주간 베스트 레시피 좌우 이동 부트스트랩
 $('.main-carousel').flickity({
  // options
  cellAlign: 'left',
  wrapAround: true,
  freeScroll: true
});

// br태그 써보기
var list = document.querySelector('.my-own-recipe-board-item-container');
for (let i = 0; i < 12; i++) {

  if (i % 4 == 0) {
    list.innerHTML += `<br> <div class="my-own-recipe-board-item" id="my-own-recipe-board-item${i}">
          <a href="#">
            <img src="./images/img1.jpg" alt="image" class="my-own-recipe-board-item-image">
          </a>
          <div class="my-own-recipe-like">
            <iconify-icon icon="ant-design:heart-filled" style="color: #0fa958;" width="25" height="25">
            </iconify-icon>
            <span class="my-own-recipe-like-count"> 1</span>
          </div>
          <div class="my-own-recipe-board-item-name-container">
            <div class="my-own-recipe-board-item-name">
              맛있는 도시락
            </div>
          </div>
        </div>
      
      
      </div>`;
  } else {
    list.innerHTML += `<div class="my-own-recipe-board-item" id="my-own-recipe-board-item${i}">
          <a href="#">
            <img src="./images/img1.jpg" alt="image" class="my-own-recipe-board-item-image">
          </a>
          <div class="my-own-recipe-like">
            <iconify-icon icon="ant-design:heart-filled" style="color: #0fa958;" width="25" height="25">
            </iconify-icon>
            <span class="my-own-recipe-like-count"> 1</span>
          </div>
          <div class="my-own-recipe-board-item-name-container">
            <div class="my-own-recipe-board-item-name">
              맛있는 도시락
            </div>
          </div>
        </div>`;
  }
}
