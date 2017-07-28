package com.yacongliu.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yacongliu.pojo.Role;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yacongliu on 2017/7/27.
 * @desc user 传输对象
 * @since v1.0.0
 */
public class UserVo implements Serializable {
        private static final long serialVersionUID = 7458661713058187915L;

        private Long id;

        private String username;

        private String email;

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @JsonIgnore
        private String password;

        /*密码加密盐*/
        @JsonIgnore
        private String salt;

        private Integer status;

        private Integer organizationId;

        private Date createTime;

        private List<Role> rolesList;

        private String organizationName;

        private String roleIds;

        private Date createdateStart;

        private Date createdateEnd;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username == null ? null : username.trim();
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password == null ? null : password.trim();
        }

        public String getSalt() {
                return salt;
        }

        public void setSalt(String salt) {
                this.salt = salt;
        }

        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }

        public Integer getOrganizationId() {
                return organizationId;
        }

        public void setOrganizationId(Integer organizationId) {
                this.organizationId = organizationId;
        }

        public Date getCreateTime() {
                return createTime;
        }

        public void setCreateTime(Date createTime) {
                this.createTime = createTime;
        }

        public List<Role> getRolesList() {
                return rolesList;
        }

        public void setRolesList(List<Role> rolesList) {
                this.rolesList = rolesList;
        }

        public String getOrganizationName() {
                return organizationName;
        }

        public void setOrganizationName(String organizationName) {
                this.organizationName = organizationName;
        }

        public String getRoleIds() {
                return roleIds;
        }

        public void setRoleIds(String roleIds) {
                this.roleIds = roleIds;
        }

        public Date getCreatedateStart() {
                return createdateStart;
        }

        public void setCreatedateStart(Date createdateStart) {
                this.createdateStart = createdateStart;
        }

        public Date getCreatedateEnd() {
                return createdateEnd;
        }

        public void setCreatedateEnd(Date createdateEnd) {
                this.createdateEnd = createdateEnd;
        }

        @Override
        public String toString() {
                return "UserVo{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password + '\'' +
                        ", salt='" + salt + '\'' +
                        ", status=" + status +
                        ", organizationId=" + organizationId +
                        ", createTime=" + createTime +
                        ", rolesList=" + rolesList +
                        ", organizationName='" + organizationName + '\'' +
                        ", roleIds='" + roleIds + '\'' +
                        ", createdateStart=" + createdateStart +
                        ", createdateEnd=" + createdateEnd +
                        '}';
        }
}
