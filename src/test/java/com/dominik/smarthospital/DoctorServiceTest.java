package com.dominik.smarthospital;

import com.dominik.smarthospital.DoctorService.DoctorServiceGrpc;
import com.dominik.smarthospital.DoctorService.DoctorServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {

    public static final int PORT = 50050;

    //Unary login test
    @Test
    void DoctorServiceLoginFailTest() throws InterruptedException {
        //Given
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        DoctorServiceGrpc.DoctorServiceBlockingStub stub = DoctorServiceGrpc.newBlockingStub(channel);
        DoctorServiceOuterClass.LoginRequest req = DoctorServiceOuterClass.LoginRequest.newBuilder()
                .setPassword("123").setUserName("admin").build();

        //When
        DoctorServiceOuterClass.APIResponse response = stub.login(req);

        //Then
        Thread.sleep(15000);
        channel.shutdown();
        assertEquals(0, response.getResponseCode(), "Should be 0, because of bad data.");
    }

    @Test
    void DoctorServiceLoginGoodTest() throws InterruptedException {
        //Given
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        DoctorServiceGrpc.DoctorServiceBlockingStub stub = DoctorServiceGrpc.newBlockingStub(channel);
        DoctorServiceOuterClass.LoginRequest req = DoctorServiceOuterClass.LoginRequest.newBuilder()
                .setPassword("123456").setUserName("Admin").build();

        //When
        DoctorServiceOuterClass.APIResponse response = stub.login(req);


        //Then
        Thread.sleep(15000);
        channel.shutdown();
        assertEquals(1, response.getResponseCode(), "Should be 1 because of good data passed.");
    }

    @Test
    void DoctorServiceLogoutTest() throws InterruptedException {
        //Given
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        DoctorServiceGrpc.DoctorServiceBlockingStub stub = DoctorServiceGrpc.newBlockingStub(channel);
        DoctorServiceOuterClass.LogoutRequest req = DoctorServiceOuterClass.LogoutRequest.newBuilder().build();

        //When
        DoctorServiceOuterClass.APIResponse response = stub.logout(req);

        //Then
        Thread.sleep(15000);
        channel.shutdown();
        assertEquals(1, response.getResponseCode(), "Should be 1 because everytime all will be ok.");
    }

}
