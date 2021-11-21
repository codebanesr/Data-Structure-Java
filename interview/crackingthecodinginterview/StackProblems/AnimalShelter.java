package interview.crackingthecodinginterview.StackProblems;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Animal {
    private String type;
    private static AtomicInteger order = new AtomicInteger(0);
    private int insertionOrder;

    Animal(String type) {
        this.type = type;
        insertionOrder = order.getAndIncrement();
    }

    public int getTimestamp() {
        return insertionOrder;
    }

    public String getType() {
        return this.type;
    }
}

class Dog extends Animal {
    Dog(String type) {
        super(type);
    }
}

class Cat extends Animal {
    Cat(String type) {
        super(type);
    }
}

class AnimalQueue {
    private Queue<Animal> cats = new LinkedList<>();
    private Queue<Animal> dogs = new LinkedList<>();

    public void enqueue(Animal a) {
        if (a instanceof Cat) {
            cats.add(a);
        } else if (a instanceof Dog) {
            dogs.add(a);
        }
    }

    public Animal dequeueDog() {
        if (!dogs.isEmpty())
            return dogs.remove();

        else
            throw new Error("No more dogs");
    }

    public boolean isEmpty() {
        return cats.isEmpty() && dogs.isEmpty();
    }

    public Animal dequeueCat() {
        if (!cats.isEmpty())
            return cats.remove();

        else
            throw new Error("No more cats");
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new Error("No more animals");
        }

        else if (dogs.isEmpty()) {
            return dequeueCat();
        }

        else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Animal cat = cats.peek();
        Animal dog = dogs.peek();

        if (cat.getTimestamp() < dog.getTimestamp()) {
            return dequeueCat();
        } else {
            return dequeueDog();
        }
    }
}

public class AnimalShelter {
    public static void main(String args[]) {
        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(new Cat("persian"));
        aq.enqueue(new Dog("Labrador"));
        aq.enqueue(new Cat("bengal"));
        aq.enqueue(new Dog("golden retriever"));
        aq.enqueue(new Cat("angora"));
        aq.enqueue(new Dog("bulldog"));

        while (!aq.isEmpty()) {
            System.out.println(aq.dequeueAny().getType());
        }
    }
}
