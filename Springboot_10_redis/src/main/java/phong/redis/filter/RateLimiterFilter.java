package phong.redis.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import phong.redis.service.RateLimiterService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RateLimiterFilter implements Filter {
    @Value("${rate-limiter.quota}")
    private int quota;

    @Value("${rate-limiter.window-size-in-millisecond}")
    private long windowSizeInMilliSecond;

    @Autowired
    RateLimiterService rateLimiterService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("RateLimiterFilter starts filtering!");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = servletRequest.getRemoteAddr();
        }
        System.out.println("ipAddress: " + ipAddress);

        boolean isRequestQuotaExceed = rateLimiterService.isRequestQuotaExceed(ipAddress, quota, windowSizeInMilliSecond);
        if (isRequestQuotaExceed) {
            httpServletResponse.reset();
            httpServletResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpServletResponse.getWriter().write("too many requests!");
            httpServletResponse.getWriter().flush();
            System.out.println("RateLimiterFilter done filtering - too many requests!");
            return;
        }
        System.out.println("RateLimiterFilter done filtering - request passed!");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
