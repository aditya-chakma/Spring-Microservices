package aditya.tuorials.spring.spring_recap.runner;

import aditya.tuorials.spring.spring_recap.games.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author aditya.chakma
 * @since 01 Jan, 2025 2:49 PM
 */
@Component
public class GameRunner {

    Game game;

    public GameRunner(@Autowired @Qualifier("contra") Game game) {
        this.game = game;
    }

    public void run() {
        game.run();
    }
}
