package com.dominik.smarthospital.BioSensorService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: BioSensorService.proto")
public final class BioSensorServiceGrpc {

  private BioSensorServiceGrpc() {}

  public static final String SERVICE_NAME = "BioSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest,
      com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest.class,
      responseType = com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest,
      com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse> getAddMethod() {
    io.grpc.MethodDescriptor<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest, com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse> getAddMethod;
    if ((getAddMethod = BioSensorServiceGrpc.getAddMethod) == null) {
      synchronized (BioSensorServiceGrpc.class) {
        if ((getAddMethod = BioSensorServiceGrpc.getAddMethod) == null) {
          BioSensorServiceGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest, com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "BioSensorService", "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BioSensorServiceMethodDescriptorSupplier("add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty,
      com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn> getGetAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAll",
      requestType = com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty.class,
      responseType = com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty,
      com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn> getGetAllMethod() {
    io.grpc.MethodDescriptor<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty, com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn> getGetAllMethod;
    if ((getGetAllMethod = BioSensorServiceGrpc.getGetAllMethod) == null) {
      synchronized (BioSensorServiceGrpc.class) {
        if ((getGetAllMethod = BioSensorServiceGrpc.getGetAllMethod) == null) {
          BioSensorServiceGrpc.getGetAllMethod = getGetAllMethod = 
              io.grpc.MethodDescriptor.<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty, com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "BioSensorService", "getAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn.getDefaultInstance()))
                  .setSchemaDescriptor(new BioSensorServiceMethodDescriptorSupplier("getAll"))
                  .build();
          }
        }
     }
     return getGetAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BioSensorServiceStub newStub(io.grpc.Channel channel) {
    return new BioSensorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BioSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BioSensorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BioSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BioSensorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BioSensorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *client stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest> add(
        io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddMethod(), responseObserver);
    }

    /**
     * <pre>
     *server stream
     * </pre>
     */
    public void getAll(com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty request,
        io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest,
                com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getGetAllMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty,
                com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn>(
                  this, METHODID_GET_ALL)))
          .build();
    }
  }

  /**
   */
  public static final class BioSensorServiceStub extends io.grpc.stub.AbstractStub<BioSensorServiceStub> {
    private BioSensorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BioSensorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BioSensorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BioSensorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *client stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.AddBioSensorRequest> add(
        io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *server stream
     * </pre>
     */
    public void getAll(com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty request,
        io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BioSensorServiceBlockingStub extends io.grpc.stub.AbstractStub<BioSensorServiceBlockingStub> {
    private BioSensorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BioSensorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BioSensorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BioSensorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *server stream
     * </pre>
     */
    public java.util.Iterator<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn> getAll(
        com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BioSensorServiceFutureStub extends io.grpc.stub.AbstractStub<BioSensorServiceFutureStub> {
    private BioSensorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BioSensorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BioSensorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BioSensorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_ALL = 0;
  private static final int METHODID_ADD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BioSensorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BioSensorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL:
          serviceImpl.getAll((com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.BioSensorReturn>) responseObserver);
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
        case METHODID_ADD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.add(
              (io.grpc.stub.StreamObserver<com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.APIResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BioSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BioSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BioSensorService");
    }
  }

  private static final class BioSensorServiceFileDescriptorSupplier
      extends BioSensorServiceBaseDescriptorSupplier {
    BioSensorServiceFileDescriptorSupplier() {}
  }

  private static final class BioSensorServiceMethodDescriptorSupplier
      extends BioSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BioSensorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BioSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BioSensorServiceFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getGetAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
