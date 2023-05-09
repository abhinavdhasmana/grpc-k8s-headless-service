
# grpc-k8s-headless-service

This code covers pitfalls when working with services that use gRPC to talk to each other in the k8s env.

It cover three scenarios:

* gRPC client and gRPC server talking to each other via ClusterIP service
* gRPC client and gRPC server talking to each other via Headless service
* gRPC client and gRPC server talking to each other with Istio proxy as a sidecar

The details can be found on my [[blog]](https://medium.com/p/1fd33561d67a) 

## How to run it locally

To create a jar file for the server, run `bootJar` gradle command in the gradle

To create a jar file for the client, run `customFarJar` gradle command.

`DockerFile-Server` and `Dockerfile-Client` creates the docker image for the server and client respectively.

`clusterip.yaml` creates a service of type clusterIP along with gRPC client and server pods

`headless.yaml` creates a headless service along with gRPC client and server pods

`istio-auto.yaml` creates clusterIP service along with client and server pods where istio-proxy runs as a side car
