package com.ds.mainpagetest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.mainpagetest.dto.MyOwnRecipePostDTO;
import com.ds.mainpagetest.entity.MorImage;
import com.ds.mainpagetest.entity.MyOwnRecipePost;
import com.ds.mainpagetest.repositiory.MorImageRepository;
import com.ds.mainpagetest.repositiory.MyOwnRecipePostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyOwnRecipePostServiceImpl implements MyOwnRecipePostService {
  // private final MyOwnRecipePostRepository movieRepository;
  private final MyOwnRecipePostRepository mRepository;
  // private final MorImageRepository miRepository;
  private final MorImageRepository miRepository;

  @Transactional
  @Override
  public Long register(MyOwnRecipePostDTO dto) {
    log.info("register.......");
    Map<String, Object> entityMap = dtoToEntity(dto);
    log.info("dtoToEntity후......." + entityMap);
    MyOwnRecipePost morp = (MyOwnRecipePost) entityMap.get("morPost");// 자부자
    
    List<MorImage> morImageList = (List<MorImage>) entityMap.get("imgList");
    log.info(morImageList);
    log.info("mRrepository.......save전");
    mRepository.save(morp);

    morImageList.forEach(new Consumer<MorImage>() {
      @Override
      public void accept(MorImage morImage) {
        miRepository.save(morImage);
      }
    });

    return morp.getId();
  }

  @Override
  public MyOwnRecipePostDTO getMovie(Long id) {
    List<Object[]> result = mRepository.getMovieWithAll(id);
    MyOwnRecipePost movie = (MyOwnRecipePost) result.get(0)[0];
    List<MorImage> movieImageList = new ArrayList();
    result.forEach(new Consumer<Object[]>() {
      @Override
      public void accept(Object[] arr) {
        MorImage movieImage = (MorImage) arr[1];
        movieImageList.add(movieImage);
      }
    });
    return entityToDTO(movie, movieImageList);
  }

  @Override
  public void removeUuid(String uuid) {
    mRepository.deleteByUuid(uuid);
  }

  // @Override
  // public void modify(MyOwnRecipePostDTO dto) {
  //   Optional<MyOwnRecipePost> result = mRepository.findById(dto.getId());
  //   if (result.isPresent()) {
  //     MyOwnRecipePost morp = result.get();
  //     morp.changeTitle(dto.getTitle());
  //     mRepository.save(morp);
  //   }
  // }

  // @Override
  // public PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO req) {
  // // 요청하는 페이지에 대한 정보를 가진 객체 Pageable
  // // An object Pageable with information about the requesting page
  // Pageable pageable = req.getPageable(Sort.by("mno").descending());
  // // 해당페이지에 대한 정보(list)를 가진 객체 Page
  // // An object with information(list) about the page.
  // Page<Object[]> result = movieRepository.getListPage(pageable);
  // Function<Object[], MovieDTO> fn = new Function<Object[], MovieDTO>() {
  // @Override
  // public MovieDTO apply(Object[] t) {
  // return entityToDTO(
  // (Movie) t[0],
  // (List<MovieImage>) (Arrays.asList((MovieImage) t[1])),
  // (Double) t[2],
  // (Long) t[3]);
  // }
  // };
  // return new PageResultDTO<>(result, fn);
  // }



  // @Override
  // public void removeUuid(String uuid) {
  // miRepository.deleteByUuid(uuid);
  // }
}
