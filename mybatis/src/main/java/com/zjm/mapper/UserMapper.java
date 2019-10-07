package com.zjm.mapper;

import com.zjm.bean.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
