package com.beonadiet.beonadiet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beonadiet.beonadiet.entity.Member;
import com.beonadiet.beonadiet.repository.UserRepository;

//login 요청이 오면 loadUserByUsername 함수를 실행
@Service
public class PrincipalDetailsService implements UserDetailsService{
  
  @Autowired //타입에 해당하는 빈을 주입
  private UserRepository userRepository;

  // 인자 이름과 login 페이지의 form 에 있는 id와 이름이 같아야한다 (String user_id)
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println(username + "loadUserByUsername 실행됨");
    Member member = userRepository.findByUsername(username);
    if(member != null) {
      return new PrincipalDetails(member);
    }
    return null;
  }

  // @Override
	// public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
	// 	Member member = userRepository.findByEmail(user_id)
	// 			.orElseThrow(() -> {
	// 				return new UsernameNotFoundException("해당 사용자는 없는 사용자입니다.");
	// 	});
	// 	return new PrincipalDetails(member); // 시큐리티 세션에 유저 정보 저장된다.
	// }

}
