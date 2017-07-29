package com.yacongliu.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yacongliu on 2017/7/26.
 * @desc 资源
 * @since v1.0.0
 */
@Table(name = "resource")
public class Resource implements Serializable {
        private static final long serialVersionUID = 5476057805235345290L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        /*资源名称*/
        private String name;

        /*资源路径*/
        private String url;

        /*打开方式 ajax iframe*/
        private String openMode;

        /*资源介绍*/
        private String description;

        /*资源图标*/
        private String icon;

        /*父级ID*/
        private Long pid;

        /*排序*/
        private Integer seq;

        /*状态*/
        private Integer status;

        /*打开的*/
        private Integer opened;

        /*资源类别 菜单  功能按钮*/
        @Column(name = "resource_type")
        private Integer resourceType;

        @Column(name = "create_time")
        private Date createTime;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getPid() {
                return pid;
        }

        public void setPid(Long pid) {
                this.pid = pid;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getOpenMode() {
                return openMode;
        }

        public void setOpenMode(String openMode) {
                this.openMode = openMode;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getIcon() {
                return icon;
        }

        public void setIcon(String icon) {
                this.icon = icon;
        }

        public Integer getSeq() {
                return seq;
        }

        public void setSeq(Integer seq) {
                this.seq = seq;
        }

        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }

        public Integer getOpened() {
                return opened;
        }

        public void setOpened(Integer opened) {
                this.opened = opened;
        }

        public Integer getResourceType() {
                return resourceType;
        }

        public void setResourceType(Integer resourceType) {
                this.resourceType = resourceType;
        }

        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }

        @Override
        public String toString() {
                return "Resource{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", url='" + url + '\'' +
                        ", openMode='" + openMode + '\'' +
                        ", description='" + description + '\'' +
                        ", icon='" + icon + '\'' +
                        ", pid=" + pid +
                        ", seq=" + seq +
                        ", status=" + status +
                        ", opened=" + opened +
                        ", resourceType=" + resourceType +
                        ", createTime=" + createTime +
                        '}';
        }
}
