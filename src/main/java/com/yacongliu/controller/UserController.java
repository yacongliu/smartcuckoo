package com.yacongliu.controller;

import com.yacongliu.controller.common.BaseController;
import com.yacongliu.service.impl.UserServiceImpl;
import com.yacongliu.util.StringUtil;
import com.yacongliu.vo.PageInfoVo;
import com.yacongliu.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理
 *
 * @author yacongliu on 2017/7/27.
 * @desc
 * @since v1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

        @Autowired
        private UserServiceImpl userService;

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String getLogin() {
                return "login";
        }

        @RequestMapping(value = "/login", method = RequestMethod.POST)
        public String login(UserVo userVo) {
                System.out.println(userVo);

                userService.insertByVo(userVo);
                return "welcome";
        }

        @RequestMapping(value = "/regist", method = RequestMethod.GET)
        public String getRegist() {
                return "signup";
        }

        @RequestMapping(value = "/regist", method = RequestMethod.POST)
        public String regist(UserVo userVo) {
                userService.insertByVo(userVo);
                return "login";
        }

        @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
        @ResponseBody
        public Object dataGrid(UserVo userVo, Integer page, Integer rows, String sort, String order) {
                PageInfoVo pageInfoVo = new PageInfoVo(page, rows, sort, order);

                Map<String, Object> condition = new HashMap<String, Object>();

                if (StringUtil.isNotEmpty(userVo.getUsername())) {
                        condition.put("username", userVo.getUsername());
                }

                if (userVo.getOrganizationId() != null) {
                        condition.put("organizationId", userVo.getOrganizationId());
                }

                if (userVo.getCreatedateStart() != null) {
                        condition.put("startTime", userVo.getCreatedateStart());
                }

                if (userVo.getCreatedateEnd() != null) {
                        condition.put("endTime", userVo.getCreatedateEnd());
                }

                pageInfoVo.setCondition(condition);
                this.userService.selectDataGrid(pageInfoVo);
                return pageInfoVo;
        }

        @RequestMapping(value = "/manager", method = RequestMethod.GET)
        public String manager() {
                return "admin/user";
        }

}
