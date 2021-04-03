package com.dominik.smarthospital.services;

import com.dominik.smarthospital.BioSensorService.BioSensorService;
import com.dominik.smarthospital.DoctorService.DoctorService;
import com.dominik.smarthospital.PatientService.PatientService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Core {

    public Core() throws InterruptedException {
        startBioSensorScheduler();
        startDoctorScheduler();
        startPatientScheduler();
        while(!Thread.currentThread().isInterrupted())
        {
            System.out.println("Smart Hospital Server is running. Awaiting for clients.");
            Thread.sleep(1000);
        }
    }

    private void startDoctorScheduler() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            DoctorService doctorService = new DoctorService();
            try {
                Server server = ServerBuilder.forPort(50050)
                        .addService(doctorService)
                        .build()
                        .start();
                System.out.println("DoctorService started. PORT 50050");
                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        };
        executorService.schedule(task, 1, TimeUnit.SECONDS);
    }

    private void startBioSensorScheduler() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            BioSensorService bioSensorService = new BioSensorService();
            try {
                Server server = ServerBuilder.forPort(50051)
                        .addService(bioSensorService)
                        .build()
                        .start();
                System.out.println("BioSensorService started. PORT 50051");
                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        };
        executorService.schedule(task, 1, TimeUnit.SECONDS);
    }

    private void startPatientScheduler() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            PatientService patientService = new PatientService();
            try {
                Server server = ServerBuilder.forPort(50052)
                        .addService(patientService)
                        .build()
                        .start();
                System.out.println("PatientService started. PORT 50052");
                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        };
        executorService.schedule(task, 1, TimeUnit.SECONDS);
    }
}
