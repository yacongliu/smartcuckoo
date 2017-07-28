package com.yacongliu.service;

import com.yacongliu.pojo.User;
import com.yacongliu.service.common.IService;
import com.yacongliu.vo.UserVo;

/**
 * @author yacongliu on 2017/7/27.
 * @since v1.0.0
 */
public interface IUserService extends IService<User> {
        void insertByVo(UserVo userVo);
}
