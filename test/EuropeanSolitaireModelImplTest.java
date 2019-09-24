import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contains the tests for the {@code EuropeanSolitaireModelImpl} implementation.
 */

public class EuropeanSolitaireModelImplTest {
  private EuropeanSolitaireModelImpl defaultBoard;

  @Before
  public void setUp() {
    defaultBoard = new EuropeanSolitaireModelImpl();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError1() {
    new EuropeanSolitaireModelImpl(-4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError2() {
    new EuropeanSolitaireModelImpl(-7, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError3() {
    new EuropeanSolitaireModelImpl(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError4() {
    new EuropeanSolitaireModelImpl(-1, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEvenSizeError1() {
    new EuropeanSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEvenSizeError2() {
    new EuropeanSolitaireModelImpl(6, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEvenSizeError3() {
    new EuropeanSolitaireModelImpl(8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEvenSizeError4() {
    new EuropeanSolitaireModelImpl(10, 13, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor1() {
    new EuropeanSolitaireModelImpl(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor2() {
    new EuropeanSolitaireModelImpl(3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor3() {
    new EuropeanSolitaireModelImpl(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor4() {
    new EuropeanSolitaireModelImpl(-4, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor5() {
    new EuropeanSolitaireModelImpl(3, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor6() {
    new EuropeanSolitaireModelImpl(8, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor7() {
    new EuropeanSolitaireModelImpl(7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor8() {
    new EuropeanSolitaireModelImpl(10, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor9() {
    new EuropeanSolitaireModelImpl(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor10() {
    new EuropeanSolitaireModelImpl(1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor11() {
    new EuropeanSolitaireModelImpl(6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor12() {
    new EuropeanSolitaireModelImpl(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor1() {
    new EuropeanSolitaireModelImpl(5, -3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor2() {
    new EuropeanSolitaireModelImpl(5, 6, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor3() {
    new EuropeanSolitaireModelImpl(5, -2, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor4() {
    new EuropeanSolitaireModelImpl(5, -4, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor5() {
    new EuropeanSolitaireModelImpl(5, 7, 13);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor6() {
    new EuropeanSolitaireModelImpl(5, 16, 17);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor7() {
    new EuropeanSolitaireModelImpl(5, 13, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor8() {
    new EuropeanSolitaireModelImpl(5, 14, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor9() {
    new EuropeanSolitaireModelImpl(5, 2, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor10() {
    new EuropeanSolitaireModelImpl(2, 11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor11() {
    new EuropeanSolitaireModelImpl(10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor12() {
    new EuropeanSolitaireModelImpl(12, 11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage1() {
    try {
      defaultBoard.move(1, 0, 3, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'from' coordinates must be valid.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage2() {
    try {
      defaultBoard.move(0, 3, 0, 1);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'to' coordinates must be valid.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage3() {
    try {
      defaultBoard.move(3, 3, 3, 1);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'from' slot must have a marble.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage4() {
    try {
      defaultBoard.move(3, 4, 3, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'to' slot must be empty.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage5() {
    try {
      defaultBoard.move(4, 4, 3, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'to' and 'from' slot must be in the same row or column.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage6() {
    try {
      defaultBoard.move(0, 3, 3, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'to' and 'from' slot must be two units away.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage7() {
    try {
      defaultBoard.move(1, 3, 3, 3);
      defaultBoard.move(3, 3, 1, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("The slot between the 'to' and 'from' slot must have a marble.",
              e.getMessage());
      throw e;
    }
  }

  @Test
  public void testMove1() {
    defaultBoard.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", defaultBoard.getGameState());
  }

  @Test
  public void testMove2() {
    defaultBoard.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", defaultBoard.getGameState());
  }

  @Test
  public void testMove3() {
    defaultBoard.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", defaultBoard.getGameState());
  }

  @Test
  public void testMove4() {
    defaultBoard.move(3, 5, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", defaultBoard.getGameState());
  }

  @Test
  public void testOnStartGameOverFalse() {
    assertFalse(new EuropeanSolitaireModelImpl().isGameOver());
    assertFalse(new EuropeanSolitaireModelImpl(5).isGameOver());
    assertFalse(new EuropeanSolitaireModelImpl(2, 3).isGameOver());
    assertFalse(new EuropeanSolitaireModelImpl(7, 6, 8).isGameOver());
  }

  @Test
  public void testGameState() {
    MarbleSolitaireModel game1 = new EuropeanSolitaireModelImpl(5);
    MarbleSolitaireModel game2 = new EuropeanSolitaireModelImpl(5, 3);
    MarbleSolitaireModel game3 = new EuropeanSolitaireModelImpl(7, 10, 13);
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", defaultBoard.getGameState());
    assertEquals("        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", game1.getGameState());
    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "  O O _ O O\n"
            + "    O O O", game2.getGameState());
    assertEquals("            O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O _ O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O O O O O O O\n"
            + "    O O O O O O O O O O O O O O O\n"
            + "      O O O O O O O O O O O O O\n"
            + "        O O O O O O O O O O O\n"
            + "          O O O O O O O O O\n"
            + "            O O O O O O O", game3.getGameState());
  }

  @Test
  public void testScore() {
    int scoreBeforeMoves = defaultBoard.getScore();
    assertEquals(scoreBeforeMoves,36);
    defaultBoard.move(1,3,3,3);
    assertEquals(scoreBeforeMoves - 1, defaultBoard.getScore());
    defaultBoard.move(4,3,2,3);
    assertEquals(scoreBeforeMoves - 2, defaultBoard.getScore());
    defaultBoard.move(1,1,1,3);
    assertEquals(scoreBeforeMoves - 3, defaultBoard.getScore());
  }

  @Test
  public void testGameOverWin() {
    MarbleSolitaireModel gameBoard = new EuropeanSolitaireModelImpl(0,2);
    gameBoard.move(2, 2, 0, 2);
    gameBoard.move(2, 0, 2, 2);
    gameBoard.move(1, 4, 1, 2);
    gameBoard.move(3, 4, 1, 4);
    gameBoard.move(3, 2, 3, 4);
    gameBoard.move(2, 3, 2, 1);
    gameBoard.move(5, 3, 3, 3);
    gameBoard.move(3, 0, 3, 2);
    gameBoard.move(5, 1, 3, 1);
    gameBoard.move(4, 5, 4, 3);
    gameBoard.move(5, 5, 5, 3);
    gameBoard.move(0, 4, 2, 4);
    gameBoard.move(2, 1, 4, 1);
    gameBoard.move(2, 4, 4, 4);
    gameBoard.move(5, 2, 5, 4);
    gameBoard.move(3, 6, 3, 4);
    gameBoard.move(1, 1, 1, 3);
    gameBoard.move(2, 6, 2, 4);
    gameBoard.move(0, 3, 2, 3);
    gameBoard.move(3, 2, 5, 2);
    gameBoard.move(3, 4, 3, 2);
    gameBoard.move(6, 2, 4, 2);
    gameBoard.move(3, 2, 5, 2);
    gameBoard.move(4, 0, 4, 2);
    gameBoard.move(4, 3, 4, 1);
    gameBoard.move(6, 4, 6, 2);
    gameBoard.move(6, 2, 4, 2);
    gameBoard.move(4, 1, 4, 3);
    gameBoard.move(4, 3, 4, 5);
    gameBoard.move(4, 6, 4, 4);
    gameBoard.move(5, 4, 3, 4);
    gameBoard.move(3, 4, 1, 4);
    gameBoard.move(1, 5, 1, 3);
    gameBoard.move(2, 3, 0, 3);
    gameBoard.move(0, 2, 0, 4);
    assertTrue(gameBoard.isGameOver());
    assertEquals(1, gameBoard.getScore());
    assertEquals("    _ _ O\n"
            + "  _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    _ _ _", gameBoard.getGameState());
  }

  @Test
  public void testGameOverLose() {
    defaultBoard.move(1, 3, 3, 3);
    defaultBoard.move(1, 1, 1, 3);
    defaultBoard.move(0, 3, 2, 3);
    defaultBoard.move(1, 5, 1, 3);
    defaultBoard.move(2, 3, 0, 3);
    defaultBoard.move(2, 1, 2, 3);
    defaultBoard.move(2, 4, 2, 2);
    defaultBoard.move(2, 6, 2, 4);
    defaultBoard.move(3, 2, 1, 2);
    defaultBoard.move(0, 2, 2, 2);
    defaultBoard.move(0, 4, 0, 2);
    defaultBoard.move(3, 0, 3, 2);
    defaultBoard.move(3, 2, 1, 2);
    defaultBoard.move(0, 2, 2, 2);
    defaultBoard.move(3, 4, 1, 4);
    defaultBoard.move(3, 6, 3, 4);
    defaultBoard.move(3, 3, 3, 5);
    defaultBoard.move(4, 5, 2, 5);
    defaultBoard.move(4, 3, 4, 5);
    defaultBoard.move(4, 1, 4, 3);
    defaultBoard.move(4, 6, 4, 4);
    defaultBoard.move(4, 3, 4, 5);
    defaultBoard.move(5, 5, 3, 5);
    defaultBoard.move(2, 5, 4, 5);
    defaultBoard.move(5, 3, 5, 5);
    defaultBoard.move(5, 1, 5, 3);
    defaultBoard.move(5, 5, 3, 5);
    defaultBoard.move(6, 3, 4, 3);
    assertTrue(defaultBoard.isGameOver());
    assertNotEquals(1, defaultBoard.getScore());
    assertEquals("    _ _ _\n"
            + "  _ _ _ O _\n"
            + "O _ O _ _ _ _\n"
            + "_ _ _ _ _ O _\n"
            + "O _ _ O _ _ _\n"
            + "  _ _ _ _ _\n"
            + "    O _ O", defaultBoard.getGameState());
  }
}
