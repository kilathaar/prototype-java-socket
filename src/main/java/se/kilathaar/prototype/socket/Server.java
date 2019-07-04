package se.kilathaar.prototype.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Server {
    private static final Logger LOG = LoggerFactory.getLogger(Server.class);
    private static final int port = 56789;

    public static void main(String[] args) throws Exception {
        try (var listener = new ServerSocket(port)) {
            LOG.info("Server startad på port {}", port);
            var pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new StringReverserRunnable(listener.accept()));
            }
        }
    }
}