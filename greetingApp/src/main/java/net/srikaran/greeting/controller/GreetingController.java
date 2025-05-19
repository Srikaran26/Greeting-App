package net.srikaran.greeting.controller;

import net.srikaran.greeting.model.Greeting;
import net.srikaran.greeting.model1.User;
import net.srikaran.greeting.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingController {
	
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello from GET!");
    }

    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Hello from POST! Received: " + greeting.getMessage());
    }

    @PutMapping
    public Greeting putGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Hello from PUT! Updated: " + greeting.getMessage());
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello from DELETE!");
    }
    
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greet")
    public String getGreeting1() {
        return greetingService.getGreetingMessage();
    }
    
    @PostMapping("/greeting")
    public String greet(@RequestBody User user) {
        return greetingService.getGreeting(user);
    }
}




