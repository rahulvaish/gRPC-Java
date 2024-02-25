package greeting;

import com.proto.greeting.*;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public StreamObserver<GreetingRequest> greetEveryone(StreamObserver<GreetingResponse> responseObserver) {
        return new StreamObserver<GreetingRequest>() {
            //Iterate through the request, and pick Name#1,
            //Wait for 10 seconds
            //Send back to client
            //---------------------------------------------
            //Iterate through the request, and pick Name#2,
            //Wait for 10 seconds
            //Send back to client
            //---------------------------------------------
            //Iterate through the request, and pick Name#3,
            //Wait for 10 seconds
            //Send back to client
            @Override
            public void onNext(GreetingRequest request) {
                try{
                    Thread.sleep(10000);
                }catch(Exception e){
                    System.out.println("Exception"+ e);
                }
                responseObserver.onNext(GreetingResponse.newBuilder().setResult("Hello " + request.getFirstName()).build());
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

}
