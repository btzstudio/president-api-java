package tech.btzstudio.president.infra.server;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import tech.btzstudio.president.infra.server.request.RoomReachingRequest;

@Log4j2
@Component
public class SocketServerFacade {

    private final SocketIOServer server;
    private final ConnectListener connectListener;
    private final DisconnectListener disconnectListener;
    private final RoomReachingListener reachingListener;

    public SocketServerFacade (SocketIOServer server, ConnectListener connectListener, DisconnectListener disconnectListener, RoomReachingListener reachingListener) {
        this.server = server;
        this.connectListener = connectListener;
        this.disconnectListener = disconnectListener;
        this.reachingListener = reachingListener;
    }

    public SocketServerFacade subscribe () {
        this.server.addConnectListener(this.connectListener);
        this.server.addDisconnectListener(this.disconnectListener);
        this.server.addEventInterceptor((client, eventName, args, ackRequest) -> {
            SocketServerFacade.log.info("hello world {}", eventName);
        });
        this.server.addEventListener("room-join", RoomReachingRequest.class, this.reachingListener);

        return this;
    }

    public void start() {
        this.server.start();
    }

    public void stop() {
        this.server.stop();
    }
}
