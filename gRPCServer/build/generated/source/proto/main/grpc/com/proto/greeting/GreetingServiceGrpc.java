package com.proto.greeting;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: greeting.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GreetingServiceGrpc {

  private GreetingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "greeting.GreetingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.greeting.GreetingRequest,
      com.proto.greeting.GreetingResponse> getLongGreetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "longGreet",
      requestType = com.proto.greeting.GreetingRequest.class,
      responseType = com.proto.greeting.GreetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.greeting.GreetingRequest,
      com.proto.greeting.GreetingResponse> getLongGreetMethod() {
    io.grpc.MethodDescriptor<com.proto.greeting.GreetingRequest, com.proto.greeting.GreetingResponse> getLongGreetMethod;
    if ((getLongGreetMethod = GreetingServiceGrpc.getLongGreetMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getLongGreetMethod = GreetingServiceGrpc.getLongGreetMethod) == null) {
          GreetingServiceGrpc.getLongGreetMethod = getLongGreetMethod =
              io.grpc.MethodDescriptor.<com.proto.greeting.GreetingRequest, com.proto.greeting.GreetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "longGreet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.greeting.GreetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.greeting.GreetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GreetingServiceMethodDescriptorSupplier("longGreet"))
              .build();
        }
      }
    }
    return getLongGreetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreetingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingServiceStub>() {
        @java.lang.Override
        public GreetingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingServiceStub(channel, callOptions);
        }
      };
    return GreetingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreetingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingServiceBlockingStub>() {
        @java.lang.Override
        public GreetingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingServiceBlockingStub(channel, callOptions);
        }
      };
    return GreetingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreetingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingServiceFutureStub>() {
        @java.lang.Override
        public GreetingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingServiceFutureStub(channel, callOptions);
        }
      };
    return GreetingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *This 'longGreet' becomes longGreet() in generated service class
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.proto.greeting.GreetingRequest> longGreet(
        io.grpc.stub.StreamObserver<com.proto.greeting.GreetingResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getLongGreetMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GreetingService.
   */
  public static abstract class GreetingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GreetingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GreetingService.
   */
  public static final class GreetingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GreetingServiceStub> {
    private GreetingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *This 'longGreet' becomes longGreet() in generated service class
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.greeting.GreetingRequest> longGreet(
        io.grpc.stub.StreamObserver<com.proto.greeting.GreetingResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getLongGreetMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GreetingService.
   */
  public static final class GreetingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GreetingServiceBlockingStub> {
    private GreetingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GreetingService.
   */
  public static final class GreetingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GreetingServiceFutureStub> {
    private GreetingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LONG_GREET = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LONG_GREET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.longGreet(
              (io.grpc.stub.StreamObserver<com.proto.greeting.GreetingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getLongGreetMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.proto.greeting.GreetingRequest,
              com.proto.greeting.GreetingResponse>(
                service, METHODID_LONG_GREET)))
        .build();
  }

  private static abstract class GreetingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreetingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.greeting.Greeting.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GreetingService");
    }
  }

  private static final class GreetingServiceFileDescriptorSupplier
      extends GreetingServiceBaseDescriptorSupplier {
    GreetingServiceFileDescriptorSupplier() {}
  }

  private static final class GreetingServiceMethodDescriptorSupplier
      extends GreetingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GreetingServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreetingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreetingServiceFileDescriptorSupplier())
              .addMethod(getLongGreetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
