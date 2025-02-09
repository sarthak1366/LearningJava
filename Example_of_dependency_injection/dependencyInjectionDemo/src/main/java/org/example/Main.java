package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // SpringApplication.run(Main.class,args); ---------- Now see this will also run our springboot application
        // right now we are learning about spring Dependency injection
        // which says that you dont need to create and manage objects spring does it for you
        // all the objects that are created and managed by spring are called "beans"
        // these beans are stored in a container called IoC container
        // so thats what we are checking in this code ki is spring creating and managing the object


        // One important thing to note is we need to tell spring framework that for a particular class
        // we want spring to handle the object management

        ApplicationContext context = SpringApplication.run(Main.class,args);

        Coding obj = context.getBean(Coding.class);
        obj.code();


    }
