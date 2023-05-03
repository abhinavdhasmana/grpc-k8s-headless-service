package org.adhasmana.grpck8sheadlessservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.HashMap;
import java.util.Map;

public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("my-grpc-service", 8090)
                .usePlaintext()
                .defaultLoadBalancingPolicy("round_robin")
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        for (int i = 0; i < 10000; i++) {

            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < 50; j++) {
                HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder().setFirstName("test").setLastName("abhinav").build());
                String response = helloResponse.getGreeting();
                map.put(response, map.getOrDefault(response,0) + 1);
                Thread.sleep(100);
            }
            for (String key: map.keySet()) {
                System.out.println("Number of calls to pod with name:" + key + " are:" + map.get(key));
            }
            System.out.println("***************");
        }

        channel.shutdown();
    }
}
