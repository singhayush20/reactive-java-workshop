package io.javabrains.reactiveworkshop;

import java.io.IOException;

import reactor.core.publisher.Flux;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        Flux<Integer> stream=ReactiveSources.intNumbersFlux();
        stream.subscribe(e->System.out.println(e));
        stream.subscribe(e->System.out.println("another... "+e));

        
        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userMono().subscribe(e->System.out.println(e));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
