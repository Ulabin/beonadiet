// package com.beonadiet.beonadiet.service;

// import javax.transaction.Transactional;

// import org.springframework.stereotype.Service;

// import com.beonadiet.beonadiet.entity.Member;
// import com.beonadiet.beonadiet.repository.UserRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @Transactional
// @RequiredArgsConstructor
// public class UserService {
//   private final UserRepository userRepository;

//   public Member saveMember(Member member) {
//     validateDuplicateMember(member);
//     return userRepository.save(member);
//   }

//   private void validateDuplicateMember(Member member) {
//     Member findMember = userRepository.findByUser_id(member.getUser_id());
//     if (findMember != null) {
//         throw new IllegalStateException("이미 가입된 아이디입니다.");
//     }
//   }
// }
