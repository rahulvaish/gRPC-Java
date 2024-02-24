package client;

import com.proto.greeting.GreetingRequest;
import com.proto.greeting.GreetingResponse;
import com.proto.greeting.GreetingServiceGrpc;
import com.proto.helloworld.EmptyReq;
import com.proto.helloworld.EmptyReqResp;
import com.proto.helloworld.HelloWorldServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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
            case "greet": doGreet(channel,args[1] ); break;
            case "hw": doPrintHelloWorld(channel); break;
            default: System.out.println("Keyword Invalid: " + args[0]);
        }
        System.out.println("Shutting Down");
        channel.shutdown();
    }

    private static void doGreet(ManagedChannel channel, String name) {
        System.out.println("Enter doGreet");
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        GreetingResponse response = stub.greet(GreetingRequest.newBuilder().setFirstName(name).build());
        System.out.println("Greeting: " + response.getResult());
    }

    private static void doPrintHelloWorld(ManagedChannel channel) {
        System.out.println("Enter doPrintHelloWorld");
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);
        EmptyReqResp response = stub.printHelloWorld(EmptyReq.newBuilder().build());
        System.out.println("HW: " + response.getMessage());
    }

}
