package tech.btzstudio.president.infra.request;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;

@Component
public class RateLimitationInterceptor implements HandlerInterceptor {

    private final Bucket bucket;

    @Value ("${http.request.limit}")
    private short limitPerMinute = 25;

    public RateLimitationInterceptor () {
        this.bucket = Bucket.builder()
            .addLimit(Bandwidth.classic(this.limitPerMinute, Refill.greedy(this.limitPerMinute, Duration.ofMinutes(1))))
            .build();
    }

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!bucket.tryConsume(1)) {
            throw new HttpClientErrorException(HttpStatus.TOO_MANY_REQUESTS);
        }

        return true;
    }
}
