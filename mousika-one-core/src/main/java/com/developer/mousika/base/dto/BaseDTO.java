package com.developer.mousika.base.dto;


import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO基类
 *
 * @author
 */
@ToString
public class BaseDTO<T> implements Serializable {

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

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
    public T setVersionLock(Integer versionLock) {
        this.versionLock = versionLock;
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
}
