package tech.btzstudio.president.room.domain;

import tech.btzstudio.president.infra.server.request.RoomReachingRequest;
import tech.btzstudio.president.infra.server.response.RoomReachingResponse;
import tech.btzstudio.president.room.RoomOperationFailureException;

import java.util.concurrent.CompletableFuture;

public interface RoomHandler {

    boolean supports(final RoomReachingRequest request);

    CompletableFuture<RoomReachingResponse> handle(final RoomReachingRequest request);
}
