package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Coding {

    @Autowired
    Laptop lap;

    public void code(){
        lap.someClass();
        System.out.println("Hello from coding class");
    }
}
