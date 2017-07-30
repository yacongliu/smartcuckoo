package com.yacongliu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yacongliu.mapper.UserMapper;
import com.yacongliu.mapper.UserRoleMapper;
import com.yacongliu.pojo.User;
import com.yacongliu.pojo.UserRole;
import com.yacongliu.service.IUserService;
import com.yacongliu.service.common.ServiceImpl;
import com.yacongliu.vo.PageInfoVo;
import com.yacongliu.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User 表数据服务层接口实现类
 *
 * @author yacongliu on 2017/7/28.
 * @desc User 表数据服务层接口实现类
 * @since v1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
        @Autowired
        private UserMapper userMapper;

        @Autowired
        private UserRoleMapper userRoleMapper;

        public void updateByVo(UserVo userVo) {

        }

        public void updatePwdByUserId(Long userId, String md5Hex) {

        }

        public void selectDataGrid(PageInfoVo pageInfoVo) {
                PageHelper.startPage(pageInfoVo.getNowpage(), pageInfoVo.getPagesize());
                List<Map<String, Object>> lists = this.userMapper.selectUserPage(pageInfoVo.getCondition());
                PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(lists);
                pageInfoVo.setRows(pageInfo.getList());
                pageInfoVo.setTotal((int) pageInfo.getTotal());
        }

        public void deleteUserById(Long id) {

        }

        public UserVo selectVoById(Long id) {
                return this.userMapper.selectUserVoById(id);

        }

        public void insertByVo(UserVo userVo) {
                User user = new User();
                BeanUtils.copyProperties(userVo, user);
                user.setStatus(1);
                user.setCreateTime(new Date());
                super.insert(user);

                String[] roles = userVo.getRoleIds().split(",");
                UserRole userRole = new UserRole();
                for (String role : roles) {
                        userRole.setUserId(user.getId());
                        userRole.setRoleId(Long.valueOf(role));
                        this.userRoleMapper.insert(userRole);
                }
        }

}
