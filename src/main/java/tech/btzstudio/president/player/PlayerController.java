package tech.btzstudio.president.player;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.btzstudio.president.player.request.PlayerCreationRequest;
import tech.btzstudio.president.player.response.PlayerResponse;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController (PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/players")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse createPlayer(@Valid @RequestBody PlayerCreationRequest playerRequest) {
        return this.playerService.createPlayer(playerRequest);
    }
}
