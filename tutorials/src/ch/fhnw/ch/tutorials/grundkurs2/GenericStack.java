package ch.fhnw.ch.tutorials.grundkurs2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericStack <T>{

    private List<T> stack;

    public GenericStack () {
        this.stack = new ArrayList<>();
    }

    public Optional <T> pop() {
        if (stack.isEmpty()) {
            return Optional.empty();
        } return Optional.of(stack.removeLast());
    }

    public Optional<T> peek() {
        if (stack.isEmpty()) {
            return Optional.empty();
        } return Optional.of(stack.getLast());
    }

    public void push(T item) {
        stack.add(item);
    }

    public static void main(String[] args) {
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");

        stringStack.peek().ifPresent(System.out::println);
        stringStack.pop().ifPresent(System.out::println);
        stringStack.pop().ifPresent(System.out::println);
    }
}
