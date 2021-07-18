package com.arun.greetings.api;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Introspected
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GreetingResponse {
    private GreetingApi greeting;
}
