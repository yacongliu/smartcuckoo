package com.yacongliu.controller;

import com.yacongliu.controller.common.BaseController;
import com.yacongliu.service.impl.UserServiceImpl;
import com.yacongliu.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户管理
 *
 * @author yacongliu on 2017/7/27.
 * @desc
 * @since v1.0.0
 */
@Controller
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

}
