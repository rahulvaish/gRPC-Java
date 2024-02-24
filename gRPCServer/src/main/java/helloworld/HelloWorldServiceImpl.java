package helloworld;

import com.proto.helloworld.EmptyReq;
import com.proto.helloworld.EmptyReqResp;
import com.proto.helloworld.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void printHelloWorld(EmptyReq req, StreamObserver<EmptyReqResp> responseObserver) {
        responseObserver.onNext(EmptyReqResp.newBuilder().setMessage("Hello World").build());
        responseObserver.onCompleted();
    }

}
