package com.yacongliu.service;

import com.yacongliu.pojo.Resource;
import com.yacongliu.service.common.IService;
import com.yacongliu.vo.Tree;

import java.util.List;

/**
 * Resource 表数据服务层接口
 *
 * @author yacongliu on 2017/7/29.
 * @description Resource 表数据服务层接口
 * @since v1.0.0
 */
public interface IResourceService extends IService<Resource> {
        List<Resource> selectAll();

        List<Tree> selectAllMenu();

        List<Tree> selectAllTree();

}
