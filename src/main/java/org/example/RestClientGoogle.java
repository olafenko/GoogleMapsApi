package org.example;

import com.google.gson.Gson;
import org.example.model.Place;
import org.example.model.Result;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RestClientGoogle {

    private final String API_KEY = "AIzaSyBnEycnDHNKTd1Nq0cTKAaYjuBawP8UopE";
    public void sendRequest() throws IOException, URISyntaxException, InterruptedException {

        //to set different place for nearby search, you have to change coordinates after "location="

        //dodac wybieranie obszaru,typu i filtrowania open now

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=50.052226541336964,21.604342249873344&radius=1000&type=restaurant&opennow=true&key=" + API_KEY))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> getResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        Place place = new Gson().fromJson(getResponse.body(), Place.class);

        List<Result> results = place.getResults();

        Service service = new Service();

        service.getPlaceDetails(results);

    }
}
