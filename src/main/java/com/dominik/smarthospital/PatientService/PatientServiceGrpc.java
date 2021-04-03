package com.dominik.smarthospital.PatientService;

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
    comments = "Source: PatientService.proto")
public final class PatientServiceGrpc {

  private PatientServiceGrpc() {}

  public static final String SERVICE_NAME = "PatientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest,
      com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse> getGetPatientDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPatientData",
      requestType = com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest.class,
      responseType = com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest,
      com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse> getGetPatientDataMethod() {
    io.grpc.MethodDescriptor<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest, com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse> getGetPatientDataMethod;
    if ((getGetPatientDataMethod = PatientServiceGrpc.getGetPatientDataMethod) == null) {
      synchronized (PatientServiceGrpc.class) {
        if ((getGetPatientDataMethod = PatientServiceGrpc.getGetPatientDataMethod) == null) {
          PatientServiceGrpc.getGetPatientDataMethod = getGetPatientDataMethod = 
              io.grpc.MethodDescriptor.<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest, com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PatientService", "getPatientData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientServiceMethodDescriptorSupplier("getPatientData"))
                  .build();
          }
        }
     }
     return getGetPatientDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientServiceStub newStub(io.grpc.Channel channel) {
    return new PatientServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PatientServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest> getPatientData(
        io.grpc.stub.StreamObserver<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetPatientDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPatientDataMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest,
                com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse>(
                  this, METHODID_GET_PATIENT_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class PatientServiceStub extends io.grpc.stub.AbstractStub<PatientServiceStub> {
    private PatientServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataRequest> getPatientData(
        io.grpc.stub.StreamObserver<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetPatientDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PatientServiceBlockingStub extends io.grpc.stub.AbstractStub<PatientServiceBlockingStub> {
    private PatientServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class PatientServiceFutureStub extends io.grpc.stub.AbstractStub<PatientServiceFutureStub> {
    private PatientServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_PATIENT_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PatientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_GET_PATIENT_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getPatientData(
              (io.grpc.stub.StreamObserver<com.dominik.smarthospital.PatientService.PatientServiceOuterClass.DataResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PatientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dominik.smarthospital.PatientService.PatientServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientService");
    }
  }

  private static final class PatientServiceFileDescriptorSupplier
      extends PatientServiceBaseDescriptorSupplier {
    PatientServiceFileDescriptorSupplier() {}
  }

  private static final class PatientServiceMethodDescriptorSupplier
      extends PatientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PatientServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PatientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientServiceFileDescriptorSupplier())
              .addMethod(getGetPatientDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
