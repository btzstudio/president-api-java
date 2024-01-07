package tech.btzstudio.president.auth.response;

import org.springframework.http.HttpStatusCode;

import java.util.UUID;

public record AuthResponse(UUID token) {
}
