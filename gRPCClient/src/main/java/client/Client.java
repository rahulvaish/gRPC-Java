package client;

import com.proto.greeting.GreetingRequest;
import com.proto.greeting.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2 ) {
            System.out.println("Please check number of arguments");
            return;
        }
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        //CONTROLLER
        switch (args[0]) {
            case "gmt": doGreetManyTimes(channel,args[1] ); break;
            default: System.out.println("Incorrect Argument: " + args[0]);
        }
        System.out.println("Shutting Down");
        channel.shutdown();
    }

    private static void doGreetManyTimes(ManagedChannel channel, String name) {
        System.out.println("Enter doGreetManyTimes");
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        stub.greetManyTimes(GreetingRequest.newBuilder().setFirstName(name).build()).forEachRemaining(response ->{
            System.out.println("Greeting Many Times: " + response.getResult());
        });

    }

}
