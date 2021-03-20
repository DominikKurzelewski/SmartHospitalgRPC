package com.doctorService;

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
    comments = "Source: DoctorService.proto")
public final class DoctorServiceGrpc {

  private DoctorServiceGrpc() {}

  public static final String SERVICE_NAME = "DoctorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.doctorService.DoctorServiceOuterClass.LoginRequest,
      com.doctorService.DoctorServiceOuterClass.APIResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.doctorService.DoctorServiceOuterClass.LoginRequest.class,
      responseType = com.doctorService.DoctorServiceOuterClass.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.doctorService.DoctorServiceOuterClass.LoginRequest,
      com.doctorService.DoctorServiceOuterClass.APIResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.doctorService.DoctorServiceOuterClass.LoginRequest, com.doctorService.DoctorServiceOuterClass.APIResponse> getLoginMethod;
    if ((getLoginMethod = DoctorServiceGrpc.getLoginMethod) == null) {
      synchronized (DoctorServiceGrpc.class) {
        if ((getLoginMethod = DoctorServiceGrpc.getLoginMethod) == null) {
          DoctorServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.doctorService.DoctorServiceOuterClass.LoginRequest, com.doctorService.DoctorServiceOuterClass.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DoctorService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.doctorService.DoctorServiceOuterClass.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.doctorService.DoctorServiceOuterClass.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DoctorServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.doctorService.DoctorServiceOuterClass.Empty,
      com.doctorService.DoctorServiceOuterClass.APIResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = com.doctorService.DoctorServiceOuterClass.Empty.class,
      responseType = com.doctorService.DoctorServiceOuterClass.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.doctorService.DoctorServiceOuterClass.Empty,
      com.doctorService.DoctorServiceOuterClass.APIResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<com.doctorService.DoctorServiceOuterClass.Empty, com.doctorService.DoctorServiceOuterClass.APIResponse> getLogoutMethod;
    if ((getLogoutMethod = DoctorServiceGrpc.getLogoutMethod) == null) {
      synchronized (DoctorServiceGrpc.class) {
        if ((getLogoutMethod = DoctorServiceGrpc.getLogoutMethod) == null) {
          DoctorServiceGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<com.doctorService.DoctorServiceOuterClass.Empty, com.doctorService.DoctorServiceOuterClass.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DoctorService", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.doctorService.DoctorServiceOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.doctorService.DoctorServiceOuterClass.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DoctorServiceMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DoctorServiceStub newStub(io.grpc.Channel channel) {
    return new DoctorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DoctorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DoctorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DoctorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DoctorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DoctorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(com.doctorService.DoctorServiceOuterClass.LoginRequest request,
        io.grpc.stub.StreamObserver<com.doctorService.DoctorServiceOuterClass.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(com.doctorService.DoctorServiceOuterClass.Empty request,
        io.grpc.stub.StreamObserver<com.doctorService.DoctorServiceOuterClass.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.doctorService.DoctorServiceOuterClass.LoginRequest,
                com.doctorService.DoctorServiceOuterClass.APIResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.doctorService.DoctorServiceOuterClass.Empty,
                com.doctorService.DoctorServiceOuterClass.APIResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   */
  public static final class DoctorServiceStub extends io.grpc.stub.AbstractStub<DoctorServiceStub> {
    private DoctorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(com.doctorService.DoctorServiceOuterClass.LoginRequest request,
        io.grpc.stub.StreamObserver<com.doctorService.DoctorServiceOuterClass.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(com.doctorService.DoctorServiceOuterClass.Empty request,
        io.grpc.stub.StreamObserver<com.doctorService.DoctorServiceOuterClass.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DoctorServiceBlockingStub extends io.grpc.stub.AbstractStub<DoctorServiceBlockingStub> {
    private DoctorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.doctorService.DoctorServiceOuterClass.APIResponse login(com.doctorService.DoctorServiceOuterClass.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.doctorService.DoctorServiceOuterClass.APIResponse logout(com.doctorService.DoctorServiceOuterClass.Empty request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DoctorServiceFutureStub extends io.grpc.stub.AbstractStub<DoctorServiceFutureStub> {
    private DoctorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoctorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoctorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoctorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.doctorService.DoctorServiceOuterClass.APIResponse> login(
        com.doctorService.DoctorServiceOuterClass.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.doctorService.DoctorServiceOuterClass.APIResponse> logout(
        com.doctorService.DoctorServiceOuterClass.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DoctorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DoctorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.doctorService.DoctorServiceOuterClass.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.doctorService.DoctorServiceOuterClass.APIResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((com.doctorService.DoctorServiceOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<com.doctorService.DoctorServiceOuterClass.APIResponse>) responseObserver);
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

  private static abstract class DoctorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DoctorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.doctorService.DoctorServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DoctorService");
    }
  }

  private static final class DoctorServiceFileDescriptorSupplier
      extends DoctorServiceBaseDescriptorSupplier {
    DoctorServiceFileDescriptorSupplier() {}
  }

  private static final class DoctorServiceMethodDescriptorSupplier
      extends DoctorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DoctorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DoctorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DoctorServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
