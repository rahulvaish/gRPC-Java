package greeting;

import com.proto.greeting.*;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public StreamObserver<GreetingRequest> longGreet(StreamObserver<GreetingResponse> responseObserver) {
        StringBuilder sb = new StringBuilder();

        return new StreamObserver<GreetingRequest>() {
            @Override
            public void onNext(GreetingRequest request) {
                sb.append("Hello ")
                        .append(request.getFirstName())
                        .append("!\n");

            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                try{
                    Thread.sleep(10000);
                }catch(Exception e){
                    System.out.println("Exception"+ e);
                }
                responseObserver.onNext(GreetingResponse.newBuilder().setResult(sb.toString()).build());
                responseObserver.onCompleted();
            }
        };
    }

}
