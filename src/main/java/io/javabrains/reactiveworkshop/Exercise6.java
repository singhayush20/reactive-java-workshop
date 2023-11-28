package io.javabrains.reactiveworkshop;

import java.time.Duration;
import java.io.IOException;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        String foo=ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));
        System.out.println(foo);
        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}
