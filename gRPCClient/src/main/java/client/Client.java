package client;

import com.proto.helloworld.EmptyReq;
import com.proto.helloworld.EmptyReqResp;
import com.proto.helloworld.HelloWorldServiceGrpc;
import io.grpc.*;

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
            case "hw10s": doPrintHelloWorldWithDLAsTenSec(channel); break;
            case "hw1s": doPrintHelloWorldWithDLAsOneSec(channel); break;
            default: System.out.println("Keyword Invalid: " + args[0]);
        }
        System.out.println("Shutting Down");
        channel.shutdown();
    }

    //printHelloWorld (Server) takes 5 seconds  to process
    // If client deadline is 10 seconds -> All Good, as server takes 5 seconds
    private static void doPrintHelloWorldWithDLAsTenSec(ManagedChannel channel) {
        System.out.println("Enter doPrintHelloWorldWithDLAsTenSec");
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);
        try {
            EmptyReqResp response = stub.withDeadline(Deadline.after(10, TimeUnit.SECONDS)).printHelloWorld(EmptyReq.newBuilder().build());
            System.out.println("HW: " + response.getMessage());
        } catch (StatusRuntimeException e){
            if(e.getStatus().getCode() == Status.Code.DEADLINE_EXCEEDED){
                System.out.println("TIMEOUT " + e);
            }
        }
    }

    //printHelloWorld (Server) takes 5 seconds  to process
    //If client deadline is 1 second -> Problem as server takes 2 seconds
    private static void doPrintHelloWorldWithDLAsOneSec(ManagedChannel channel) {
        System.out.println("Enter doPrintHelloWorldWithDLAsOneSec");
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);
        try {
            EmptyReqResp response = stub.withDeadline(Deadline.after(1, TimeUnit.SECONDS)).printHelloWorld(EmptyReq.newBuilder().build());
            System.out.println("HW: " + response.getMessage());
        }catch (StatusRuntimeException e){
            if(e.getStatus().getCode() == Status.Code.DEADLINE_EXCEEDED){
                System.out.println("TIMEOUT " + e);
            }
        }
    }

}
