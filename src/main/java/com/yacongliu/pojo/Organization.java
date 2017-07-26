package com.yacongliu.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yacongliu on 2017/7/26.
 * @since v1.0.0
 */
@Table(name = "organization")
public class Organization implements Serializable {
    private static final long serialVersionUID = 1611248676229453163L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*组织名称*/
    private String name;
    /*地址*/
    private String address;
    /*编号*/
    private String code;
    /*图标*/
    private String icon;
    /*父级主键*/
    private Long pid;
    /*排序*/
    private Integer seq;
    private Date createTime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", icon='" + icon + '\'' +
                ", pid=" + pid +
                ", seq=" + seq +
                ", createTime=" + createTime +
                '}';
    }
}
