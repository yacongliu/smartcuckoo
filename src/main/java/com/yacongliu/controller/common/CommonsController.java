package com.yacongliu.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yacongliu on 2017/7/31.
 * @since v1.0.0
 */
@Controller
public class CommonsController {
        /**
         * 图标页
         *
         * @return
         */
        @RequestMapping(value = "icons.html", method = RequestMethod.GET)
        public String icons() {
                return "icons";
        }
}
