package net.srikaran.greeting.service;

import net.srikaran.greeting.entity.Greeting;
import net.srikaran.greeting.repository.GreetingRepository;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting createGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello Mr./Ms. " + lastName + "!";
        } else {
            message = "Hello World!";
        }

        Greeting greeting = new Greeting(firstName,lastName,message);
        return greetingRepository.save(greeting);
    }
    
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Greeting not found with ID: " + id));
    }
    
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    
    public Greeting updateGreeting(Long id, String firstName, String lastName, String message) {
        Greeting greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Greeting not found with ID: " + id));

        greeting.setFirstName(firstName);
        greeting.setLastName(lastName);
        greeting.setMessage(message);

        return greetingRepository.save(greeting);
    }
    
    public void deleteGreeting(Long id) {
        if (!greetingRepository.existsById(id)) {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
        greetingRepository.deleteById(id);
    }




}
