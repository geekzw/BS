package com.gzw.mapper;

import com.gzw.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by shuai on 17/1/16.
 */
public interface UserMapper {

    @Insert("INSERT INTO user(username, password,phone) VALUES(#{username},#{password},#{phone})")
    public int insertUser(@Param("username") String username, @Param("password")  String password, @Param("phone")  String phone);

    @Select("select * from user where username = #{username}")
    public User login(@Param("username") String username, @Param("password")  String password);

    @Insert("INSERT INTO session(session_id, session) VALUES(#{session_id},#{session})")
    public void insertSession(@Param("session_id") String sessionId, @Param("session")  String session);

}
