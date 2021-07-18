package com.arun.greetings.api;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingApi {
    private String message;
    private String language;
}