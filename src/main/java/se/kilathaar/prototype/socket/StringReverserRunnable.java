package se.kilathaar.prototype.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StringReverserRunnable implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(StringReverserRunnable.class);
    private final Socket socket;

    StringReverserRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        LOG.info("Ansluten: {}", socket);

        try (var in = new Scanner(socket.getInputStream());
             var out = new PrintWriter(socket.getOutputStream(), true)) {
            while (in.hasNextLine()) {
                out.println(new StringReverser().reverse(in.nextLine()));
            }
        } catch (Exception e) {
            LOG.error("Error: {}", socket, e);
        }
    }
}
