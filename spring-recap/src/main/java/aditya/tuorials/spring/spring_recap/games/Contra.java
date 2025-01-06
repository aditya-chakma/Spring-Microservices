package aditya.tuorials.spring.spring_recap.games;

import org.springframework.stereotype.Component;

/**
 * @author aditya.chakma
 * @since 01 Jan, 2025 2:45 PM
 */
@Component
public class Contra implements Game {

    private void control() {
        System.out.println("up, down, left, right");
    }

    private void jump() {
        System.out.println("jump");
    }

    private void fire() {
        System.out.println("fire");
    }

    @Override
    public void run() {
        jump();
        fire();
        control();
    }
}
