package io.javabrains.reactiveworkshop;

import java.io.IOException;

import reactor.core.publisher.Flux;

public class Exercise8 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error
        // happens
        ReactiveSources.intNumbersFluxWithException()
                .doOnError(e -> System.out.println("Error: " + e.getMessage())) // -this method creates a new flux. When
                                                                                // - an error occurs, it performs the
                                                                                // - specified action on the error and
                                                                                // - also passes it to the flux
                .subscribe(num -> System.out.println(num)/** ,err->System.out.println("Error ocurred!") */
                );

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((e, item) -> System.out.println("error: " + e.getMessage() + ", item: " + item + ""))
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2)) // -when error occurs, use this flux instead
                .subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
