
# grpc-k8s-headless-service

To create a jar file for the server, run `bootJar` gradle command in the gradle

To create a jar file for the client, run `customFarJar` gradle command.

`DockerFile-Server` and `Dockerfile-Client` creates the docker image for the server and client respectively.

`clusterip.yaml` creates a service of type clusterIP along with gRPC client and server pods

`headless.yaml` creates a headless service along with gRPC client and server pods

`istio-auto.yaml` creates clusterIP service along with client and server pods where istio-proxy runs as a side car
