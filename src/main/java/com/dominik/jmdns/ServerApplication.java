package com.dominik.jmdns;

import com.dominik.smarthospital.BioSensorService.BioSensorServiceGrpc;
import com.dominik.smarthospital.BioSensorService.BioSensorServiceOuterClass;
import com.dominik.smarthospital.model.BioSensor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;

public class ServerApplication {
    public static final int PORT = 50051;
    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        int port = 9090;
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        // Register a service
        ServiceInfo serviceInfo = ServiceInfo.create("_date._tcp.local.", "Get All", port, "Date Server will give you biosensor data from Smart Hospital via gRPC");
        jmdns.registerService(serviceInfo);
        System.out.println("Starting the Date Server loop");


        ServerSocket listener = new ServerSocket(9090);
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        BioSensorServiceGrpc.BioSensorServiceBlockingStub stub = BioSensorServiceGrpc.newBlockingStub(channel);
        BioSensorServiceOuterClass.Empty empty = BioSensorServiceOuterClass.Empty.newBuilder().build();
        Iterator<BioSensorServiceOuterClass.BioSensorReturn> data;
        PrintWriter out;
        BioSensorServiceOuterClass.BioSensorReturn bioSensor;
        BioSensor tmpBioSensor;
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    data = stub.getAll(empty);
                    out = new PrintWriter(socket.getOutputStream(), true);
                    while(data.hasNext()) {
                        bioSensor = data.next();
                        tmpBioSensor = new BioSensor();
                        tmpBioSensor.setType(bioSensor.getType());
                        tmpBioSensor.setValue(bioSensor.getValue());
                        out.println(tmpBioSensor.toString());
                    }
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }

    }
}
