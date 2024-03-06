package org.example;

import org.example.dto.PlaceDetails;
import org.example.model.Result;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Service {

    private List<PlaceDetails> placeDetailsList = new ArrayList<>();

    public void getPlaceDetails(List<Result> results) {

        results.forEach(result -> placeDetailsList.add(new PlaceDetails(
                result.getName(),
                result.getVicinity(),
                result.getRating(),
                result.getUserRatingsTotal(),
                getPlaceLink(result))));

        placeDetailsList.stream().sorted(Comparator.comparing(PlaceDetails::userTotalRatings).reversed()).forEach(System.out::println);

    }

    private String getPlaceLink(Result result) {


        String subLink = replacePolishChars(result.getName() + result.getVicinity());

        String link = "https://www.google.com/search?q=" + subLink;

        return link.replace('\"',' ').replace(' ', '+');

    }

    private String replacePolishChars(String subLink) {

        char[] polishChars = {'Ą', 'ą', 'Ć', 'ć', 'Ę', 'ę', 'Ł', 'ł', 'Ń', 'ń', 'Ó', 'ó', 'Ś', 'ś', 'Ź', 'ź', 'Ż', 'ż'};
        char[] englishChars = {'A', 'a', 'C', 'c', 'E', 'e', 'L', 'l', 'N', 'n', 'O', 'o', 'S', 's', 'Z', 'z', 'Z', 'z'};

        char[] linkChars = subLink.toCharArray();

        for (int i = 0; i < linkChars.length; i++) {
            for (int j = 0; j < polishChars.length; j++) {
                if (linkChars[i] == polishChars[j]) {
                    linkChars[i] = englishChars[j];
                }
            }
        }
        return String.valueOf(linkChars);

    }
}
