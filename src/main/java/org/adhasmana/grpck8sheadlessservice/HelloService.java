package org.adhasmana.grpck8sheadlessservice;

public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, io.grpc.stub.StreamObserver<org.adhasmana.grpck8sheadlessservice.HelloResponse> responseObserver) {
        HelloResponse response =  HelloResponse.newBuilder().
                setGreeting(System.getenv("POD_NAME")).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
