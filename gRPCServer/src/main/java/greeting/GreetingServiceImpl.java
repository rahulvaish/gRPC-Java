package greeting;

import com.proto.greeting.*;
import io.grpc.stub.StreamObserver;

import static java.lang.Thread.sleep;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greetManyTimes(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        GreetingResponse response = GreetingResponse.newBuilder().setResult("Hello " + request.getFirstName()).build();
        for(int i=0;i<10;i++){
            try {
                sleep(2000);
                responseObserver.onNext(response);
            }catch (Exception e){
                System.out.println("Exception occurred"+ e);
            }
        }
        responseObserver.onCompleted();
    }

}
