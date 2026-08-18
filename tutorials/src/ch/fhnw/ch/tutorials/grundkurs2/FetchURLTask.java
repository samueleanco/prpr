package ch.fhnw.ch.tutorials.grundkurs2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetchURLTask implements Runnable{

    private final String url;

    public FetchURLTask(String url) {
        this.url = url;
    }


    @Override
    public void run() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String bodyHead= response.body().substring(0,Math.min(10, response.body().length()));
        System.out.println("Fetched" + url + bodyHead);

        httpClient.close();



    }

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://example.com", "http://github.com");
        ExecutorService executorService = Executors.newFixedThreadPool(urls.size());
        for (String url : urls) {
            executorService.submit(new FetchURLTask(url));
        }
        executorService.shutdown();

    }
}
