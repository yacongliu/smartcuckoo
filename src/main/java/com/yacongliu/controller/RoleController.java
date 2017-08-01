package com.yacongliu.controller;

import com.yacongliu.controller.common.BaseController;
import com.yacongliu.service.impl.RoleServiceImpl;
import com.yacongliu.vo.PageInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 权限管理
 *
 * @author yacongliu on 2017/7/31.
 * @since v1.0.0
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

        @Autowired
        private RoleServiceImpl roleService;

        @RequestMapping(value = "/manager", method = RequestMethod.GET)
        public String manager() {
                return "admin/role";
        }

        /**
         * 权限管理列表
         *
         * @param page
         * @param rows
         * @param sort
         * @param order
         * @return
         */
        @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
        @ResponseBody
        public Object dataGrid(Integer page, Integer rows, String sort, String order) {
                PageInfoVo pageInfoVo = new PageInfoVo(page, rows, sort, order);

                this.roleService.selectDataGrid(pageInfoVo);

                return pageInfoVo;

        }
}
