package org.francis.repeat_submit.filter;

import org.francis.repeat_submit.request.RepeatableReadRequestWrapper;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
public class RepeatableRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (StringUtils.startsWithIgnoreCase(request.getContentType(),"application/json")){
            RepeatableReadRequestWrapper requestWrapper = new RepeatableReadRequestWrapper(request, response);
            filterChain.doFilter(requestWrapper, response);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
