package com.yacongliu.controller;

import com.yacongliu.controller.common.BaseController;
import com.yacongliu.service.impl.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 组织管理
 *
 * @author yacongliu on 2017/8/1.
 * @since v1.0.0
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController {
        @Autowired
        private OrganizationServiceImpl organizationService;

        @RequestMapping(value = "/manager", method = RequestMethod.GET)
        public String manager() {
                return "admin/organization";
        }

        /**
         * 部门列表
         *
         * @return
         */
        @RequestMapping(value = "/treeGrid", method = RequestMethod.POST)
        @ResponseBody
        public Object treeGrid() {
                return this.organizationService.selectTreeGrid();
        }

}
