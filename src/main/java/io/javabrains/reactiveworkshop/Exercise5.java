package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
            number-> System.out.println("Number: "+number),
            error-> System.out.println("Error: "+error.getMessage()),
            ()-> System.out.println("Completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscribe<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

    private static class MySubscribe<T> extends BaseSubscriber<T> {

        @Override
        protected void hookOnCancel() {
            System.out.println("Cancelled!");
        }

        @Override
        protected void hookOnComplete() {
           System.out.println("Completed!");
        }

        @Override
        protected void hookOnError(Throwable throwable) {
           System.out.println("error: "+throwable.getMessage());
        }

        @Override
        protected void hookOnNext(T value) {
            System.out.println("Received next: "+value);
            request(1);//request a new element when available
        }

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscribed! "+subscription.toString());
            request(1); //when implementing the interface, we need to specify,
            //how many items we are able to process at a time (This is related to back-pressure)
        }
            
    }
}