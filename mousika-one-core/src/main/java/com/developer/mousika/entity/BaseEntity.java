package com.developer.mousika.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.ToString;

import java.time.Instant;

/**
 * 实体对象基类
 *
 * @param
 * @author system
 * @since 2018-02-28
 */
@ToString
public class BaseEntity<T extends Model> extends Model<T> {
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Instant createdDate;
    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastModifiedBy;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Instant lastModifiedDate;

    /**
     * 乐观锁
     */
    @Version
    private Integer versionLock;

    public T setCreatedBy(String val) {
        this.createdBy = val;
        return (T) this;
    }

    public T setCreatedDate(Instant val) {
        this.createdDate = val;
        return (T) this;
    }

    public T setLastModifiedBy(String val) {
        this.lastModifiedBy = val;
        return (T) this;
    }

    public T setLastModifiedDate(Instant val) {
        this.lastModifiedDate = val;
        return (T) this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Integer getVersionLock() {
        return versionLock;
    }

    public T setVersionLock(Integer versionLock) {
        this.versionLock = versionLock;
        return (T) this;
    }

}
