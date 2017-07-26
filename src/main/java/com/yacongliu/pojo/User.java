package com.yacongliu.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yacongliu on 2017/7/26.
 * @desc 用户
 * @since v1.0.0
 */
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -6538151151577691570L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    /*密码加密盐*/
    private String salt;
    /*用户状态*/
    private Integer status;
    @Column(name = "create_time")
    private Date createTime;


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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
