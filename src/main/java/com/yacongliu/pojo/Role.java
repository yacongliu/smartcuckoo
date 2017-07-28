package com.yacongliu.pojo;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yacongliu on 2017/7/26.
 * @desc 角色
 * @since v1.0.0
 */
@Table(name = "role")
public class Role implements Serializable {
        private static final long serialVersionUID = 1025128367057072845L;

        private Long id;

        /*角色名*/
        private String name;

        /*排序号*/
        private Integer seq;

        /*简介*/
        private String description;

        private Integer status;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getSeq() {
                return seq;
        }

        public void setSeq(Integer seq) {
                this.seq = seq;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
        }

        @Override
        public String toString() {
                return "Role{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", seq=" + seq +
                        ", description='" + description + '\'' +
                        ", status=" + status +
                        '}';
        }
}
