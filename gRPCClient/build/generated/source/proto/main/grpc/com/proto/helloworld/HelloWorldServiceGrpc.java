package com.proto.helloworld;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: helloworld.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloWorldServiceGrpc {

  private HelloWorldServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "greeting.HelloWorldService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.helloworld.EmptyReq,
      com.proto.helloworld.EmptyReqResp> getPrintHelloWorldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrintHelloWorld",
      requestType = com.proto.helloworld.EmptyReq.class,
      responseType = com.proto.helloworld.EmptyReqResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.helloworld.EmptyReq,
      com.proto.helloworld.EmptyReqResp> getPrintHelloWorldMethod() {
    io.grpc.MethodDescriptor<com.proto.helloworld.EmptyReq, com.proto.helloworld.EmptyReqResp> getPrintHelloWorldMethod;
    if ((getPrintHelloWorldMethod = HelloWorldServiceGrpc.getPrintHelloWorldMethod) == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        if ((getPrintHelloWorldMethod = HelloWorldServiceGrpc.getPrintHelloWorldMethod) == null) {
          HelloWorldServiceGrpc.getPrintHelloWorldMethod = getPrintHelloWorldMethod =
              io.grpc.MethodDescriptor.<com.proto.helloworld.EmptyReq, com.proto.helloworld.EmptyReqResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PrintHelloWorld"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.helloworld.EmptyReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.helloworld.EmptyReqResp.getDefaultInstance()))
              .setSchemaDescriptor(new HelloWorldServiceMethodDescriptorSupplier("PrintHelloWorld"))
              .build();
        }
      }
    }
    return getPrintHelloWorldMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloWorldServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceStub>() {
        @java.lang.Override
        public HelloWorldServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloWorldServiceStub(channel, callOptions);
        }
      };
    return HelloWorldServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloWorldServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceBlockingStub>() {
        @java.lang.Override
        public HelloWorldServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloWorldServiceBlockingStub(channel, callOptions);
        }
      };
    return HelloWorldServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloWorldServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloWorldServiceFutureStub>() {
        @java.lang.Override
        public HelloWorldServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloWorldServiceFutureStub(channel, callOptions);
        }
      };
    return HelloWorldServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *This 'PrintHelloWorld' becomes printHelloWorld() in generated service class
     * </pre>
     */
    default void printHelloWorld(com.proto.helloworld.EmptyReq request,
        io.grpc.stub.StreamObserver<com.proto.helloworld.EmptyReqResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintHelloWorldMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HelloWorldService.
   */
  public static abstract class HelloWorldServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HelloWorldServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HelloWorldService.
   */
  public static final class HelloWorldServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HelloWorldServiceStub> {
    private HelloWorldServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *This 'PrintHelloWorld' becomes printHelloWorld() in generated service class
     * </pre>
     */
    public void printHelloWorld(com.proto.helloworld.EmptyReq request,
        io.grpc.stub.StreamObserver<com.proto.helloworld.EmptyReqResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrintHelloWorldMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HelloWorldService.
   */
  public static final class HelloWorldServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HelloWorldServiceBlockingStub> {
    private HelloWorldServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *This 'PrintHelloWorld' becomes printHelloWorld() in generated service class
     * </pre>
     */
    public com.proto.helloworld.EmptyReqResp printHelloWorld(com.proto.helloworld.EmptyReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrintHelloWorldMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HelloWorldService.
   */
  public static final class HelloWorldServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HelloWorldServiceFutureStub> {
    private HelloWorldServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *This 'PrintHelloWorld' becomes printHelloWorld() in generated service class
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.helloworld.EmptyReqResp> printHelloWorld(
        com.proto.helloworld.EmptyReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrintHelloWorldMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRINT_HELLO_WORLD = 0;

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
        case METHODID_PRINT_HELLO_WORLD:
          serviceImpl.printHelloWorld((com.proto.helloworld.EmptyReq) request,
              (io.grpc.stub.StreamObserver<com.proto.helloworld.EmptyReqResp>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPrintHelloWorldMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.proto.helloworld.EmptyReq,
              com.proto.helloworld.EmptyReqResp>(
                service, METHODID_PRINT_HELLO_WORLD)))
        .build();
  }

  private static abstract class HelloWorldServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloWorldServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.helloworld.Helloworld.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloWorldService");
    }
  }

  private static final class HelloWorldServiceFileDescriptorSupplier
      extends HelloWorldServiceBaseDescriptorSupplier {
    HelloWorldServiceFileDescriptorSupplier() {}
  }

  private static final class HelloWorldServiceMethodDescriptorSupplier
      extends HelloWorldServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HelloWorldServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HelloWorldServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloWorldServiceFileDescriptorSupplier())
              .addMethod(getPrintHelloWorldMethod())
              .build();
        }
      }
    }
    return result;
  }
}
