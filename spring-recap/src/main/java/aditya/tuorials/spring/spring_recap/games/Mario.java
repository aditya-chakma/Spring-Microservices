package aditya.tuorials.spring.spring_recap.games;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author aditya.chakma
 * @since 01 Jan, 2025 2:44 PM
 */
@Component
@Primary
public class Mario implements Game{

    private void jump() {
        System.out.println("jump");
    }

    private void control() {
        System.out.println("left, right, up, down");
    }

    @Override
    public void run() {
        jump();
        control();
    }
}
