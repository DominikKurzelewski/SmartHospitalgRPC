package com.dominik.smarthospital.BioSensorService;

import com.dominik.smarthospital.model.BioSensor;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class BioSensorService extends BioSensorServiceGrpc.BioSensorServiceImplBase {

    List<BioSensor> lastMessage = new ArrayList<>();

    @Override
    public StreamObserver<BioSensorServiceOuterClass.AddBioSensorRequest> add(StreamObserver<BioSensorServiceOuterClass.APIResponse> responseObserver) {

        return new StreamObserver<BioSensorServiceOuterClass.AddBioSensorRequest>() {

            List<BioSensor> list = new ArrayList<>();

            @Override
            public void onNext(BioSensorServiceOuterClass.AddBioSensorRequest addBioSensorRequest) {
                BioSensor biosensor = new BioSensor();

                biosensor.setType(addBioSensorRequest.getType());
                biosensor.setValue(addBioSensorRequest.getValue());
                list.add(biosensor);

            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Received data: ");
                for (BioSensor bs : list) {
                    System.out.println(bs.toString());
                }
                lastMessage.addAll(list);
                responseObserver.onNext(BioSensorServiceOuterClass.APIResponse.newBuilder()
                        .setResponseCode(1).setResponseMessage("OK.").build());

                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void getAll(BioSensorServiceOuterClass.Empty request, StreamObserver<BioSensorServiceOuterClass.BioSensorReturn> responseObserver) {
        BioSensor bs;
        BioSensorServiceOuterClass.BioSensorReturn response;
        for (int a = 0; a < lastMessage.size(); ++a) {
            bs = lastMessage.get(a);

            response = BioSensorServiceOuterClass.BioSensorReturn.newBuilder()
                    .setType(bs.getType()).setValue(bs.getValue()).build();

            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}
