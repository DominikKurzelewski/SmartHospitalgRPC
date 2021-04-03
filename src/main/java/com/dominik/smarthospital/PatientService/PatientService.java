package com.dominik.smarthospital.PatientService;

import io.grpc.stub.StreamObserver;

public class PatientService extends PatientServiceGrpc.PatientServiceImplBase {
    @Override
    public StreamObserver<PatientServiceOuterClass.DataRequest> getPatientData(StreamObserver<PatientServiceOuterClass.DataResponse> responseObserver) {
        return new StreamObserver<PatientServiceOuterClass.DataRequest>() {
            @Override
            public void onNext(PatientServiceOuterClass.DataRequest dataRequest) {
                PatientServiceOuterClass.DataResponse.Builder response = PatientServiceOuterClass.DataResponse.newBuilder();
                String dataType = dataRequest.getType();

                switch (dataType) {
                    case "firstname":
                        response.setType("firstname").setValue("John");
                        break;
                    case "lastname":
                        response.setType("lastname").setValue("Stark");
                        break;
                    case "age":
                        response.setType("age").setValue(String.valueOf(25));
                        break;
                    case "pulse":
                        response.setType("pulse").setValue(String.valueOf(150));
                        break;
                    case "alive":
                        response.setType("alive").setValue(String.valueOf(false));
                        break;
                }
                responseObserver.onNext(response.build());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Connection getPatientData completed.");
                responseObserver.onCompleted();
            }
        };
    }
}
