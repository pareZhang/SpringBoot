package com.zjm.repository;

import com.zjm.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findAll();
}
