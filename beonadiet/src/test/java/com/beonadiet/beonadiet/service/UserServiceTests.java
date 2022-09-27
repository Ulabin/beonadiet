// package com.beonadiet.beonadiet.service;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.transaction.annotation.Transactional;

// import com.beonadiet.beonadiet.dto.UserDto;
// import com.beonadiet.beonadiet.entity.Member;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringBootTest
// @Transactional
// @TestPropertySource(locations = "classpath:application-test.properties")
// class UserServiceTests {

//     @Autowired
//     UserService userService;

//     @Autowired
//     PasswordEncoder passwordEncoder;

//     public Member createMember() {

//         UserDto userDto = new UserDto();

//         userDto.setUser_id("test777");
//         userDto.setPassword("1234");
//         userDto.setUser_name("김연아");
//         userDto.setNickname("퀸연아");
//         userDto.setEmail("test777@gmail.com");
//         userDto.setMobile_num("010-1234-5678");

//         return Member.createMember(userDto, passwordEncoder);
//     }

//     @Test
//     @DisplayName("회원가입 테스트")
//     public void saveMemberTest() {
//         Member member = createMember();
//         Member savedMember = userService.saveMember(member);

//         assertEquals(member.getEmail(), savedMember.getEmail());
//         assertEquals(member.getUser_name(), savedMember.getUser_name());
//         assertEquals(member.getPassword(), savedMember.getPassword());
//         assertEquals(member.getRole(), savedMember.getRole());
//     }
// }