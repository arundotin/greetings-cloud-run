package com.arun.greetings;

import com.arun.greetings.api.GreetingApi;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class GreetingService {


    public List<GreetingApi> getAllGreetings() {
        return dummyGreetings();
    }

    public Optional<GreetingApi> getGreetingByLanguage(String language) {
        return dummyGreetings()
                .stream()
                .filter(greeting -> greeting.getLanguage().equalsIgnoreCase(language))
                .findFirst();
    }

    private List<GreetingApi> dummyGreetings() {
        return List.of(
                new GreetingApi("Welcome", "English"),
                new GreetingApi("Bienvenidos", "Spanish"),
                new GreetingApi("ようこそ", "Japenese"),
                new GreetingApi("வரவேற்பு", "Tamil"),
                new GreetingApi("स्वागत", "Hindi")
        );
    }


}

