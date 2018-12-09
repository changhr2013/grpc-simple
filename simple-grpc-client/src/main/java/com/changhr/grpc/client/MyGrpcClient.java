package com.changhr.grpc.client;

import com.changhr.grpc.HelloRequest;
import com.changhr.grpc.HelloResponse;
import com.changhr.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8082)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse helloResponse = stub.hello(
                HelloRequest.newBuilder()
                        .setName("forezp")
                        .setAge(17)
                        .addHobbies("football").putTags("how?", "wonderful")
                        .build());
        System.out.println(helloResponse);
        channel.shutdown();
    }
}
