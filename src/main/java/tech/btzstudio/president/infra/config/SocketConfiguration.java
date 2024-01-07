package tech.btzstudio.president.infra.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import tech.btzstudio.president.auth.AuthService;
import tech.btzstudio.president.auth.WebSocketAuthorizationListener;

@Log4j2
@CrossOrigin
@EnableAutoConfiguration
@Component
public class SocketConfiguration {

    @Value ("${socket.host}")
    private String socketHost;

    @Value ("${socket.port}")
    private int socketPort;

    private final AuthService authService;

    public SocketConfiguration (AuthService authService) {
        this.authService = authService;
    }

    @Bean
    public SocketIOServer socketIOServer() {
        var config = new Configuration();
        config.setHostname(this.socketHost);
        config.setPort(this.socketPort);
        config.setContext("");
        config.setAuthorizationListener(new WebSocketAuthorizationListener(this.authService));
        return new SocketIOServer(config);
    }
}
