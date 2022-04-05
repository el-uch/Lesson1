package server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args){
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:4446/"))
                .header("Type", "Hello")
                .build();

        HttpResponse<String> response=null;
        try {
            response=client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(response.body());
    }
}
