package com.beonadiet.beonadiet.service.recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.beonadiet.beonadiet.dto.recipe.MorImageDTO;
import com.beonadiet.beonadiet.dto.recipe.MyOwnRecipePostDTO;
import com.beonadiet.beonadiet.entity.recipe.MorImage;
import com.beonadiet.beonadiet.entity.recipe.MyOwnRecipePost;


public interface MyOwnRecipePostService {
  // MyOwnRecipePost register(MyOwnRecipePostDTO dto);
  Long register(MyOwnRecipePostDTO dto);
  // PageResultDTO<MyOwnRecipePostDTO, Object[]> getList(PageRequestDTO req);
  // void modify(MyOwnRecipePostDTO dto);
  void removeUuid(String uuid);
  MyOwnRecipePostDTO getMyOwnRecipePost(Long id);
  MyOwnRecipePostDTO getMyOwnRecipePost(int category);
 
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
  default MyOwnRecipePostDTO entityToDTO2(List<MyOwnRecipePost> morPost, List<MorImage> mi){
    List<MyOwnRecipePostDTO> morPostDTO = morPost.stream().map(
      new Function<MyOwnRecipePost, MyOwnRecipePostDTO>(){
        public MyOwnRecipePostDTO apply(MyOwnRecipePost t) {
          return MyOwnRecipePostDTO.builder()
          .id(((MyOwnRecipePostDTO) morPost).getId())
          .title(((MyOwnRecipePostDTO) morPost).getTitle())
          .category(((MyOwnRecipePostDTO) morPost).getCategory())
          .regDate(((MyOwnRecipePostDTO) morPost).getRegDate())
          .modDate(((MyOwnRecipePostDTO) morPost).getModDate())
          .explanation(((MyOwnRecipePostDTO) morPost).getExplanation())
          .detail(((MyOwnRecipePostDTO) morPost).getDetail())
          .build();
        };
      }).collect(Collectors.toList());
    
    
    
    List<MorImageDTO> morImageDTOs = mi.stream().map(
      new Function<MorImage, MorImageDTO>() {
        public MorImageDTO apply(MorImage t) {
          return MorImageDTO.builder()
          .imgName(t.getImgName()).path(t.getPath()).uuid(t.getUuid())
          .build();
        };
      }).collect(Collectors.toList());
      ((MyOwnRecipePostDTO) morPostDTO).setImageDTOList(morImageDTOs);

      return (MyOwnRecipePostDTO) morPostDTO;
  }

  default Map<String, Object> dtoToEntity(MyOwnRecipePostDTO dto){
    //MovieDTO??? ?????? Movie, morImage ????????? ????????? ?????? ?????? map ??????
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
    System.out.println("????????? ?????????");
    //poster???????????? morImageDTO??? morImage ??????
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
