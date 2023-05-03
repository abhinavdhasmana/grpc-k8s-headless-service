package org.adhasmana.grpck8sheadlessservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcK8sHeadlessServiceApplication {
    private static void startServer(String name, int port) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(port)
                .addService(new HelloService())
                .build();

        server.start();
        System.out.println(name + " server started, listening on port: " + server.getPort());
        server.awaitTermination();
    }

    public static void main(String[] args) {
        SpringApplication.run(GrpcK8sHeadlessServiceApplication.class, args);
        try {
            startServer("testGrpcServer", 8090);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

}
