package com.dominik.smarthospital;


import com.dominik.smarthospital.BioSensorService.BioSensorServiceGrpc;
import com.dominik.smarthospital.PatientService.PatientServiceGrpc;
import com.dominik.smarthospital.PatientService.PatientServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

class PatientServiceTest {

    public static final int PORT = 50052;
    private int counter = 0;

    @Test
    void PatientServiceGetPatientInfoTest() throws InterruptedException {
        //Given
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        PatientServiceGrpc.PatientServiceStub stub = PatientServiceGrpc.newStub(channel);
        StreamObserver<PatientServiceOuterClass.DataResponse> responseStreamObserver = new StreamObserver<PatientServiceOuterClass.DataResponse>() {
            @Override
            public void onNext(PatientServiceOuterClass.DataResponse dataResponse) {
                System.out.println("Received new data: " + dataResponse.toString());
                counter++;
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

        //when
        StreamObserver<PatientServiceOuterClass.DataRequest> requestStreamObserver = stub.getPatientData(responseStreamObserver);
        requestStreamObserver.onNext(PatientServiceOuterClass.DataRequest.newBuilder()
            .setType("firstname").build()
        );
        requestStreamObserver.onNext(PatientServiceOuterClass.DataRequest.newBuilder()
                .setType("lastname").build()
        );
        requestStreamObserver.onNext(PatientServiceOuterClass.DataRequest.newBuilder()
                .setType("age").build()
        );
        requestStreamObserver.onNext(PatientServiceOuterClass.DataRequest.newBuilder()
                .setType("pulse").build()
        );
        requestStreamObserver.onNext(PatientServiceOuterClass.DataRequest.newBuilder()
                .setType("alive").build()
        );
        requestStreamObserver.onCompleted();
        Thread.sleep(new Random().nextInt(1000) + 500);



        //then
        Thread.sleep(5000);
        channel.shutdown();
        assertTrue(counter > 0);
    }

}
