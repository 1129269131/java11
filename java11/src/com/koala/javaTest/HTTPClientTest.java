package com.koala.javaTest;

import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * day06：Http客户端API
 * Create by koala on 2021-08-08
 */
public class HTTPClientTest {

    @Test
    public void testName() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.atguigu.com")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = client.send(request, responseBodyHandler);

        String body = response.body();
        System.out.println(body);
    }

    @Test
    public void testName2() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.atguigu.com")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();

        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        sendAsync.get();

        /*HttpResponse<String> response = sendAsync.get();
        String body = response.body();
        System.out.println(body);*/
    }

}
