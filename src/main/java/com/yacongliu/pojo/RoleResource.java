package com.yacongliu.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yacongliu on 2017/7/26.
 * @since v1.0.0
 */
@Table(name = "role_resource")
public class RoleResource implements Serializable {
        private static final long serialVersionUID = 6836909915874853111L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /*角色id*/
        @Column(name = "role_id")
        private Long roleId;

        /*资源id*/
        @Column(name = "resource_id")
        private Long resourceId;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getRoleId() {
                return roleId;
        }

        public void setRoleId(Long roleId) {
                this.roleId = roleId;
        }

        public Long getResourceId() {
                return resourceId;
        }

        public void setResourceId(Long resourceId) {
                this.resourceId = resourceId;
        }

        @Override
        public String toString() {
                return "RoleResource{" +
                        "id=" + id +
                        ", roleId=" + roleId +
                        ", resourceId=" + resourceId +
                        '}';
        }
}

