package com.developer.mousika.service.impl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.TableInfoHelper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.developer.mousika.generator.config.BaseConstants;
import com.developer.mousika.exception.BadRequestAlertException;
import com.developer.mousika.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @param <M>
 * @param <T>
 */
@Transactional(rollbackFor = Exception.class)
public class BaseServiceImpl<M extends BaseMapper<T>, T extends Model> extends ServiceImpl<M, T> implements BaseService<T> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 忽略验证的属性
     */
    private final List<String> ignoreList = Arrays.asList("id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "serialVersionUID","versionLock");


    private boolean updateObjectWithCompare(T t, T val) {
        boolean result = false;
        boolean flag = checkVal(t, val);
        //数据有变更，执行更新操作，否则不更新
        if (!flag) {
            result = updateById(t);
            if (!result) {
                throw new BadRequestAlertException(BaseConstants.VERSION_LOCK_MESSAGE, t.getClass().getSimpleName(), BaseConstants.VERSION_LOCK_CODE);
            }
        } else {
            result = true;
            BeanUtils.copyProperties(val, t);
        }
        return result;
    }
    @Override
    public boolean updateObject(T t) {
        logger.info("更新数据{}",t);
        Class<?> cls = t.getClass();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
        boolean result = false;
        if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
            Object id = ReflectionKit.getMethodValue(cls, t, tableInfo.getKeyProperty());
            if (null != id) {
                T val = getById(String.valueOf(id));
                boolean flag = checkVal(t, val);
                //数据有变更，执行更新操作，否则不更新
                if (!flag) {
                    result = updateById(t);
                    if (!result) {
                        throw new BadRequestAlertException(BaseConstants.VERSION_LOCK_MESSAGE, t.getClass().getSimpleName(), BaseConstants.VERSION_LOCK_CODE);
                    }
                } else {
                    result = true;
                    BeanUtils.copyProperties(val, t);
                }
            } else {
                throw new MybatisPlusException("Error:  Can not execute. The primary key is null!");
            }
        } else {
            throw new MybatisPlusException("Error:  Can not execute. The primary key is not exits!");
        }
        return result;
    }

    @Override
    public T saveObject(T t) {
        logger.info("添加数据{}", t);
        Class<?> tClass = t.getClass();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(tClass);
        if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
            Object id = ReflectionKit.getMethodValue(tClass, t, tableInfo.getKeyProperty());
            if (null == id) {
                if (!this.save(t)) {
                    throw new BadRequestAlertException(BaseConstants.INSERT_ERROR_MESSAGE,t.getClass().getSimpleName(),BaseConstants.INSERT_ERROR_CODE);
                }
                return t;
            }
            T oldval = this.getById(String.valueOf(id));
            if (null == oldval) {
                if (!this.save(t)) {
                    throw new BadRequestAlertException(BaseConstants.INSERT_ERROR_MESSAGE,t.getClass().getSimpleName(),BaseConstants.INSERT_ERROR_CODE);
                }
                return t;
            }else {
                if (!this.updateObjectWithCompare(t,oldval)) {
                    throw new BadRequestAlertException(BaseConstants.VERSION_LOCK_MESSAGE, t.getClass().getSimpleName(), BaseConstants.VERSION_LOCK_CODE);
                }
                return t;
            }
        }
        return null;
    }

    /**
     * 检查数据是否一致
     *
     * @param willPersist
     * @param persisted
     * @return
     * @throws Exception
     */
    public boolean checkVal(T willPersist , T persisted) {
        boolean flag = true;
        Class clazz = willPersist.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String name;
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                name = field.getName();
                if (ignoreList.contains(name)) {
                    continue;
                }
                if (field.isAnnotationPresent(TableField.class)
                        && !field.getAnnotation(TableField.class).exist()) {
                    continue;
                }
                Object willPersistObj = field.get(willPersist);
                Object persistObj = field.get(persisted);
                if(null == willPersistObj){
                    field.set(willPersist,persistObj);
                    continue;
                }
                if(!willPersistObj.equals(persistObj)){
                    flag=false;
                }
            }
        } catch (IllegalAccessException e) {
            logger.error("checkVal IllegalAccessException", e);
            throw new RuntimeException("checkVal IllegalAccessException");
        }
        return flag;
    }
}
