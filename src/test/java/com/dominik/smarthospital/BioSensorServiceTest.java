package com.dominik.smarthospital;

import com.dominik.smarthospital.BioSensorService.BioSensorServiceGrpc;
import com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass;
import com.dominik.smarthospital.DoctorService.DoctorServiceGrpc;
import com.dominik.smarthospital.DoctorService.DoctorServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BioSensorServiceTest {

    public static final int PORT = 50051;
    private int status;

    @Test
    void BioSensorServiceAddTest() throws InterruptedException {

        //Given
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        BioSensorServiceGrpc.BioSensorServiceStub stub = BioSensorServiceGrpc.newStub(channel);
        StreamObserver<BioSensorServiceOuterClass.APIResponse> responseStreamObserver = new StreamObserver<BioSensorServiceOuterClass.APIResponse>() {
            @Override
            public void onNext(BioSensorServiceOuterClass.APIResponse apiResponse) {
                System.out.println("Biosensor received message: " + apiResponse.getResponseMessage() + " Status: " + apiResponse.getResponseCode());
                status = apiResponse.getResponseCode();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream is completed.");
            }
        };
        StreamObserver<BioSensorServiceOuterClass.AddBioSensorRequest> requestStreamObserver = stub.add(responseStreamObserver);

        //When
        requestStreamObserver.onNext(BioSensorServiceOuterClass.AddBioSensorRequest.newBuilder()
                .setType("pulse").setValue(150).build()
        );
        Thread.sleep(100);
        requestStreamObserver.onNext(BioSensorServiceOuterClass.AddBioSensorRequest.newBuilder()
                .setType("temperature").setValue(36.52f).build()
        );
        Thread.sleep(1000);
        requestStreamObserver.onCompleted();


        //Then
        /* Thread.sleep must be here because this is asynchronous action */
        Thread.sleep(15000);
        channel.shutdown();
        assertTrue(status != 0);
    }

    @Test
    void BioSensorServiceGetAllTest() throws InterruptedException {
        //Given
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        BioSensorServiceGrpc.BioSensorServiceBlockingStub stub = BioSensorServiceGrpc.newBlockingStub(channel);
        BioSensorServiceOuterClass.Empty empty = BioSensorServiceOuterClass.Empty.newBuilder().build();
        Iterator<BioSensorServiceOuterClass.BioSensorReturn> data = stub.getAll(empty);
        int counter = 0;

        //When
        while(data.hasNext()) {
            BioSensorServiceOuterClass.BioSensorReturn bioSensor = data.next();
            System.out.println("Received message: " + bioSensor.toString());
            counter++;
        }
        Thread.sleep(15000);
        channel.shutdown();

        //Then
        assertTrue(counter > 0);
    }
}