package sungroup.tms.grpc.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import sungroup.tms.grpc.overtime.workingtime.*;

import java.util.List;

@GrpcService
public class HelloService extends OvertimeServiceGrpc.OvertimeServiceImplBase {

    @Override
    public void getEmployeeOvertimeInfoPerDay(OvertimeDeclareDateRequest request,
                                              StreamObserver<EmployeeOvertimeInfoPerDayResult> observer) {

        EmployeeOvertimeInfoPerDayResult response = EmployeeOvertimeInfoPerDayResult
                .newBuilder()
                .addAllEmployeeOvertimeInfos(
                        List.of(EmployeeOvertimeInfo.newBuilder().setEmployeeCode("emp-server-2").build())
                )
                .build();
        observer.onNext(response);
        observer.onCompleted(); //mark process is completed
    }

    @Override
    public void updateActualRequestOvertimePerDay(EmployeeActualTimesRequest request,
                                                  StreamObserver<UpdateActualWorkingTimeResult> observer) {

        UpdateActualWorkingTimeResult response = UpdateActualWorkingTimeResult
                .newBuilder()
                .setMessage("example message from server 2")
                .build();
        observer.onNext(response);
        observer.onCompleted(); //mark process is completed
    }

}
