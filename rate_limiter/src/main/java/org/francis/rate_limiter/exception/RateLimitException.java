package org.francis.rate_limiter.exception;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
public class RateLimitException extends Exception {
    public RateLimitException(String message) {
        super(message);
    }
}
