package com.ds.mainpagetest.repositiory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ds.mainpagetest.entity.MyOwnRecipePost;

public interface MyOwnRecipePostRepository extends JpaRepository<MyOwnRecipePost, Long> {
  // @Query("select m, mi from MyOwnRecipePost m "
  // + "left outer join MorImage mi on mi.morPost = m "
  // + "where m.id=:id group by mi ")
  // List<Object[]> getMovieWithAll(Long id);

  // @Query("select m, mi, avg(coalesce(r.grade,0)), count(distinct r) from
  // MyOwnRecipePost m "
  // + "left outer join MorImage mi on mi.morPost = m "
  // + "group by m ")
  // Page<Object[]> getListPage(Pageable pageable);

  @Transactional
  @Modifying
  @Query("delete from MorImage mi where mi.uuid=:uuid ")
  void deleteByUuid(String uuid);

  @Query("select m from MyOwnRecipePost m where id=:id ")
  List<Object[]> getRecipeId(Long id);

  // @Query("select m, mi from MyOwnRecipePost m "
  //     + "left outer join MorImage mi on mi.morPost = m "
  //     + "where m.id=:id group by m.morPost ")
  // List<Object[]> getMovieWithAll(Long id);

  @Query("select m, mi from MyOwnRecipePost m "
      + "left outer join MorImage mi "
      + "on m.id = mi.morPost "  
      + "where m.id=:id " )
  List<Object[]> getMovieWithAll(Long id);

  // select * from my_own_recipe_post m left outer join mor_image mi on m.id=:id =
  // mi.mor_post_id;

  // @Query("select m, mi from MyOwnRecipePost m "
  //     + "left outer join MorImage mi "
  //     + "on m.id=:id = mi.morPost ")
  // List<Object[]> getMovieWithAll(Long id);


}
