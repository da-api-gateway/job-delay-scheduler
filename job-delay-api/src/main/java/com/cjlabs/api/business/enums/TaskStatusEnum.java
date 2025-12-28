package com.cjlabs.api.business.enums;

import com.cjlabs.domain.enums.IEnumStr;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 任务状态枚举
 * PENDING - 待执行
 * PROCESSING - 执行中
 * SUCCESS - 成功
 * FAILED - 失败
 * CANCELED - 已取消
 */
@Getter
@AllArgsConstructor
public enum TaskStatusEnum implements IEnumStr {
    /**
     * 待执行
     */
    PENDING("PENDING", "待执行"),

    /**
     * 执行中
     */
    PROCESSING("PROCESSING", "执行中"),

    /**
     * 成功
     */
    SUCCESS("SUCCESS", "成功"),

    /**
     * 失败
     */
    FAILED("FAILED", "失败"),

    /**
     * 已取消
     */
    CANCELED("CANCELED", "已取消"),

    ;

    private final String code;
    private final String msg;


}