package helloworld;

import com.proto.helloworld.EmptyReq;
import com.proto.helloworld.EmptyReqResp;
import com.proto.helloworld.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    //printHelloWorld takes 5 seconds to process
    @Override
    public void printHelloWorld(EmptyReq req, StreamObserver<EmptyReqResp> responseObserver) {
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("Exception occurred!");
        }
        responseObserver.onNext(EmptyReqResp.newBuilder().setMessage("Hello World").build());
        responseObserver.onCompleted();
    }

}
