package ClientGUI;

import com.doctorService.DoctorServiceGrpc;
import com.doctorService.DoctorServiceGrpc.DoctorServiceBlockingStub;
import com.doctorService.DoctorServiceOuterClass.APIResponse;
import com.doctorService.DoctorServiceOuterClass.LoginRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGUI {
	// Doctor service
	public static String NAME = "localhost";
	public static Integer PORT = 50001;
	
		
	
	public static void main(String[] args) throws Exception {
		
	ManagedChannel channel = ManagedChannelBuilder.forAddress(NAME, PORT).usePlaintext().build();
	DoctorServiceBlockingStub doctorServiceBlockingStub = DoctorServiceGrpc.newBlockingStub(channel);
	
	LoginRequest loginRequest = LoginRequest.newBuilder().setUserName("Admin").setPassword("Admin").build();
	APIResponse response = doctorServiceBlockingStub.login(loginRequest);
	
	System.out.println(response.getResponseMessage());
	
	channel.shutdown();
	}

}
