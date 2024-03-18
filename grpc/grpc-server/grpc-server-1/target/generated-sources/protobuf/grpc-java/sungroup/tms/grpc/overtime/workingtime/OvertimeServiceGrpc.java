package sungroup.tms.grpc.overtime.workingtime;

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
 * <pre>
 *Services
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: overtime-service.proto")
public final class OvertimeServiceGrpc {

  private OvertimeServiceGrpc() {}

  public static final String SERVICE_NAME = "sungroup.tms.grpc.overtime.workingtime.OvertimeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest,
      sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult> getGetEmployeeOvertimeInfoPerDayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEmployeeOvertimeInfoPerDay",
      requestType = sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest.class,
      responseType = sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest,
      sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult> getGetEmployeeOvertimeInfoPerDayMethod() {
    io.grpc.MethodDescriptor<sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult> getGetEmployeeOvertimeInfoPerDayMethod;
    if ((getGetEmployeeOvertimeInfoPerDayMethod = OvertimeServiceGrpc.getGetEmployeeOvertimeInfoPerDayMethod) == null) {
      synchronized (OvertimeServiceGrpc.class) {
        if ((getGetEmployeeOvertimeInfoPerDayMethod = OvertimeServiceGrpc.getGetEmployeeOvertimeInfoPerDayMethod) == null) {
          OvertimeServiceGrpc.getGetEmployeeOvertimeInfoPerDayMethod = getGetEmployeeOvertimeInfoPerDayMethod = 
              io.grpc.MethodDescriptor.<sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sungroup.tms.grpc.overtime.workingtime.OvertimeService", "getEmployeeOvertimeInfoPerDay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.getDefaultInstance()))
                  .setSchemaDescriptor(new OvertimeServiceMethodDescriptorSupplier("getEmployeeOvertimeInfoPerDay"))
                  .build();
          }
        }
     }
     return getGetEmployeeOvertimeInfoPerDayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest,
      sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult> getUpdateActualRequestOvertimePerDayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateActualRequestOvertimePerDay",
      requestType = sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest.class,
      responseType = sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest,
      sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult> getUpdateActualRequestOvertimePerDayMethod() {
    io.grpc.MethodDescriptor<sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest, sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult> getUpdateActualRequestOvertimePerDayMethod;
    if ((getUpdateActualRequestOvertimePerDayMethod = OvertimeServiceGrpc.getUpdateActualRequestOvertimePerDayMethod) == null) {
      synchronized (OvertimeServiceGrpc.class) {
        if ((getUpdateActualRequestOvertimePerDayMethod = OvertimeServiceGrpc.getUpdateActualRequestOvertimePerDayMethod) == null) {
          OvertimeServiceGrpc.getUpdateActualRequestOvertimePerDayMethod = getUpdateActualRequestOvertimePerDayMethod = 
              io.grpc.MethodDescriptor.<sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest, sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sungroup.tms.grpc.overtime.workingtime.OvertimeService", "updateActualRequestOvertimePerDay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult.getDefaultInstance()))
                  .setSchemaDescriptor(new OvertimeServiceMethodDescriptorSupplier("updateActualRequestOvertimePerDay"))
                  .build();
          }
        }
     }
     return getUpdateActualRequestOvertimePerDayMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OvertimeServiceStub newStub(io.grpc.Channel channel) {
    return new OvertimeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OvertimeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OvertimeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OvertimeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OvertimeServiceFutureStub(channel);
  }

  /**
   * <pre>
   *Services
   * </pre>
   */
  public static abstract class OvertimeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getEmployeeOvertimeInfoPerDay(sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest request,
        io.grpc.stub.StreamObserver<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEmployeeOvertimeInfoPerDayMethod(), responseObserver);
    }

    /**
     */
    public void updateActualRequestOvertimePerDay(sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest request,
        io.grpc.stub.StreamObserver<sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateActualRequestOvertimePerDayMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetEmployeeOvertimeInfoPerDayMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest,
                sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult>(
                  this, METHODID_GET_EMPLOYEE_OVERTIME_INFO_PER_DAY)))
          .addMethod(
            getUpdateActualRequestOvertimePerDayMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest,
                sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult>(
                  this, METHODID_UPDATE_ACTUAL_REQUEST_OVERTIME_PER_DAY)))
          .build();
    }
  }

  /**
   * <pre>
   *Services
   * </pre>
   */
  public static final class OvertimeServiceStub extends io.grpc.stub.AbstractStub<OvertimeServiceStub> {
    private OvertimeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OvertimeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvertimeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OvertimeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getEmployeeOvertimeInfoPerDay(sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest request,
        io.grpc.stub.StreamObserver<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEmployeeOvertimeInfoPerDayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateActualRequestOvertimePerDay(sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest request,
        io.grpc.stub.StreamObserver<sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateActualRequestOvertimePerDayMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Services
   * </pre>
   */
  public static final class OvertimeServiceBlockingStub extends io.grpc.stub.AbstractStub<OvertimeServiceBlockingStub> {
    private OvertimeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OvertimeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvertimeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OvertimeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult getEmployeeOvertimeInfoPerDay(sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEmployeeOvertimeInfoPerDayMethod(), getCallOptions(), request);
    }

    /**
     */
    public sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult updateActualRequestOvertimePerDay(sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateActualRequestOvertimePerDayMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Services
   * </pre>
   */
  public static final class OvertimeServiceFutureStub extends io.grpc.stub.AbstractStub<OvertimeServiceFutureStub> {
    private OvertimeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OvertimeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvertimeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OvertimeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult> getEmployeeOvertimeInfoPerDay(
        sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEmployeeOvertimeInfoPerDayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult> updateActualRequestOvertimePerDay(
        sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateActualRequestOvertimePerDayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EMPLOYEE_OVERTIME_INFO_PER_DAY = 0;
  private static final int METHODID_UPDATE_ACTUAL_REQUEST_OVERTIME_PER_DAY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OvertimeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OvertimeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EMPLOYEE_OVERTIME_INFO_PER_DAY:
          serviceImpl.getEmployeeOvertimeInfoPerDay((sungroup.tms.grpc.overtime.workingtime.OvertimeDeclareDateRequest) request,
              (io.grpc.stub.StreamObserver<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult>) responseObserver);
          break;
        case METHODID_UPDATE_ACTUAL_REQUEST_OVERTIME_PER_DAY:
          serviceImpl.updateActualRequestOvertimePerDay((sungroup.tms.grpc.overtime.workingtime.EmployeeActualTimesRequest) request,
              (io.grpc.stub.StreamObserver<sungroup.tms.grpc.overtime.workingtime.UpdateActualWorkingTimeResult>) responseObserver);
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

  private static abstract class OvertimeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OvertimeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sungroup.tms.grpc.overtime.workingtime.OvertimeServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OvertimeService");
    }
  }

  private static final class OvertimeServiceFileDescriptorSupplier
      extends OvertimeServiceBaseDescriptorSupplier {
    OvertimeServiceFileDescriptorSupplier() {}
  }

  private static final class OvertimeServiceMethodDescriptorSupplier
      extends OvertimeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OvertimeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OvertimeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OvertimeServiceFileDescriptorSupplier())
              .addMethod(getGetEmployeeOvertimeInfoPerDayMethod())
              .addMethod(getUpdateActualRequestOvertimePerDayMethod())
              .build();
        }
      }
    }
    return result;
  }
}
