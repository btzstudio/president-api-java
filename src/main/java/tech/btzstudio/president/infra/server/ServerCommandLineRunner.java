package tech.btzstudio.president.infra.server;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServerCommandLineRunner implements CommandLineRunner, DisposableBean {

    private final SocketServerFacade serverFacade;

    @Override
    public void run(String... args) throws Exception {
        this.serverFacade.subscribe().start();
    }

    @Override
    public void destroy () {
        this.serverFacade.stop();
    }
}