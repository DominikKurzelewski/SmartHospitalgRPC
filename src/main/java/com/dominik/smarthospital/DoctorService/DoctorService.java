package com.dominik.smarthospital.DoctorService;

import io.grpc.stub.StreamObserver;

public class DoctorService extends DoctorServiceGrpc.DoctorServiceImplBase {

    @Override
    public void login(DoctorServiceOuterClass.LoginRequest request, StreamObserver<DoctorServiceOuterClass.APIResponse> responseObserver) {
        String username = request.getUserName();
        String password = request.getPassword();

        DoctorServiceOuterClass.APIResponse.Builder response = DoctorServiceOuterClass.APIResponse.newBuilder();

        if (username.equals("Admin") && password.equals("123456")) {
            response.setResponseCode(1).setResponseMessage("Login ok.");
        } else {
            response.setResponseCode(0).setResponseMessage("Login failed.");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(DoctorServiceOuterClass.LogoutRequest request, StreamObserver<DoctorServiceOuterClass.APIResponse> responseObserver) {
        DoctorServiceOuterClass.APIResponse.Builder response = DoctorServiceOuterClass.APIResponse.newBuilder();
        response.setResponseCode(1).setResponseMessage("Logout ok.");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
