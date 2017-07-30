package com.yacongliu.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author yacongliu on 2017/7/27.
 * @desc tree 组件
 * @since v1.0.0
 */
public class Tree implements Serializable {
        private static final long serialVersionUID = -6741740273121371208L;

        private Long id;

        private String text;

        /*open closed*/
        private String state = "open";

        private boolean checked = false;

        private Object attributes;

        private List<Tree> children;

        private String iconCls;

        private Long pid;

        /*ajax iframe*/
        private String openMode;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public void setState(Integer opened) {
                this.state = (null != opened && opened == 1) ? "open" : "closed";
        }

        public boolean isChecked() {
                return checked;
        }

        public void setChecked(boolean checked) {
                this.checked = checked;
        }

        public Object getAttributes() {
                return attributes;
        }

        public void setAttributes(Object attributes) {
                this.attributes = attributes;
        }

        public List<Tree> getChildren() {
                return children;
        }

        public void setChildren(List<Tree> children) {
                this.children = children;
        }

        public String getIconCls() {
                return iconCls;
        }

        public void setIconCls(String iconCls) {
                this.iconCls = iconCls;
        }

        public Long getPid() {
                return pid;
        }

        public void setPid(Long pid) {
                this.pid = pid;
        }

        public String getOpenMode() {
                return openMode;
        }

        public void setOpenMode(String openMode) {
                this.openMode = openMode;
        }
}
