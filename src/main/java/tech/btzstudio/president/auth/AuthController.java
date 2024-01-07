package tech.btzstudio.president.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.btzstudio.president.auth.response.AuthResponse;
import tech.btzstudio.president.player.domain.Player;

import java.util.concurrent.ExecutionException;

@RestController
public class AuthController
{
    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/auth")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse auth () throws ExecutionException, InterruptedException {
        return this.authService
            .createSession()
            .thenApply(Player::getSessionId)
            .thenApply(AuthResponse::new)
            .get();
    }
}
