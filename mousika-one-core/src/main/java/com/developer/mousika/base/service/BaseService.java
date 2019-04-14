package com.developer.mousika.base.service;


import com.baomidou.mybatisplus.extension.service.IService;

public interface BaseService<T> extends IService<T> {

    boolean updateObject(T t);

    T saveObject(T t);

}
