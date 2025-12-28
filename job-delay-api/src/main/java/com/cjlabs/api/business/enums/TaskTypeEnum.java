package com.cjlabs.api.business.enums;

import com.cjlabs.domain.enums.IEnumStr;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 任务类型枚举
 * HTTP - HTTP 调用
 * MQ - 消息队列（Kafka）
 */
@Getter
@AllArgsConstructor
public enum TaskTypeEnum implements IEnumStr {
    /**
     * HTTP 调用
     */
    HTTP("HTTP", "HTTP调用"),

    /**
     * 消息队列（Kafka）
     */
    MQ("MQ", "消息队列"),

    ;

    private final String code;
    private final String msg;
}