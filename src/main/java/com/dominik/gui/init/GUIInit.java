package com.dominik.gui.init;

import com.dominik.gui.model.User;
import com.dominik.smarthospital.DoctorService.DoctorServiceGrpc;
import com.dominik.smarthospital.DoctorService.DoctorServiceOuterClass;
import com.dominik.smarthospital.PatientService.PatientServiceGrpc;
import com.dominik.smarthospital.PatientService.PatientServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;



public class GUIInit {

    private final User user = new User();
    private JFrame frame;
    private JPanel status = new JPanel();

    public GUIInit() {
        frame = new JFrame("Smart Hospital Application");
        frame.setSize(512, 202);
        if (!user.isLoggedIn())
            createLoginForm();
        else
            createUserBox();

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void GUIRefresh() {
        if (frame == null)
            return;

        frame.setVisible(false);
        frame.removeAll();
        frame = new JFrame("Smart Hospital Application");
        if (!user.isLoggedIn()) {
            frame.setSize(512, 202);
            createLoginForm();
        } else {
            createUserBox();
            try {
                createPatientDataTable();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.setSize(1100, 600);
        }
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createUserBox() {
        createTitle("Logged as " + user.getUsername(), 1100, 0);

        JPanel panel = new JPanel();
        panel.setBounds(0, 40, 1100, 32);
        panel.setBackground(Color.gray);

        JButton button = new JButton();
        button.setText("Logout");
        button.addActionListener(e -> {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", 50050)
                    .usePlaintext()
                    .build();
            DoctorServiceGrpc.DoctorServiceBlockingStub stub = DoctorServiceGrpc.newBlockingStub(channel);
            DoctorServiceOuterClass.LogoutRequest req = DoctorServiceOuterClass.LogoutRequest.newBuilder().build();
            DoctorServiceOuterClass.APIResponse response = stub.logout(req);
            channel.shutdown();
            if (response.getResponseCode() == 1) {
                user.setUsername(null);
                GUIRefresh();
            }
        });

        button.setBounds(0, 0, 64, 32);
        panel.add(button);
        frame.add(panel);
    }

    private void createPatientDataTable() throws InterruptedException {
        String[] column = {"firstname", "lastname", "age", "pulse", "alive"};
        String[][] data = new String[1][5];
        createTitle("Patient Data", 1100, 72);
        JPanel panel = new JPanel();
        panel.setBounds(0, 200, 1100, 350);
        panel.setBackground(Color.gray);
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        PatientServiceGrpc.PatientServiceStub stub = PatientServiceGrpc.newStub(channel);

        StreamObserver<PatientServiceOuterClass.DataResponse> responseStreamObserver = new StreamObserver<PatientServiceOuterClass.DataResponse>() {
            @Override
            public void onNext(PatientServiceOuterClass.DataResponse dataResponse) {
                for (int a = 0; a < column.length; ++a) {
                    if (column[a].equals(dataResponse.getType())) {
                        //data.add(a, dataResponse.getValue());
                        data[0][a] = dataResponse.getValue();
                    }
                }
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
        StreamObserver<PatientServiceOuterClass.DataRequest> requestStreamObserver = stub.getPatientData(responseStreamObserver);


        for (String col : column) {
            requestStreamObserver.onNext(PatientServiceOuterClass.DataRequest.newBuilder()
                    .setType(col).build()
            );
        }
        requestStreamObserver.onCompleted();
        Thread.sleep(15000);
        channel.shutdown();
        JTable table = new JTable(data, column);
        JTableHeader header = table.getTableHeader();
        table.setBounds(0,32,1100,60);
        panel.setLayout(new BorderLayout());
        panel.add(header, BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        frame.add(panel);
    }

    private void createLoginForm() {
        createTitle("Login form");

        //Username ROW
        JPanel panelLogin = new JPanel();
        panelLogin.setBounds(0, 33, 512, 32);
        panelLogin.setBackground(Color.gray);

        JLabel loginLabel = new JLabel();
        loginLabel.setText("Username: ");
        loginLabel.setBounds(0, 60, 64, 32);

        panelLogin.add(loginLabel);

        JTextField loginInput = new JTextField();
        loginInput.setBounds(64, 61, 255, 30);
        loginInput.setSize(255, 30);
        loginInput.setPreferredSize(new Dimension(255, 30));
        panelLogin.add(loginInput);
        //Password ROW
        JPanel panelPassword = new JPanel();
        panelPassword.setBounds(0, 65, 512, 32);
        panelPassword.setBackground(Color.gray);

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        passwordLabel.setBounds(0, 60, 64, 32);

        panelPassword.add(passwordLabel);

        JPasswordField passwordInput = new JPasswordField();
        passwordInput.setBounds(64, 61, 255, 30);
        passwordInput.setSize(255, 30);
        passwordInput.setPreferredSize(new Dimension(255, 30));
        panelPassword.add(passwordInput);

        //Send BUTTON ROW
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 97, 512, 35);
        buttonPanel.setBackground(Color.gray);

        JButton okButton = new JButton();
        okButton.setText("Send");
        okButton.setSize(new Dimension(64, 30));
        okButton.setPreferredSize(new Dimension(64, 30));
        okButton.setBounds(0, 0, 64, 30);
        okButton.addActionListener(e -> {
            String username = loginInput.getText();
            String password = new String(passwordInput.getPassword()); // password.toString() -> "[t,e,s,t]" //expected "test"
            DoctorServiceOuterClass.APIResponse response = formSubmitData(username, password);

            if (response.getResponseCode() == 1) {
                user.setUsername(username);
                GUIRefresh();
            } else {
                JLabel statusText = new JLabel();
                statusText.setText("Bad username or password.");
                statusText.setBounds(0, 0, 512, 32);
                statusText.setVerticalAlignment(SwingConstants.CENTER);
                statusText.setHorizontalAlignment(SwingConstants.CENTER);
                status.removeAll();
                status.add(statusText);
                frame.setVisible(true);
            }


        });

        buttonPanel.add(okButton);

        status.setBounds(0, 132, 512, 35);
        status.setBackground(Color.gray);

        frame.add(status);

        frame.add(panelLogin);
        frame.add(panelPassword);
        frame.add(buttonPanel);

    }

    private DoctorServiceOuterClass.APIResponse formSubmitData(String username, String password) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50050)
                .usePlaintext()
                .build();
        DoctorServiceGrpc.DoctorServiceBlockingStub stub = DoctorServiceGrpc.newBlockingStub(channel);
        DoctorServiceOuterClass.LoginRequest req = DoctorServiceOuterClass.LoginRequest.newBuilder()
                .setPassword(password).setUserName(username).build();
        DoctorServiceOuterClass.APIResponse response = stub.login(req);
        channel.shutdown();
        return response;
    }

    private void createTitle(String title) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 512, 40);
        panel.setBackground(Color.gray);

        JLabel registerTitle = new JLabel();
        registerTitle.setText(title);
        registerTitle.setFont(new Font("System", Font.BOLD, 25));
        registerTitle.setBounds(0, 0, 512, 30);
        registerTitle.setVerticalAlignment(SwingConstants.CENTER);
        registerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(registerTitle);
        frame.add(panel);
    }

    private void createTitle(String title, int width, int y) {
        JPanel panel = new JPanel();
        panel.setBounds(0, y, width, 40);
        panel.setBackground(Color.gray);

        JLabel titleLabel = new JLabel();
        titleLabel.setText(title);
        titleLabel.setFont(new Font("System", Font.BOLD, 25));
        titleLabel.setBounds(0, 0, 512, 30);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);
        frame.add(panel);
    }
}
