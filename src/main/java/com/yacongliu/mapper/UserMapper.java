package com.yacongliu.mapper;

import com.github.abel533.mapper.Mapper;
import com.yacongliu.pojo.User;
import com.yacongliu.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yacongliu on 2017/7/27.
 * @desc User 表数据库控制层接口
 * @since v1.0.0
 */
public interface UserMapper extends Mapper<User> {

        UserVo selectUserVoById(@Param("id") Long id);

        List<Map<String, Object>> selectUserPage(Map<String, Object> params);
}
