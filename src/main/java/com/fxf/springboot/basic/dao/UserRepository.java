package com.fxf.springboot.basic.dao;

import com.fxf.springboot.basic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
