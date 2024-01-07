package tech.btzstudio.president.auth;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.AuthorizationResult;
import com.corundumstudio.socketio.HandshakeData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class WebSocketAuthorizationListener implements AuthorizationListener {

    @Value ("${http.request.header.token.name}")
    private String tokenHeaderName;

    private final AuthService authService;

    public WebSocketAuthorizationListener (AuthService authService) {
        this.authService = authService;
    }

    @Override
    public AuthorizationResult getAuthorizationResult (HandshakeData handshakeData) {
        var headers = handshakeData.getHttpHeaders();

//        return Optional.ofNullable(headers.getAsString(this.tokenHeaderName))
//            .map(token -> this.authService.findSession(UUID.fromString(token)))
//            .flatMap(CompletableFuture::resultNow)
//            .map(player -> AuthorizationResult.SUCCESSFUL_AUTHORIZATION)
//            .orElse(AuthorizationResult.FAILED_AUTHORIZATION)
//        ;

        return null;
    }
}
