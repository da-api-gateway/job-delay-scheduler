package com.cjlabs.api.business.enums;

import com.cjlabs.domain.enums.IEnumStr;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 执行方式枚举
 * SYNC - 同步执行
 * ASYNC - 异步执行
 */
@Getter
@AllArgsConstructor
public enum ExecuteTypeEnum implements IEnumStr {
    /**
     * 同步执行
     */
    SYNC("SYNC", "同步执行"),

    /**
     * 异步执行
     */
    ASYNC("ASYNC", "异步执行"),

    ;

    private final String code;
    private final String msg;

}