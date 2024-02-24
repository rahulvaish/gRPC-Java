package server;
import greeting.GreetingServiceImpl;
import io.grpc.ServerBuilder;

import java.io.IOException;

public final class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;

        io.grpc.Server server = ServerBuilder.forPort(port)
                .addService(new GreetingServiceImpl())
                .build();

        server.start();
        System.out.println("Server Started");
        System.out.println("Listening on port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Server Stopped");
        }));

        server.awaitTermination();
    }
}