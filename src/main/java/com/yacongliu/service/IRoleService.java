package com.yacongliu.service;

import com.yacongliu.pojo.Role;
import com.yacongliu.service.common.IService;
import com.yacongliu.vo.PageInfoVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Role 表数据服务层接口
 *
 * @author yacongliu on 2017/7/29.
 * @description Role 表数据服务层接口
 * @since v1.0.0
 */
public interface IRoleService extends IService<Role> {

        void selectDataGrid(PageInfoVo pageInfo);

        Object selectTree();

        List<Long> selectResourceIdListByRoleId(Long id);

        void updateRoleResource(Long id, String resourceIds);

        Map<String, Set<String>> selectResourceMapByUserId(Long userId);
}
