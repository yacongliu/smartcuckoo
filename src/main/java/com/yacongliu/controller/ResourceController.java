package com.yacongliu.controller;

import com.yacongliu.controller.common.BaseController;
import com.yacongliu.service.impl.ResourceServiceImpl;
import com.yacongliu.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
