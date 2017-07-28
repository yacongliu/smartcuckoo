package com.yacongliu.vo;

import java.io.Serializable;

/**
 * @author yacongliu on 2017/7/21.
 * @since v1.0.0
 */
public class Result implements Serializable {
        private static final long serialVersionUID = -3376085830601848807L;

        public static final int SUCCESS = 1;

        public static final int FAILURE = -1;

        private boolean success = false;

        private String msg = "";

        private Object obj = null;

        public boolean isSuccess() {
                return success;
        }

        public void setSuccess(boolean success) {
                this.success = success;
        }

        public String getMsg() {
                return msg;
        }

        public void setMsg(String msg) {
                this.msg = msg;
        }

        public Object getObj() {
                return obj;
        }

        public void setObj(Object obj) {
                this.obj = obj;
        }
}
