package com.yacongliu.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Map;

/**
 * @author yacongliu on 2017/7/27.
 * @desc 分页实体类（结合jquery easyui）
 * @since v1.0.0
 */
public class PageInfoVo {
        private final static int PAGESIZE = 10; //默认显示的记录数

        /*总记录*/
        private Integer total;

        /*显示的记录*/
        private List rows;

        @JsonIgnore
        private int from;

        @JsonIgnore
        private int size;

        /*当前页*/
        @JsonIgnore
        private int nowpage;

        /*每页显示的记录数*/
        @JsonIgnore
        private int pagesize;

        /*查询条件*/
        @JsonIgnore
        private Map<String, Object> condition;

        /*排序字段*/
        @JsonIgnore
        private String sort = "seq";

        /*order 关键字*/
        @JsonIgnore
        private String order = "asc";

        public PageInfoVo() {
        }

        public PageInfoVo(int nowpage, int pagesize) {
                if (nowpage < 0) {
                        this.nowpage = 1;
                } else {
                        this.nowpage = nowpage;
                }

                if (pagesize < 0) {
                        this.pagesize = PAGESIZE;
                } else {
                        this.pagesize = pagesize;
                }
                //计算开始的记录和结束的记录
                this.from = (this.nowpage - 1) * pagesize;
                this.size = this.pagesize;
        }

        public PageInfoVo(int nowpage, int pagesize, String sort, String order) {
                // 计算当前页
                if (nowpage < 0) {
                        this.nowpage = 1;
                } else {
                        this.nowpage = nowpage;
                }

                //记录每页显示的记录数
                if (pagesize < 0) {
                        this.pagesize = PAGESIZE;
                } else {
                        this.pagesize = pagesize;
                }
                //计算开始的记录和结束的记录
                this.from = (this.nowpage - 1) * this.pagesize;
                this.size = this.pagesize;
                //排序字段 asc desc
                this.sort = sort;
                this.order = order;
        }

        public Integer getTotal() {
                return total;
        }

        public void setTotal(Integer total) {
                this.total = total;
        }

        public List getRows() {
                return rows;
        }

        public void setRows(List rows) {
                this.rows = rows;
        }

        public int getFrom() {
                return from;
        }

        public void setFrom(int from) {
                this.from = from;
        }

        public int getSize() {
                return size;
        }

        public void setSize(int size) {
                this.size = size;
        }

        public int getNowpage() {
                return nowpage;
        }

        public void setNowpage(int nowpage) {
                this.nowpage = nowpage;
        }

        public int getPagesize() {
                return pagesize;
        }

        public void setPagesize(int pagesize) {
                this.pagesize = pagesize;
        }

        public Map<String, Object> getCondition() {
                return condition;
        }

        public void setCondition(Map<String, Object> condition) {
                this.condition = condition;
        }

        public String getSort() {
                return sort;
        }

        public void setSort(String sort) {
                this.sort = sort;
        }

        public String getOrder() {
                return order;
        }

        public void setOrder(String order) {
                this.order = order;
        }
}
