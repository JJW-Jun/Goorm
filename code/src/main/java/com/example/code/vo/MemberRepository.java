package com.example.code.vo;

import com.example.code.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface MemberRepository extends JpaRepository<Member, Long> {


}
