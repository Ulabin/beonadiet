// package com.beonadiet.beonadiet.repository;

// // import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.beonadiet.beonadiet.entity.Member;

// @Repository
// public interface UserRepository extends JpaRepository<Member, Long> {
//   // Optional<UserEntity> findByUser_id(String user_id);
//   public Member findByUser_id(String user_id);
//   public Member findByEmail(String email);
//   public Member findByRole(Character role);
// }