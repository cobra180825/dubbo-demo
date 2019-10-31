package org.cobra.mapper;

import org.apache.ibatis.annotations.Delete;
import org.cobra.entity.User;

import java.util.List;

//@Mapper
public interface UserMapper {
    //    @Select("select * from user")
    List<User> findAll();

    @Delete("delete from t_user where id = #{id}")
    void deleteById(int id);
}
