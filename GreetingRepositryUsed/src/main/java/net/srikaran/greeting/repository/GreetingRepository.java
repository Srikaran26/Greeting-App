package net.srikaran.greeting.repository;

import net.srikaran.greeting.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}

