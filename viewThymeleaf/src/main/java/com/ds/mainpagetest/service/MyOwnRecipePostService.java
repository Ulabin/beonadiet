package com.ds.mainpagetest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ds.mainpagetest.dto.MorImageDTO;
import com.ds.mainpagetest.dto.MyOwnRecipePostDTO;
import com.ds.mainpagetest.entity.MorImage;
import com.ds.mainpagetest.entity.MyOwnRecipePost;




public interface MyOwnRecipePostService {
  // MyOwnRecipePost register(MyOwnRecipePostDTO dto);
  Long register(MyOwnRecipePostDTO dto);
  // PageResultDTO<MyOwnRecipePostDTO, Object[]> getList(PageRequestDTO req);
  // void modify(MyOwnRecipePostDTO dto);
  void removeUuid(String uuid);
  MyOwnRecipePostDTO getMovie(Long id);
 
  default MyOwnRecipePostDTO entityToDTO(MyOwnRecipePost morPost, List<MorImage> mi){
    MyOwnRecipePostDTO morPostDTO = MyOwnRecipePostDTO.builder()
    .id(morPost.getId())
    .title(morPost.getTitle())
    .category(morPost.getCategory())
    .regDate(morPost.getRegDate())
    .modDate(morPost.getModDate())
    .explanation(morPost.getExplanation())
    .detail(morPost.getDetail())
    .build();
    
    List<MorImageDTO> morImageDTOs = mi.stream().map(
      new Function<MorImage, MorImageDTO>() {
        public MorImageDTO apply(MorImage t) {
          return MorImageDTO.builder()
          .imgName(t.getImgName()).path(t.getPath()).uuid(t.getUuid())
          .build();
        };
      }).collect(Collectors.toList());
      morPostDTO.setImageDTOList(morImageDTOs);

      return morPostDTO;
  }
  default Map<String, Object> dtoToEntity(MyOwnRecipePostDTO dto){
    //MovieDTO로 부터 Movie, MovieImage 두개를 나눠서 담기 위한 map 선언
    Map<String, Object> entityMap = new HashMap<>();

    //First Element of Map
    MyOwnRecipePost morPost = MyOwnRecipePost.builder()
    .id(dto.getId())
    .title(dto.getTitle())
    .category(dto.getCategory())
    .explanation(dto.getExplanation())
    .detail(dto.getDetail())
    .build();
    entityMap.put("morPost", morPost); 
    System.out.println("dtoToEntity done from MyOwnRecipePostServie........" + morPost);
    
    List<MorImageDTO> imageDTOList = dto.getImageDTOList();
    System.out.println("이미지 리스트");
    //poster있을때만 MovieImageDTO를 MovieImage 변환
    if(imageDTOList != null && imageDTOList.size() > 0) {
      List<MorImage> morImageList = imageDTOList.stream().map(
        new Function<MorImageDTO,MorImage>() {
          @Override
          public MorImage apply(MorImageDTO t) {
            MorImage morImage = MorImage.builder().path(t.getPath())
                                    .imgName(t.getImgName()).uuid(t.getUuid())
                                    .morPost(morPost).build();
            return morImage;
          }
        }
      ).collect(Collectors.toList());
      //Second Element of Map
      entityMap.put("imgList", morImageList);
    }
    return entityMap;
  }
}
