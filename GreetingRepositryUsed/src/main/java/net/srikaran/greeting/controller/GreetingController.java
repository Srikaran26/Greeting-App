package net.srikaran.greeting.controller;

import net.srikaran.greeting.dto.GreetingUpdateRequest;
import net.srikaran.greeting.entity.Greeting;
import net.srikaran.greeting.service.GreetingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @PostMapping("/greet")
    public String greet(@RequestBody GreetingUpdateRequest request) {
        Greeting greeting = greetingService.createGreeting(request.getFirstName(), request.getLastName());
        return greeting.getMessage();
    }
    
    @GetMapping("/greet/{id}")
    public String getGreeting(@PathVariable("id") Long id) {
        Greeting greeting = greetingService.getGreetingById(id);
        return greeting.getMessage();
    }
    
    @GetMapping("/greet/all")
    public List<String> getAllGreetingMessages() {
        List<Greeting> greetings = greetingService.getAllGreetings();
        return greetings.stream()
                .map(Greeting::getMessage)
                .toList(); 
    }
    
    @PutMapping("/greet/{id}")
    public String updateGreeting(@PathVariable Long id, @RequestBody GreetingUpdateRequest request) {
        Greeting updated = greetingService.updateGreeting(
            id,
            request.getFirstName(),
            request.getLastName(),
            request.getMessage()
        );
        return updated.getMessage();
    }
    
    @DeleteMapping("/greet/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting deleted successfully with ID: " + id;
    }




}
