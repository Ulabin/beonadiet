package com.ds.mainpagetest.repositiory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.ds.mainpagetest.entity.MorImage;

public interface MorImageRepository extends JpaRepository<MorImage, Long> {
  @Modifying
  @Query("delete from MorImage mi where mi.morPost.id=:id ")
  void deleteById(Long id);

  @Transactional
  @Modifying
  @Query("delete from MorImage mi where mi.uuid=:uuid ")
  void deleteByUuid(String uuid);

  @Query("select mi from MorImage mi where mi.morPost.id=:id ")
  List<MorImage> findById();
  // List<MorImage> findById(Long id);

}
