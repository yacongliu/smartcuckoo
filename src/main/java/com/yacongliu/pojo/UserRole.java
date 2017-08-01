package com.yacongliu.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yacongliu on 2017/7/26.
 * @since v1.0.0
 */
@Table(name = "user_role")
public class UserRole implements Serializable {
        private static final long serialVersionUID = 3907367313235857129L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /*用户id*/
        @Column(name = "user_id")
        private Long userId;

        /*角色id*/
        @Column(name = "role_id")
        private Long roleId;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public Long getRoleId() {
                return roleId;
        }

        public void setRoleId(Long roleId) {
                this.roleId = roleId;
        }

        @Override
        public String toString() {
                return "UserRole{" +
                        "id=" + id +
                        ", userId=" + userId +
                        ", roleId=" + roleId +
                        '}';
        }
}

