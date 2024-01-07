package tech.btzstudio.president.infra.server.request;

import java.util.UUID;

public record RoomReachingRequest(UUID playerId, String name, boolean isNew) {
}
