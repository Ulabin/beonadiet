package com.beonadiet.beonadiet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

  //  public void UpdateHealthInfo(@RequestParam(value="daily-calorie-intake") Long dailyCalorieIntake,@RequestParam(value="user_id") String user_id) {
  //     Member memberTmp =userRepository.findByUsername(user_id);
  //     memberTmp.setDaily_calorie_intake(dailyCalorieIntake);
  //     log.info("비테에스................................"+memberTmp);
  //     userRepository.save(memberTmp);
  //   }

}
