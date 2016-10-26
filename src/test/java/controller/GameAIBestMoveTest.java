package controller;

import data.Game;
import data.Square;
import static data.Square.O;
import static data.Square.X;
import static data.Square.e;
import data.Position;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author nilstes
 */
public class GameAIBestMoveTest extends TestCase {

    @Test
    public void testThatAICanFindWinPosition() {
        Square[][] board = {
            {O,O,O,O,e},
            {X,O,e,X,e},
            {O,O,e,X,e},
            {X,O,e,X,e},
            {X,X,X,O,e}        
        };
        Game game = new Game("testId", "inviter", "invitee", 5);
        game.setBoard(board);
        GameAI ai = new GameAI(game);
        List<Position> pos = ai.getBestMoves();
        
        assertTrue(pos.contains(Position.at(4, 0)));
    }

    @Test
    public void testThatAIWillBlock() {
        Square[][] board = {
            {e,e,e,e,e},
            {e,X,X,X,e},
            {e,O,O,e,e},
            {e,e,e,e,e},
            {e,e,e,e,e}        
        };
        Game game = new Game("testId", "inviter", "invitee", 5);
        game.setBoard(board);
        GameAI ai = new GameAI(game);
        List<Position> pos = ai.getBestMoves();
        
        assertTrue(pos.contains(Position.at(0, 1)));
    }

    @Test
    public void testThatAIPreferBlanksOnBothSides() {
        Square[][] board = {
            {e,e,e,e,e},
            {X,O,O,O,e},
            {e,O,O,O,e},
            {e,e,e,e,e},
            {e,e,e,e,e}        
        };
        Game game = new Game("testId", "inviter", "invitee", 5);
        game.setBoard(board);
        GameAI ai = new GameAI(game);
        List<Position> pos = ai.getBestMoves();
        
        assertTrue(pos.contains(Position.at(0, 2)));
    }
}
