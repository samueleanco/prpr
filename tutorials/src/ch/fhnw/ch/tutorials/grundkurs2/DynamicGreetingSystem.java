package ch.fhnw.ch.tutorials.grundkurs2;

import java.time.LocalTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DynamicGreetingSystem {

    public static void main(String[] args) {
        Supplier<String> partOfDaySupplier = () -> {
            int hour = LocalTime.now().getHour();
            if (hour < 12) {
                return "Morning";
            } else if (hour < 18) {
                return "Afternoon";
            } else {
                return "Evening";
            }
        };

        Consumer<String> greetingConsumer = name -> {
            String partOfDay = partOfDaySupplier.get();
            System.out.println("Good " + partOfDay+ "," +  name);
        };

        String userName = "John Doe";
        greetingConsumer.accept(userName);
    }
}
