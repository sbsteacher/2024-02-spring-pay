package com.green.greengram.user;

import com.green.greengram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//<연결할 엔터티, PK 타입>
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUid(String uid); //메소드 쿼리
}
