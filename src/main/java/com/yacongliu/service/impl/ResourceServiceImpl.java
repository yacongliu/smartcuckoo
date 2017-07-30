package com.yacongliu.service.impl;

import com.github.abel533.entity.Example;
import com.yacongliu.mapper.ResourceMapper;
import com.yacongliu.pojo.Resource;
import com.yacongliu.service.IResourceService;
import com.yacongliu.service.common.ServiceImpl;
import com.yacongliu.util.CollectionUtil;
import com.yacongliu.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Resource 表数据服务层接口实现类
 *
 * @author yacongliu on 2017/7/29.
 * @since v1.0.0
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {
        // 资源类型：菜单
        private static final int RESOURCE_MENU = 0;

        @Autowired
        private ResourceMapper resourceMapper;

        public List<Resource> selectList() {
                Example example = new Example(Resource.class);
                example.setOrderByClause("seq asc");
                return this.resourceMapper.selectByExample(example);
        }

        public List<Tree> selectAllMenu() {
                List<Tree> trees = new ArrayList<Tree>();
                //查询所有的菜单
                List<Resource> resourceList = this.selectByType(RESOURCE_MENU);

                if (CollectionUtil.isEmpty(resourceList)) {
                        return null;
                }

                for (Resource resource : resourceList) {
                        Tree tree = new Tree();
                        tree.setId(resource.getId());
                        tree.setPid(resource.getPid());
                        tree.setText(resource.getName());
                        tree.setAttributes(resource.getUrl());
                        tree.setIconCls(resource.getIcon());
                        tree.setState(resource.getOpened());

                        trees.add(tree);
                }
                return trees;
        }

        public List<Tree> selectAllTree() {
                // 获取所有的资源 tree形式，展示
                List<Resource> resourceList = this.selectList();
                List<Tree> trees = new ArrayList<Tree>();

                if (CollectionUtil.isEmpty(resourceList)) {
                        return null;
                }
                for (Resource resource : resourceList) {
                        Tree tree = new Tree();
                        tree.setId(resource.getId());
                        tree.setPid(resource.getPid());
                        tree.setText(resource.getName());
                        tree.setIconCls(resource.getIcon());
                        tree.setAttributes(resource.getUrl());
                        tree.setState(resource.getOpened());
                        trees.add(tree);
                }
                return trees;
        }

        public List<Resource> selectByType(Integer type) {
                Example example = new Example(Resource.class);
                example.createCriteria().andEqualTo("resourceType", type);
                example.setOrderByClause("seq asc");
                return this.resourceMapper.selectByExample(example);
        }

}
