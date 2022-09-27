package com.beonadiet.beonadiet.repository;

import com.beonadiet.beonadiet.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {

}
