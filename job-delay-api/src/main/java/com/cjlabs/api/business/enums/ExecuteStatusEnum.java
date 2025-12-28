package com.cjlabs.api.business.enums;

import com.cjlabs.domain.enums.IEnumStr;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 执行状态枚举
 * RUNNING - 执行中
 * SUCCESS - 成功
 * FAILED - 失败
 * TIMEOUT - 超时
 * CANCELED - 已取消
 */
@Getter
@AllArgsConstructor
public enum ExecuteStatusEnum implements IEnumStr {
    /**
     * 执行中
     */
    RUNNING("RUNNING", "执行中"),

    /**
     * 成功
     */
    SUCCESS("SUCCESS", "成功"),

    /**
     * 失败
     */
    FAILED("FAILED", "失败"),

    /**
     * 超时
     */
    TIMEOUT("TIMEOUT", "超时"),

    /**
     * 已取消
     */
    CANCELED("CANCELED", "已取消"),

    ;

    private final String code;
    private final String msg;

}