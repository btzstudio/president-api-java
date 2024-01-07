package tech.btzstudio.president.auth.player;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

@Component
public class PlayerInjectableParameterResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter (MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PlayerInjectable.class);
    }

    @Override
    public Object resolveArgument (MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return Optional.ofNullable(webRequest.getAttribute("player", RequestAttributes.SCOPE_REQUEST))
            .orElseThrow(PlayerInjectableInjectionException::new)
        ;
    }
}
