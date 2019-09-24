import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Contains the tests for the {@code MarbleSolitaireControllerImpl} implementation.
 */

public class MarbleSolitaireControllerImplTest {
  @Test
  public void testQuitAfterMoves() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("6 4 4 4 5 6 5 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 30", out.toString());

  }

  @Test
  public void testMovesAfterQuit() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 4 4 4 q 3 2 3 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());

  }

  @Test
  public void testGameOver1() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 4 4 4 q 3 2 3 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    MarbleSolitaireModelImpl marbleGame = new MarbleSolitaireModelImpl();
    marbleGame.move(1, 3, 3, 3);
    marbleGame.move(2, 1, 2, 3);
    marbleGame.move(0, 2, 2, 2);
    marbleGame.move(0, 4, 0, 2);
    marbleGame.move(2, 3, 2, 1);
    marbleGame.move(2, 0, 2, 2);
    marbleGame.move(2, 4, 0, 4);
    marbleGame.move(2, 6, 2, 4);
    marbleGame.move(3, 2, 1, 2);
    marbleGame.move(0, 2, 2, 2);
    marbleGame.move(3, 0, 3, 2);
    marbleGame.move(3, 2, 1, 2);
    marbleGame.move(3, 4, 1, 4);
    marbleGame.move(0, 4, 2, 4);
    marbleGame.move(3, 6, 3, 4);
    marbleGame.move(3, 4, 1, 4);
    marbleGame.move(5, 2, 3, 2);
    marbleGame.move(4, 0, 4, 2);
    marbleGame.move(4, 2, 2, 2);
    marbleGame.move(1, 2, 3, 2);
    marbleGame.move(3, 2, 3, 4);
    marbleGame.move(4, 4, 2, 4);
    marbleGame.move(1, 4, 3, 4);
    marbleGame.move(4, 6, 4, 4);
    marbleGame.move(4, 3, 4, 5);
    marbleGame.move(6, 4, 4, 4);
    marbleGame.move(3, 4, 5, 4);
    marbleGame.move(6, 2, 6, 4);
    marbleGame.move(6, 4, 4, 4);
    marbleGame.move(4, 5, 4, 3);
    marbleGame.move(4, 3, 6, 3);
    controller.playGame(marbleGame);
    assertEquals("Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "Score: 1", out.toString());

  }

  @Test
  public void testGameOver2() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("5 4 7 4 3 2 3 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    MarbleSolitaireModelImpl marbleGame = new MarbleSolitaireModelImpl();
    marbleGame.move(1, 3, 3, 3);
    marbleGame.move(2, 1, 2, 3);
    marbleGame.move(0, 2, 2, 2);
    marbleGame.move(0, 4, 0, 2);
    marbleGame.move(2, 3, 2, 1);
    marbleGame.move(2, 0, 2, 2);
    marbleGame.move(2, 4, 0, 4);
    marbleGame.move(2, 6, 2, 4);
    marbleGame.move(3, 2, 1, 2);
    marbleGame.move(0, 2, 2, 2);
    marbleGame.move(3, 0, 3, 2);
    marbleGame.move(3, 2, 1, 2);
    marbleGame.move(3, 4, 1, 4);
    marbleGame.move(0, 4, 2, 4);
    marbleGame.move(3, 6, 3, 4);
    marbleGame.move(3, 4, 1, 4);
    marbleGame.move(5, 2, 3, 2);
    marbleGame.move(4, 0, 4, 2);
    marbleGame.move(4, 2, 2, 2);
    marbleGame.move(1, 2, 3, 2);
    marbleGame.move(3, 2, 3, 4);
    marbleGame.move(4, 4, 2, 4);
    marbleGame.move(1, 4, 3, 4);
    marbleGame.move(4, 6, 4, 4);
    marbleGame.move(4, 3, 4, 5);
    marbleGame.move(6, 4, 4, 4);
    marbleGame.move(3, 4, 5, 4);
    marbleGame.move(6, 2, 6, 4);
    marbleGame.move(6, 4, 4, 4);
    marbleGame.move(4, 5, 4, 3);
    controller.playGame(marbleGame);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "Score: 1", out.toString());

  }

  @Test
  public void testGameOver3() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("5 6 5 4 5 4 7 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    MarbleSolitaireModelImpl marbleGame = new MarbleSolitaireModelImpl();
    marbleGame.move(1, 3, 3, 3);
    marbleGame.move(2, 1, 2, 3);
    marbleGame.move(0, 2, 2, 2);
    marbleGame.move(0, 4, 0, 2);
    marbleGame.move(2, 3, 2, 1);
    marbleGame.move(2, 0, 2, 2);
    marbleGame.move(2, 4, 0, 4);
    marbleGame.move(2, 6, 2, 4);
    marbleGame.move(3, 2, 1, 2);
    marbleGame.move(0, 2, 2, 2);
    marbleGame.move(3, 0, 3, 2);
    marbleGame.move(3, 2, 1, 2);
    marbleGame.move(3, 4, 1, 4);
    marbleGame.move(0, 4, 2, 4);
    marbleGame.move(3, 6, 3, 4);
    marbleGame.move(3, 4, 1, 4);
    marbleGame.move(5, 2, 3, 2);
    marbleGame.move(4, 0, 4, 2);
    marbleGame.move(4, 2, 2, 2);
    marbleGame.move(1, 2, 3, 2);
    marbleGame.move(3, 2, 3, 4);
    marbleGame.move(4, 4, 2, 4);
    marbleGame.move(1, 4, 3, 4);
    marbleGame.move(4, 6, 4, 4);
    marbleGame.move(4, 3, 4, 5);
    marbleGame.move(6, 4, 4, 4);
    marbleGame.move(3, 4, 5, 4);
    marbleGame.move(6, 2, 6, 4);
    marbleGame.move(6, 4, 4, 4);
    controller.playGame(marbleGame);
    assertEquals("    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "Score: 1", out.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(new StringReader(""),
            new StringBuilder());
    controller.playGame(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullInput() {
    new MarbleSolitaireControllerImpl(null, new StringBuilder());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullOutput() {
    new MarbleSolitaireControllerImpl(new StringReader(""), null);
  }

  @Test(expected = IllegalStateException.class)
  public void testNoMoves1() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test(expected = IllegalStateException.class)
  public void testNoMoves2() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    MarbleSolitaireModelImpl marbleGame = new MarbleSolitaireModelImpl(1, 3);
    marbleGame.move(3, 3, 1, 3);
    controller.playGame(marbleGame);
  }

  @Test(expected = IllegalStateException.class)
  public void testNoMoves3() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl(7));
  }

  @Test(expected = IllegalStateException.class)
  public void testInvalidMovesEndOfInput() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("1 4 3 5 2 3 4 2 3 4 2 5 2 1 3 5 2 3 5 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test(expected = IllegalStateException.class)
  public void testInvalidInputEndOfInput() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("1 -4 foo bar -3 5 7 -3 2 2 3 4 someRandomString 2 5 2 -1 3 " +
            "thisIsInvalidInput 5 2 3 -5 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test(expected = IllegalStateException.class)
  public void testMovesToEndOfInput() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 4 4 4 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "3 4 3 2 " +
            "3 1 3 3 " +
            "3 5 1 5 " +
            "3 7 3 5 " +
            "4 3 2 3 " +
            "1 3 3 3 " +
            "4 1 4 3 " +
            "4 3 2 3 " +
            "4 5 2 5 " +
            "1 5 3 5 " +
            "4 7 4 5 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test(expected = IllegalStateException.class) //Fail to append
  public void testOutputException() {
    Reader in = new StringReader("2 4 4 4 q");
    Appendable out = new AppendableTest();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test
  public void testMovesThenQuit() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 4 4 4 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "3 4 3 2 " +
            "3 1 3 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "_ _ O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "_ _ O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26", out.toString());
  }

  @Test
  public void testInvalidMovesThenQuit() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("3 5 4 4 " +
            "2 4 4 4 " +
            "4 4 2 4 " +
            "3 4 9 3 " +
            "3 4 3 3 " +
            "3 13 5 3 " +
            "4 4 4 6 " +
            "5 4 2 4 " +
            "q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. The to and from slot must be in the same row or column.\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again. The slot between the to and from slot must have a marble." +
            "\nInvalid move. Play again. The 'to' coordinates must be valid.\n" +
            "Invalid move. Play again. The from slot must have a marble.\n" +
            "Invalid move. Play again. The 'from' coordinates must be valid.\n" +
            "Invalid move. Play again. The to slot must be empty.\n" +
            "Invalid move. Play again. The to and from slot must be two units away.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", out.toString());
  }

  @Test
  public void testInvalidInputThenQuit() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 3 -3 2 5" +
            "5 1 3 -1 1" +
            "foo bar\n" +
            "-2 -1 -3 0 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Invalid move. Play again. The 'to' coordinates must be valid.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Invalid input. Please enter again.\n" +
            "Invalid input. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", out.toString());
  }

  @Test
  public void testInputAfterGameOver() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 4 4 4 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "3 4 3 2 " +
            "3 1 3 3 " +
            "3 5 1 5 " +
            "3 7 3 5 " +
            "4 3 2 3 " +
            "1 3 3 3 " +
            "4 1 4 3 " +
            "4 3 2 3 " +
            "4 5 2 5 " +
            "1 5 3 5 " +
            "4 7 4 5 " +
            "4 5 2 5 " +
            "6 3 4 3 " +
            "5 1 5 3 " +
            "5 3 3 3 " +
            "2 3 4 3 " +
            "4 3 4 5 " +
            "5 5 3 5 " +
            "2 5 4 5 " +
            "5 7 5 5 " +
            "5 4 5 6 " +
            "7 5 5 5 " +
            "4 5 6 5 " +
            "7 3 7 5 " +
            "7 5 5 5 " +
            "5 6 5 4 " +
            "5 4 7 4 " +
            "this input is after the game has been won it will be ignored by the controller, and " +
            "should not affect the game in any way :) q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "_ _ O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O _ O\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    _ _ O\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 15\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 14\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 13\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 12\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O _ _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "Score: 1", out.toString());
  }

  @Test
  public void testGameOverWithInvalidMoves() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 4 4 4 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "3 4 3 2 " +
            "3 1 3 3 " +
            "3 5 1 5 " +
            "1 3 2 4 " +
            "3 7 3 5 " +
            "4 3 2 3 " +
            "1 3 3 3 " +
            "4 1 4 3 " +
            "4 3 2 3 " +
            "4 5 2 5 " +
            "1 5 3 5 " +
            "4 7 4 5 " +
            "foo bar " +
            "4 5 2 5 " +
            "6 3 4 3 " +
            "5 1 5 3 " +
            "5 3 3 3 " +
            "2 3 4 3 " +
            "4 -3 -2 3 1 2 " +
            "4 -3 3 -4 4 5 " +
            "5 5 3 5 " +
            "2 5 4 5 " +
            "5 7 5 5 " +
            "5 4 5 6 " +
            "7 -2 5 5 0 5 " +
            "4 5 6 5 " +
            "7 3 7 5 " +
            "7 5 5 5 " +
            "-3 5 6 5 -2 4 " +
            "5 4 7 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "_ _ O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "Invalid move. Play again. The to and from slot must be in the same row or column.\n" +
            "    O _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O _ O\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    _ _ O\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "Invalid input. Please enter again.\n" +
            "Invalid input. Please enter again.\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 15\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 14\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 13\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 12\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Invalid move. Play again. The 'to' coordinates must be valid.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O _ _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 7\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "Integers can not be negative. Please enter again.\n" +
            "Integers can not be negative. Please enter again.\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "Score: 1", out.toString());
  }


  @Test
  public void testMoveToGameOver() {
    StringBuilder out = new StringBuilder();
    Reader in = new StringReader("2 4 4 4 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "3 4 3 2 " +
            "3 1 3 3 " +
            "3 5 1 5 " +
            "3 7 3 5 " +
            "4 3 2 3 " +
            "1 3 3 3 " +
            "4 1 4 3 " +
            "4 3 2 3 " +
            "4 5 2 5 " +
            "1 5 3 5 " +
            "4 7 4 5 " +
            "4 5 2 5 " +
            "6 3 4 3 " +
            "5 1 5 3 " +
            "5 3 3 3 " +
            "2 3 4 3 " +
            "4 3 4 5 " +
            "5 5 3 5 " +
            "2 5 4 5 " +
            "5 7 5 5 " +
            "5 4 5 6 " +
            "7 5 5 5 " +
            "4 5 6 5 " +
            "7 3 7 5 " +
            "7 5 5 5 " +
            "5 6 5 4 " +
            "5 4 7 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "O O _ _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ _\n" +
            "    _ _ O\n" +
            "_ _ O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O _ O\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "_ _ O _ O _ _\n" +
            "_ _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    _ _ O\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    _ _ O\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    _ _ _\n" +
            "    O _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 15\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 14\n" +
            "    _ _ _\n" +
            "    O _ O\n" +
            "_ _ O _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 13\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ O O _ _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 12\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 11\n" +
            "    _ _ _\n" +
            "    _ _ O\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 10\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O _ O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 9\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ O O _ _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ O _\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "Score: 1", out.toString());
  }

  @Test
  public void testSpacesOrNewLine() {
    StringBuilder out1 = new StringBuilder();
    Reader in1 = new StringReader("2 4 4 4 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "3 4 3 2 " +
            "3 1 3 3 " +
            "3 5 1 5 " +
            "3 7 3 5 " +
            "4 3 2 3 " +
            "1 3 3 3 " +
            "4 1 4 3 " +
            "4 3 2 3 " +
            "4 5 2 5 " +
            "1 5 3 5 " +
            "4 7 4 5 " +
            "4 5 2 5 " +
            "6 3 4 3 " +
            "5 1 5 3 " +
            "5 3 3 3 " +
            "2 3 4 3 " +
            "4 3 4 5 " +
            "5 5 3 5 " +
            "2 5 4 5 " +
            "5 7 5 5 " +
            "5 4 5 6 " +
            "7 5 5 5 " +
            "4 5 6 5 " +
            "7 3 7 5 " +
            "7 5 5 5 " +
            "5 6 5 4 " +
            "5 4 7 4");
    StringBuilder out2 = new StringBuilder();
    Reader in2 = new StringReader("2\n4\n4\n4\n" +
            "3\n2\n3\n4\n" +
            "1\n3\n3\n3\n" +
            "1\n5\n1\n3\n" +
            "3\n4\n3\n2\n" +
            "3\n1\n3\n3\n" +
            "3\n5\n1\n5\n" +
            "3\n7\n3\n5\n" +
            "4\n3\n2\n3\n" +
            "1\n3\n3\n3\n" +
            "4\n1\n4\n3\n" +
            "4\n3\n2\n3\n" +
            "4\n5\n2\n5\n" +
            "1\n5\n3\n5\n" +
            "4\n7\n4\n5\n" +
            "4\n5\n2\n5\n" +
            "6\n3\n4\n3\n" +
            "5\n1\n5\n3\n" +
            "5\n3\n3\n3\n" +
            "2\n3\n4\n3\n" +
            "4\n3\n4\n5\n" +
            "5\n5\n3\n5\n" +
            "2\n5\n4\n5\n" +
            "5\n7\n5\n5\n" +
            "5\n4\n5\n6\n" +
            "7\n5\n5\n5\n" +
            "4\n5\n6\n5\n" +
            "7\n3\n7\n5\n" +
            "7\n5\n5\n5\n" +
            "5\n6\n5\n4\n" +
            "5\n4\n7\n4");
    StringBuilder out3 = new StringBuilder();
    Reader in3 = new StringReader("2 4 4 4 " +
            "3 2 3 4 " +
            "1 3 3 3 " +
            "1 5 1 3 " +
            "3 4 3 2 " +
            "3 1 3 3 " +
            "3 5 1 5 " +
            "3 7 3 5 " +
            "4 3 2 3 " +
            "1 3 3 3 " +
            "4 1 4 3 " +
            "4 3 2 3 " +
            "4 5 2 5 " +
            "1 5 3 5 " +
            "4 7 4 5 " +
            "4 5 2 5 " +
            "6 3 4 3 " +
            "5 1 5 3 " +
            "5 3 3 3 " +
            "2 3 4 3 " +
            "4 3 4 5 " +
            "5 5 3 5 " +
            "2 5 4 5 " +
            "5 7 5 5 " +
            "5 4 5 6 " +
            "7 5 5 5 " +
            "4 5 6 5 " +
            "7 3 7 5 " +
            "7 5 5 5 " +
            "5 6 5 4 " +
            "5 4 7 4 " +
            "this input is after the game has been won it will be ignored by the controller, and " +
            "should not affect the game in any way :) q");
    MarbleSolitaireController controller1 = new MarbleSolitaireControllerImpl(in1, out1);
    MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(in2, out2);
    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(in3, out3);
    controller1.playGame(new MarbleSolitaireModelImpl());
    controller2.playGame(new MarbleSolitaireModelImpl());
    controller3.playGame(new MarbleSolitaireModelImpl());
    assertEquals(out1, out2);
    assertEquals(out2, out3);
  }
}

