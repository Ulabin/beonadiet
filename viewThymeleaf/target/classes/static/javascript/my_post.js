var list = document.querySelector('.my-post-item-container');
    for (let i = 0; i < 6; i++) {

      if (i == 3) {
        list.innerHTML += `<br> <div class="my-post-item" id="my-post-item${i}">
      <div class="my-post-item-name-container">
        <div class="my-post-item-name">
          맛있는 도시락
        </div>
      </div>

      <a href="#">
        <img src="./images/img1.jpg" alt="image" class="my-post-item-image">
      </a>
      <div class="my-post-mod-def-date-container">
        <div class="my-post-mod-date">수정날짜 : 2022.09.04</div>
        <div class="my-post-def-date">작성날짜 : 2022.09.04</div>
      </div>
      <div class="my-post-like">
        <iconify-icon icon="ant-design:heart-filled" style="color: #0fa958;" width="20" height="20">
        </iconify-icon>
        <span class="my-post-like-count"> 1</span>
      </div>
      <div class="my-post-mod-del-button-container">
        <button class="my-post-modify-button id="my-post-modify-button">수정</button>
        <button class="my-post-delete-delete">삭제</button>
      </div>
    </div> `;
      } else {
        list.innerHTML += ` <div class="my-post-item" id="my-post-item${i}">
      <div class="my-post-item-name-container">
        <div class="my-post-item-name">
          맛있는 도시락
        </div>
      </div>

      <a href="#">
        <img src="./images/img1.jpg" alt="image" class="my-post-item-image">
      </a>
      <div class="my-post-mod-def-date-container">
        <div class="my-post-mod-date">수정날짜 : 2022.09.04</div>
        <div class="my-post-def-date">작성날짜 : 2022.09.04</div>
      </div>
      <div class="my-post-like">
        <iconify-icon icon="ant-design:heart-filled" style="color: #0fa958;" width="20" height="20">
        </iconify-icon>
        <span class="my-post-like-count"> 1</span>
      </div>
      <div class="my-post-mod-del-button-container">
        <button class="my-post-modify-button" id="my-post-modify-button">수정</button>
        <button class="my-post-delete-delete">삭제</button>
      </div>
    </div>`;
      }
    }
    window.onload = function(){

      var btnTest = document.querySelector('#my-post-modify-button');
      btnTest.addEventListener("click", function() {
    alert("Click!");
  });
    }
    
    