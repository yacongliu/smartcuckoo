package com.yacongliu.controller;

import com.yacongliu.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基础Controller
 *
 * @author yacongliu on 2017/7/29.
 * @since v1.0.0
 */
public class BaseController {

        private Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

        @InitBinder
        public void initBinder(ServletRequestDataBinder binder) {
                /**
                 * 自动转换日期类型的字段格式
                 */
                binder.registerCustomEditor(Date.class,
                        new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        }

        /**
         * ajax success
         *
         * @return {Object}
         */
        public Object renderSuccess() {
                Result result = new Result();
                result.setSuccess(true);
                return result;
        }

        /**
         * ajax success
         *
         * @param msg 消息
         * @return {Object}
         */
        public Object renderSuccess(String msg) {
                Result result = new Result();
                result.setSuccess(true);
                result.setMsg(msg);
                return result;
        }

        /**
         * aiax success
         *
         * @param obj 成功时的对象
         * @return {Object}
         */
        public Object renderSuccess(Object obj) {
                Result result = new Result();
                result.setSuccess(true);
                result.setObj(obj);
                return result;
        }

        /**
         * ajax 失败
         *
         * @return {Object}
         */
        public Object renderError(String msg) {
                Result result = new Result();
                result.setSuccess(false);
                result.setMsg(msg);
                return result;
        }
}
