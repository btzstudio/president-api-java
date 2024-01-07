package tech.btzstudio.president.infra.server;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import tech.btzstudio.president.infra.server.request.RoomReachingRequest;
import tech.btzstudio.president.room.domain.RoomHandler;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@Log4j2
@Component
public class RoomReachingListener implements DataListener<RoomReachingRequest> {

    private final Collection<RoomHandler> handlers;

    public RoomReachingListener (Collection<RoomHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void onData (SocketIOClient client, RoomReachingRequest request, AckRequest ack) throws Exception {
        RoomReachingListener.log.info(request);
        var res = this.handlers.stream()
            .filter(handler -> handler.supports(request))
            .findFirst()
            .map(handler -> handler.handle(request))
            .map(CompletableFuture::join)
            .orElseThrow(UnrecognizedRequestException::new)
        ;

        var broadcast = client.getNamespace().getBroadcastOperations();
        broadcast.sendEvent(res.event().toString(), client, res.room());

        if (ack.isAckRequested()) {
            ack.sendAckData("OK");
        }
    }
}
