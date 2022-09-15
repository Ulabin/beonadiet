var list = document.querySelector('.user-post-item-container');
    for (let i = 0; i < 6; i++) {

      if (i % 3 == 0) {
        list.innerHTML += `<br> <a href="#"><div class="user-post-item" id="user-post-item${i}">
      <div class="user-post-item-name-container">
        <div class="user-post-item-name">
          맛있는 도시락
        </div>
      </div>

      
        <img src="./images/img1.jpg" alt="image" class="user-post-item-image">
      
      <div class="user-post-mod-def-date-container">
        <div class="user-post-mod-date">수정날짜 : 2022.09.04</div>
        <div class="user-post-def-date">작성날짜 : 2022.09.04</div>
      </div>
      <div class="user-post-my-own-recipe-like">
        <iconify-icon icon="ant-design:heart-filled" style="color: #0fa958;" width="20" height="20">
        </iconify-icon>
        <span class="user-post-my-own-recipe-like-count"> 1</span>
      </div>
    </div> </a>`;
      } else {
        list.innerHTML += `<a href="#"><div class="user-post-item" id="user-post-item${i}">
      <div class="user-post-item-name-container">
        <div class="user-post-item-name">
          맛있는 도시락
        </div>
      </div>

      
        <img src="./images/img1.jpg" alt="image" class="user-post-item-image">
      
      <div class="user-post-mod-def-date-container">
        <div class="user-post-mod-date">수정날짜 : 2022.09.04</div>
        <div class="user-post-def-date">작성날짜 : 2022.09.04</div>
      </div>
      <div class="user-post-my-own-recipe-like">
        <iconify-icon icon="ant-design:heart-filled" style="color: #0fa958;" width="20" height="20">
        </iconify-icon>
        <span class="user-post-my-own-recipe-like-count"> 1</span>
      </div>
    </div></a>`;
      }
    }