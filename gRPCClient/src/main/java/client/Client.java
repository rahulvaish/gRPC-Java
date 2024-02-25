package client;

import com.proto.greeting.GreetingRequest;
import com.proto.greeting.GreetingResponse;
import com.proto.greeting.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("Need one argument to work");
            return;
        }
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        //CONTROLLER
        switch (args[0]) {
            case "greet_everyone": doGreetEveryone(channel); break;
            default: System.out.println("Keyword Invalid: " + args[0]);
        }
        System.out.println("Shutting Down");
        channel.shutdown();
    }

    private static void doGreetEveryone(ManagedChannel channel) throws InterruptedException {
        System.out.println("Enter doGreetEveryone");
        GreetingServiceGrpc.GreetingServiceStub stub = GreetingServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetingRequest> stream = stub.greetEveryone(new StreamObserver<GreetingResponse>() {
            // Executes when the server sends a response.
            @Override
            public void onNext(GreetingResponse response) {
                System.out.println(response.getResult());
            }

            @Override
            public void onError(Throwable t) {}

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        });

        Arrays.asList("Rahul", "Kritika", "Vani").forEach(name ->
                stream.onNext(GreetingRequest.newBuilder().setFirstName(name).build())
        );
        stream.onCompleted();
        //noinspection ResultOfMethodCallIgnored
        latch.await(30000, TimeUnit.SECONDS);
    }


}
