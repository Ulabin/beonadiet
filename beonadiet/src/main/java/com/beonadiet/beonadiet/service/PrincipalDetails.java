package com.beonadiet.beonadiet.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.beonadiet.beonadiet.entity.Member;
import java.util.ArrayList;
import java.util.Collection;

// Security Session -> Authentication -> UserDetails(PrincipalDetails)

public class PrincipalDetails implements UserDetails {

    private Member member;

    // 생성자 오버로딩
    public PrincipalDetails(Member member){
        // Member 객체 초기화
        this.member = member;
    }

    // 해당 계정의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole();
            }
        });
        return collection;
    }

    // 비밀번호
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    // 아이디 (이메일)
    @Override
    public String getUsername() {
        return member.getUser_id();
        // return member.getEmail();
    }

    @Override
    // 만료된 계정이 아닌지 여부
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠금이 아닌지 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 휴먼 계정이 아닌지 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }

    
}