package com.arun.greetings.api;

import com.arun.greetings.api.GreetingApi;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Introspected
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GreetingsResponse {
    List<GreetingApi> greetings;
}
