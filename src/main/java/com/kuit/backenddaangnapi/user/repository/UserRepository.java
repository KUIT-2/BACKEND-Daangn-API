package com.kuit.backenddaangnapi.user.repository;

import com.kuit.backenddaangnapi.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
