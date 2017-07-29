package com.yacongliu.service.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 顶级Service
 *
 * @author yacongliu on 2017/7/28.
 * @desc 顶级Service
 * @since v1.0.0
 */
public interface IService<T> {
        /**
         * @param entity 实体对象
         * @return
         * @desc 插入一条记录
         */
        boolean insert(T entity);

        /**
         * #desc 插入（批量）
         *
         * @param entityList 实体对象列表
         * @return
         */
        boolean insertBatch(List<T> entityList);

        /**
         * @param entity
         * @return
         * @desc 根据ID物理删除
         */
        boolean deleteById(T entity);

        /**
         * @param clazz    类型
         * @param property 属性
         * @param vals     条件列表
         * @return
         * @description 批量删除
         */
        boolean deleteBatchByIds(Class<T> clazz, String property, List<Object> vals);

        /**
         * @param entity
         * @return
         * @desc 更新数据
         */
        boolean update(T entity);

        /**
         * @param entity
         * @return
         * @desc 根据条件查询一条数据，如果有多条数据则会抛出异常
         */
        T selectOne(T entity);

        /**
         * @return
         * @desc 查询所有数据
         */
        List<T> selectAll();

        /**
         * @param entity
         * @return
         * @desc 条件查询
         */
        List<T> selectListByCondition(T entity);

        /**
         * @param page
         * @param rows
         * @param record
         * @return
         * @desc 分页查询
         */
        PageInfo selectPageListByCondition(Integer page, Integer rows, T record);

}
