package com.yacongliu.service.impl;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yacongliu.mapper.RoleMapper;
import com.yacongliu.pojo.Role;
import com.yacongliu.service.IRoleService;
import com.yacongliu.service.common.ServiceImpl;
import com.yacongliu.util.CollectionUtil;
import com.yacongliu.vo.PageInfoVo;
import com.yacongliu.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yacongliu on 2017/7/29.
 * @since v1.0.0
 */
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
        @Autowired
        private RoleMapper roleMapper;

        public List<Role> selectList() {
                Example example = new Example(RoleServiceImpl.class);
                example.setOrderByClause("seq asc");
                return this.roleMapper.selectByExample(example);
        }

        public void selectDataGrid(PageInfoVo pageInfoVo) {
                Example example = new Example(RoleServiceImpl.class);
                example.setOrderByClause(pageInfoVo.getSort() + " " + pageInfoVo.getOrder());
                PageHelper.startPage(pageInfoVo.getNowpage(), pageInfoVo.getPagesize());
                List<Role> roleList = this.roleMapper.selectByExample(example);
                PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);

                pageInfoVo.setTotal((int) pageInfo.getTotal());
                pageInfoVo.setRows(pageInfo.getList());
        }

        public Object selectTree() {
                List<Tree> trees = new ArrayList<Tree>();
                List<Role> roleList = this.selectList();

                if (CollectionUtil.isEmpty(roleList)) {
                        return null;
                }

                for (Role role : roleList) {
                        Tree tree = new Tree();
                        tree.setId(role.getId());
                        tree.setText(role.getName());

                        trees.add(tree);
                }
                return trees;
        }

        public List<Long> selectResourceIdListByRoleId(Long id) {
                return null;
        }

        public void updateRoleResource(Long id, String resourceIds) {

        }

        public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
                return null;
        }
}
