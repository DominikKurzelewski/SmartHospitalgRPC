import com.doctorService.DoctorService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SmartMedicalEnvironmentServer {

	public static void main(String[] args) {
		
		try {
			Server doctorServer = ServerBuilder.forPort(50001).addService( new DoctorService()).build();
			
			doctorServer.start();
			
			System.out.println("Doctor server started.");		
			
			
			doctorServer.awaitTermination();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
