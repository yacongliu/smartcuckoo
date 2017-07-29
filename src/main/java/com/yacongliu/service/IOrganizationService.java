package com.yacongliu.service;

import com.yacongliu.pojo.Organization;
import com.yacongliu.service.common.IService;
import com.yacongliu.vo.Tree;

import java.util.List;

/**
 * Organization 表数据服务层接口
 *
 * @author yacongliu on 2017/7/29.
 * @description Organization 表数据服务层接口
 * @since v1.0.0
 */
public interface IOrganizationService extends IService<Organization> {
        
        List<Tree> selectTree();

        List<Organization> selectTreeGrid();
}
