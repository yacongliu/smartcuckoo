package com.yacongliu.service.common;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.yacongliu.service.common.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * IService 实现类（ 泛型：M 是 mapper 对象，T 是实体 )
 *
 * @author yacongliu on 2017/7/28.
 * @desc IService 实现类（ 泛型：M 是 mapper 对象，T 是实体 )
 * @since v1.0.0
 */
public class ServiceImpl<M extends Mapper<T>, T> implements IService<T> {
        @Autowired
        private Mapper<T> mapper;

        /**
         * @param entity 实体对象
         * @return
         * @desc 插入一条记录
         */
        public boolean insert(T entity) {
                Preconditions.checkNotNull(entity);
                return this.mapper.insert(entity) == 1;
        }

        /**
         * #desc 插入（批量）
         *
         * @param entityList 实体对象列表
         * @return
         */
        public boolean insertBatch(List<T> entityList) {
                return false;
        }

        /**
         * @param entity
         * @return
         * @desc 根据ID物理删除
         */
        public boolean deleteById(Object id) {
                return this.mapper.deleteByPrimaryKey(id) == 1;
        }

        /**
         * @param clazz    类型
         * @param property 属性
         * @param vals     条件列表
         * @return
         * @description 批量删除
         */
        public boolean deleteBatchByIds(Class<T> clazz, String property, List<Object> vals) {
                Example example = new Example(clazz);
                example.createCriteria().andIn(property, vals);
                return this.mapper.deleteByExample(example) != 0;
        }

        /**
         * @param entity
         * @return
         * @desc 更新数据
         */
        public boolean update(T entity) {
                Preconditions.checkNotNull(entity);
                return this.mapper.updateByPrimaryKey(entity) == 1;
        }

        /**
         * @param entity
         * @return
         * @desc 根据条件查询一条数据，如果有多条数据则会抛出异常
         */
        public T selectOne(T entity) {
                return this.mapper.selectOne(entity);
        }

        /**
         * @return
         * @desc 查询所有数据
         */
        public List<T> selectAll() {
                return this.mapper.select(null);
        }


        /**
         * @param entity
         * @return
         * @desc 条件查询
         */
        public List<T> selectListByCondition(T entity) {
                return this.mapper.select(entity);
        }

        /**
         * @param page
         * @param rows
         * @param record
         * @return
         * @desc 分页查询
         */
        public PageInfo selectPageListByCondition(Integer page, Integer rows, T record) {
                PageHelper.startPage(page, rows);
                List<T> list = this.selectListByCondition(record);
                return new PageInfo<T>(list);
        }
}
