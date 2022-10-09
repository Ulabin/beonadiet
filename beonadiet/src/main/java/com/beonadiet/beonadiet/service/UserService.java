package com.beonadiet.beonadiet.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestParam;

import com.beonadiet.beonadiet.dto.UserDto;
import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserService {

  @Autowired //타입에 해당하는 빈을 주입
  UserRepository userRepository;

  //패스워드 암호화
  @Autowired //타입에 해당하는 빈을 주입
  BCryptPasswordEncoder bCryptPasswordEncoder;

  //회원가입 처리
  public void Join(Member member) {
    member.setRole("ROLE_USER");
    //패스워드는 bCryptPasswordEncoder를 통해서 암호화 해야 Security 로그인 가능
    String EncPassword = bCryptPasswordEncoder.encode(member.getPassword());
    member.setPassword(EncPassword);
    userRepository.save(member);
  }

  //회원정보수정
  public void modify(Member member) {
    // member.setRole("ROLE_USER");
    //패스워드는 bCryptPasswordEncoder를 통해서 암호화 해야 Security 로그인 가능
    String EncPassword = bCryptPasswordEncoder.encode(member.getPassword());
    member.setPassword(EncPassword);
    userRepository.save(member);
  }

  //회원삭제
  public void deleteById(Long id){
    userRepository.deleteById(id);
  }
  
  
  //아이디 중복
  @Transactional
  public boolean existsByUsername(String username){
    return userRepository.existsByUsername(username);
  }

  //닉네임 중복
  @Transactional
  public boolean existsByNickname(String nickname){
    return userRepository.existsByNickname(nickname);
  }

  //이메일 중복
  @Transactional
  public boolean existsByEmail(String email){
    return userRepository.existsByEmail(email);
  }
}
