package com.zjm;

import com.zjm.bean.User;
import com.zjm.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void test(){
        List<User> all = userRepository.findAll();
        System.out.println(all);
    }
}
