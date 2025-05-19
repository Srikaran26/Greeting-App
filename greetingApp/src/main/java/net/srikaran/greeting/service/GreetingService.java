package net.srikaran.greeting.service;

import net.srikaran.greeting.model1.User;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreetingMessage() {
        return "Hello World";
    }
    
    public String getGreeting(User user) {
        boolean hasFirstName = user.getFirstName() != null && !user.getFirstName().isEmpty();
        boolean hasLastName = user.getLastName() != null && !user.getLastName().isEmpty();

        if (hasFirstName && hasLastName) {
            return "Hello " + user.getFirstName() + " " + user.getLastName();
        } else if (hasFirstName) {
            return "Hello " + user.getFirstName();
        } else if (hasLastName) {
            return "Hello " + user.getLastName();
        } else {
            return "Hello World";
        }
    }
}

