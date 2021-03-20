package com.doctorService;

import com.doctorService.DoctorServiceGrpc.DoctorServiceImplBase;
import com.doctorService.DoctorServiceOuterClass.APIResponse;
import com.doctorService.DoctorServiceOuterClass.Empty;
import com.doctorService.DoctorServiceOuterClass.LoginRequest;

import io.grpc.stub.StreamObserver;

public class DoctorService extends DoctorServiceImplBase{

	

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {

		System.out.println("Inside login");
		
		String username = request.getUserName();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		
		if(username.equals(password)) {
			//return success massage
			response.setResponseCode(0).setResponseMessage("Login Success");
		}
		else {
			//return failure massage
			response.setResponseCode(100).setResponseMessage("Invalid Password");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

}
