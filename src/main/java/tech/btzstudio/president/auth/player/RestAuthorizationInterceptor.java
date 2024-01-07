package tech.btzstudio.president.auth.player;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import tech.btzstudio.president.infra.persistence.Storable;
import tech.btzstudio.president.player.domain.Player;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class RestAuthorizationInterceptor implements HandlerInterceptor {

    @Value("${http.request.header.token.name}")
    private String tokenHeaderName;

    private final Storable<Player, UUID> playerStorage;

    public RestAuthorizationInterceptor (Storable<Player, UUID> playerStorage) {
        this.playerStorage = playerStorage;
    }

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

        if (handlerMethod.getMethod().isAnnotationPresent(PlayerRestricted.class)) {
            var player = Optional.ofNullable(request.getHeader(this.tokenHeaderName))
                .map(token -> this.playerStorage.findById(UUID.fromString(token)))
                .flatMap(CompletableFuture::resultNow)
                .orElseThrow(InvalidPlayerTokenException::new)
            ;

            request.setAttribute("player", player);
        }

        return true;
    }
}
