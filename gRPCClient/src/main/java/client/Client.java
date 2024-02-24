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
            case "long_greet": doLongGreet(channel); break;
            default: System.out.println("Keyword Invalid: " + args[0]);
        }
        System.out.println("Shutting Down");
        channel.shutdown();
    }

    private static void doLongGreet(ManagedChannel channel) throws InterruptedException {
        System.out.println("Enter doLongGreet");
        GreetingServiceGrpc.GreetingServiceStub stub = GreetingServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetingRequest> stream = stub.longGreet(new StreamObserver<GreetingResponse>() {
            @Override
            public void onNext(GreetingResponse response) {
                System.out.println("RESPONSE FROM SERVER COMES IN ONE SHOT (AFTER 10 SECS)");
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
        latch.await(30, TimeUnit.SECONDS);
    }

}
