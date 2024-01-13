package tech.btzstudio.president.player.request;

import jakarta.validation.constraints.NotEmpty;

public record PlayerCreationRequest(@NotEmpty String name) {
}
