package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(e->System.out.println("Number in intNumbersStream: "+e));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(number->number<5)
                    .forEach(e->System.out.println("Number less than 5: "+e));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(number->number>5)
        .skip(1)
        .limit(2)
        .forEach(number->System.out.println("second and third number greater than 5: "+number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value=StreamSources.intNumbersStream().filter(number->number>5)
        .findFirst()
        .orElse(-1);
        System.out.println("First number greater than 5: "+value);

        // Print first names of all users in userStream
        StreamSources.userStream()
            .map(User::getFirstName)
            .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
        .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
        .map(user -> user.getFirstName())
        .forEach(username -> System.out.println(username));


    }

}
