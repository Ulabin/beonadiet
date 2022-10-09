package com.beonadiet.beonadiet.repository;

import com.beonadiet.beonadiet.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {
  // 인터페이스에서 함수를 선언하고 필요한곳 에서 Override 하여 사용
  // Select * from member where email = ?;
  // Select 쿼리를 통해서 email을 가지는 유저 정보를 모두 가져옴 (따로 쿼리 작성 필요 X)
  // Member findByEmail(String email);
  // Member findByEmail(String user_id);

  public Member findByUsername(String username);


  boolean existsByUsername(String username);
  boolean existsByNickname(String nickname);
  boolean existsByEmail(String email);
  boolean existsByPassword(String password);
}
