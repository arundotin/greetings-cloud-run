package com.arun.greetings;

import com.arun.greetings.api.GreetingResponse;
import com.arun.greetings.api.GreetingsResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/api/v1/greetings")
public class GreetingController {

    private GreetingService greetingService;

    @Inject
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Get
    public GreetingsResponse greetings() {
        var greetings = greetingService.getAllGreetings();

        return GreetingsResponse.builder()
                .greetings(greetings)
                .build();
    }

    @Get("/{language}")
    public HttpResponse<GreetingResponse> greeting(String language) {
        var greeting =
                greetingService.getGreetingByLanguage(language);


        if (!greeting.isPresent()) {
            return HttpResponse.notFound();
        }

        var response = GreetingResponse.builder()
                .greeting(greeting.get())
                .build();

        return HttpResponse.ok(response);
    }


}