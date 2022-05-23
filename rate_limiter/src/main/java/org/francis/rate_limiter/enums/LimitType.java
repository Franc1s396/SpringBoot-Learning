package org.francis.rate_limiter.enums;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
public enum LimitType {
    /**
     * 默认限流策略,针对某一个接口进行限流
     */
    DEFAULT,

    /**
     * 针对某一个IP地址限流
     */
    IP
}
