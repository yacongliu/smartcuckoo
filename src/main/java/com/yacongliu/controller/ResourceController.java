package com.yacongliu.controller;

import com.yacongliu.controller.common.BaseController;
import com.yacongliu.pojo.Resource;
import com.yacongliu.service.impl.ResourceServiceImpl;
import com.yacongliu.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 资源管理
 *
 * @author yacongliu on 2017/7/30.
 * @since v1.0.0
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController {
        @Autowired
        private ResourceServiceImpl resourceService;

        /**
         * 菜单树
         * （尚未进行权限控制）
         *
         * @return
         */

        @RequestMapping(value = "/tree", method = RequestMethod.POST)
        @ResponseBody
        public List<Tree> tree() {
                return this.resourceService.selectAllMenu();
        }

        /**
         * 资源管理页
         *
         * @return
         */
        @RequestMapping(value = "/manager", method = RequestMethod.GET)
        public String manager() {
                return "admin/resource";
        }

        /**
         * 资源管理列表
         *
         * @return
         */
        @RequestMapping(value = "/treeGrid", method = RequestMethod.POST)
        @ResponseBody
        public Object treeGrid() {
                return this.resourceService.selectList();
        }

        /**
         * 资源管理添加页
         *
         * @return
         */
        @RequestMapping(value = "/addPage", method = RequestMethod.GET)
        public String addPage() {
                return "admin/resourceAdd";
        }

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        @ResponseBody
        public Object add(Resource resource) {
                /*ID 置空，防止恶意ID，保持数据库ID 自增长*/
                resource.setId(null);
                resource.setCreateTime(new Date());
                Integer resourceType = resource.getResourceType();
                //选择菜单时将openMode设置为null
                if (resourceType != null && resourceType == 0) {
                        resource.setOpenMode(null);
                }

                this.resourceService.insert(resource);
                return renderSuccess("添加成功！");

        }

        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        @ResponseBody
        public Object delete(Long id) {
                this.resourceService.deleteById(id);
                return renderSuccess("删除成功！");
        }

}
