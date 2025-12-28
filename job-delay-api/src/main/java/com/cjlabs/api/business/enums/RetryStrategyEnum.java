package com.cjlabs.api.business.enums;

import com.cjlabs.domain.enums.IEnumStr;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 重试策略枚举
 * NO_RETRY - 不重试
 * LINEAR - 线性递增（重试延迟 = retryDelaySeconds * (retryCount + 1)）
 * EXPONENTIAL - 指数退避（重试延迟 = retryDelaySeconds * 2^retryCount）
 */
@Getter
@AllArgsConstructor
public enum RetryStrategyEnum implements IEnumStr {
    /**
     * 不重试
     */
    NO_RETRY("NO_RETRY", "不重试"),

    /**
     * 线性递增
     * 延迟时间 = retryDelaySeconds * (retryCount + 1)
     * 例如：5000ms * (0+1)=5s, 5000ms * (1+1)=10s, 5000ms * (2+1)=15s
     */
    LINEAR("LINEAR", "线性递增"),

    /**
     * 指数退避
     * 延迟时间 = retryDelaySeconds * 2^retryCount
     * 例如：5000ms * 2^0=5s, 5000ms * 2^1=10s, 5000ms * 2^2=20s
     */
    EXPONENTIAL("EXPONENTIAL", "指数退避"),
    ;

    private final String code;
    private final String msg;

}