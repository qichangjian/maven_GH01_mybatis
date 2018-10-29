package com.qcj.mapper;

import com.qcj.pojo.UserInfos;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserInfosMapper {
    @Select("select * from UserInfos")
    List<UserInfos> queryAll();

    @Insert("insert into UserInfos(uname,password) values(#{uname},#{password})")
    int insertUser(UserInfos userInfos);

    @Update("update UserInfos set uname=#{uname} ,password =#{password} where uid = #{uid}")
    int updateUser(UserInfos userInfos);

    @Delete("delete from UserInfos where uid = #{uid}")
    int deleteUser(int uid);
}
