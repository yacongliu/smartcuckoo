package com.yacongliu.service.impl;

import com.github.abel533.entity.Example;
import com.yacongliu.mapper.OrganizationMapper;
import com.yacongliu.pojo.Organization;
import com.yacongliu.service.IOrganizationService;
import com.yacongliu.service.common.ServiceImpl;
import com.yacongliu.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization 表数据服务层接口实现类
 *
 * @author yacongliu on 2017/7/29.
 * @since v1.0.0
 */
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements
        IOrganizationService {

        @Autowired
        private OrganizationMapper organizationMapper;

        public List<Tree> selectTree() {
                List<Organization> organizationList = this.selectTreeGrid();
                List<Tree> trees = new ArrayList<Tree>();
                for (Organization organization : organizationList) {
                        Tree tree = new Tree();
                        tree.setText(organization.getName());
                        tree.setId(organization.getId());
                        tree.setPid(organization.getPid());
                        tree.setIconCls(organization.getIcon());
                        trees.add(tree);
                }
                return trees;
        }

        public List<Organization> selectTreeGrid() {
                /*排序*/
                Example example = new Example(Organization.class);
                example.setOrderByClause("seq asc");
                return this.organizationMapper.selectByExample(example);
        }
}
