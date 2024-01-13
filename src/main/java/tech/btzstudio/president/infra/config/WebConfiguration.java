package tech.btzstudio.president.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.btzstudio.president.auth.player.PlayerInjectableParameterResolver;
import tech.btzstudio.president.auth.player.PlayerRestrictedInterceptor;
import tech.btzstudio.president.infra.request.RateLimitationInterceptor;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final RateLimitationInterceptor limitationInterceptor;
    private final PlayerRestrictedInterceptor authorizationInterceptor;
    private final PlayerInjectableParameterResolver playerParameterResolver;

    public WebConfiguration (RateLimitationInterceptor limitationInterceptor, PlayerRestrictedInterceptor authorizationInterceptor, PlayerInjectableParameterResolver playerParameterResolver) {
        this.limitationInterceptor = limitationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
        this.playerParameterResolver = playerParameterResolver;
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(this.limitationInterceptor).addPathPatterns("/**");
        registry.addInterceptor(this.authorizationInterceptor);
    }

    @Override
    public void addArgumentResolvers (List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(this.playerParameterResolver);
    }
}
