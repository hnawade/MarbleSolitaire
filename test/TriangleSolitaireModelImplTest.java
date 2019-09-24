import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contains the tests for the {@code TriangleSolitaireModelImpl} implementation.
 */

public class TriangleSolitaireModelImplTest {
  private TriangleSolitaireModelImpl defaultBoard;
  private TriangleSolitaireModelImpl holeInCenterBoard;

  @Before
  public void setUp() {
    defaultBoard = new TriangleSolitaireModelImpl();
    holeInCenterBoard = new TriangleSolitaireModelImpl(9, 4, 2);
  }

  private void solveDefaultBoard() {
    setUp();
    defaultBoard.move(2, 0, 0, 0);
    defaultBoard.move(2, 2, 2, 0);
    defaultBoard.move(4, 4, 2, 2);
    defaultBoard.move(1, 1, 3, 3);
    defaultBoard.move(4, 2, 2, 2);
    defaultBoard.move(4, 0, 4, 2);
    defaultBoard.move(3, 0, 1, 0);
    defaultBoard.move(4, 3, 4, 1);
    defaultBoard.move(4, 1, 2, 1);
    defaultBoard.move(3, 3, 1, 1);
    defaultBoard.move(0, 0, 2, 2);
    defaultBoard.move(2, 2, 2, 0);
    defaultBoard.move(2, 0, 0, 0);
  }

  private void randomMoves() {
    setUp();
    defaultBoard.move(2, 0, 0, 0);
    defaultBoard.move(4, 0, 2, 0);
    defaultBoard.move(4, 2, 4, 0);
    defaultBoard.move(2, 0, 4, 2);
    defaultBoard.move(4, 3, 4, 1);
    defaultBoard.move(4, 0, 4, 2);
    defaultBoard.move(2, 1, 4, 3);
    defaultBoard.move(4, 3, 4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError1() {
    new TriangleSolitaireModelImpl(-4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError2() {
    new TriangleSolitaireModelImpl(-7, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError3() {
    new TriangleSolitaireModelImpl(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSizeError4() {
    new TriangleSolitaireModelImpl(-1, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor1() {
    new TriangleSolitaireModelImpl(-3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor2() {
    new TriangleSolitaireModelImpl(3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor3() {
    new TriangleSolitaireModelImpl(-1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor4() {
    new TriangleSolitaireModelImpl(-4, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor5() {
    new TriangleSolitaireModelImpl(3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor6() {
    new TriangleSolitaireModelImpl(3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor7() {
    new TriangleSolitaireModelImpl(7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor8() {
    new TriangleSolitaireModelImpl(10, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor9() {
    new TriangleSolitaireModelImpl(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor10() {
    new TriangleSolitaireModelImpl(1, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor11() {
    new TriangleSolitaireModelImpl(6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridConstructor12() {
    new TriangleSolitaireModelImpl(6, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor1() {
    new TriangleSolitaireModelImpl(5, -3, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor2() {
    new TriangleSolitaireModelImpl(5, 6, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor3() {
    new TriangleSolitaireModelImpl(5, -2, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor4() {
    new TriangleSolitaireModelImpl(5, -4, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor5() {
    new TriangleSolitaireModelImpl(5, 7, 13);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor6() {
    new TriangleSolitaireModelImpl(5, 16, 17);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor7() {
    new TriangleSolitaireModelImpl(5, 13, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor8() {
    new TriangleSolitaireModelImpl(5, 14, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor9() {
    new TriangleSolitaireModelImpl(5, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor10() {
    new TriangleSolitaireModelImpl(2, 11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor11() {
    new TriangleSolitaireModelImpl(10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOffGridDifferentSizeConstructor12() {
    new TriangleSolitaireModelImpl(12, 11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage1() {
    try {
      defaultBoard.move(2, 4, 4, 4);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'from' coordinates must be on the board.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage2() {
    try {
      defaultBoard.move(2, 2, 2, 4);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'to' coordinates must be on the board.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage3() {
    try {
      defaultBoard.move(0, 0, 2, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'from' slot must contain a marble.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage4() {
    try {
      defaultBoard.move(3, 3, 1, 1);
    } catch (IllegalArgumentException e) {
      assertEquals("The 'to' slot must be empty.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage5() {
    try {
      holeInCenterBoard.move(4, 3, 4, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("Moves along the same row should be two columns away.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage6() {
    try {
      holeInCenterBoard.move(4, 0, 4, 2);
      holeInCenterBoard.move(4, 2, 4, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("The slot between the move must contain a marble.", e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage7() {
    try {
      defaultBoard.move(3, 0, 0, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Moves along diagonals should be two rows away.",
              e.getMessage());
    }
    setUp();
    try {
      defaultBoard.move(3, 3, 0, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Moves along diagonals should be two rows away.",
              e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage8() {
    try {
      defaultBoard.move(2, 0, 0, 0);
      defaultBoard.move(0, 0, 2, 0);
    } catch (IllegalArgumentException e) {
      assertEquals("The slot between the move must contain a marble.",
              e.getMessage());
    }
    setUp();
    try {
      defaultBoard.move(2, 2, 0, 0);
      defaultBoard.move(0, 0, 2, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("The slot between the move must contain a marble.",
              e.getMessage());
      throw e;
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveMessage9() {
    try {
      holeInCenterBoard.move(3, 3, 4, 2);
    } catch (IllegalArgumentException e) {
      assertEquals("Moves must be along the same row or a diagonal.", e.getMessage());
      throw e;
    }
  }


  @Test
  public void testMove1() {
    holeInCenterBoard.move(4, 0, 4, 2);
    assertEquals("        O\n"
            + "       O O\n"
            + "      O O O\n"
            + "     O O O O\n"
            + "    _ _ O O O\n"
            + "   O O O O O O\n"
            + "  O O O O O O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", holeInCenterBoard.getGameState());
  }

  @Test
  public void testMove2() {
    holeInCenterBoard.move(4, 4, 4, 2);
    assertEquals("        O\n"
            + "       O O\n"
            + "      O O O\n"
            + "     O O O O\n"
            + "    O O O _ _\n"
            + "   O O O O O O\n"
            + "  O O O O O O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", holeInCenterBoard.getGameState());
  }

  @Test
  public void testMove3() {
    holeInCenterBoard.move(2, 2, 4, 2);
    assertEquals("        O\n"
            + "       O O\n"
            + "      O O _\n"
            + "     O O _ O\n"
            + "    O O O O O\n"
            + "   O O O O O O\n"
            + "  O O O O O O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", holeInCenterBoard.getGameState());
  }

  @Test
  public void testMove4() {
    holeInCenterBoard.move(2, 0, 4, 2);
    assertEquals("        O\n"
            + "       O O\n"
            + "      _ O O\n"
            + "     O _ O O\n"
            + "    O O O O O\n"
            + "   O O O O O O\n"
            + "  O O O O O O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", holeInCenterBoard.getGameState());
  }

  @Test
  public void testMove5() {
    holeInCenterBoard.move(6, 2, 4, 2);
    assertEquals("        O\n"
            + "       O O\n"
            + "      O O O\n"
            + "     O O O O\n"
            + "    O O O O O\n"
            + "   O O _ O O O\n"
            + "  O O _ O O O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", holeInCenterBoard.getGameState());
  }

  @Test
  public void testMove6() {
    holeInCenterBoard.move(6, 4, 4, 2);
    assertEquals("        O\n"
            + "       O O\n"
            + "      O O O\n"
            + "     O O O O\n"
            + "    O O O O O\n"
            + "   O O O _ O O\n"
            + "  O O O O _ O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", holeInCenterBoard.getGameState());
  }

  @Test
  public void testOnStartGameOverFalse() {
    assertFalse(new TriangleSolitaireModelImpl().isGameOver());
    assertFalse(new TriangleSolitaireModelImpl(4).isGameOver());
    assertFalse(new TriangleSolitaireModelImpl(2, 1).isGameOver());
    assertFalse(new TriangleSolitaireModelImpl(7, 6, 4).isGameOver());
  }

  @Test
  public void testGameState() {
    MarbleSolitaireModel game1 = new TriangleSolitaireModelImpl(9);
    MarbleSolitaireModel game2 = new TriangleSolitaireModelImpl(4, 3);
    MarbleSolitaireModel game3 = new TriangleSolitaireModelImpl(13, 10, 4);
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", defaultBoard.getGameState());
    assertEquals("        _\n"
            + "       O O\n"
            + "      O O O\n"
            + "     O O O O\n"
            + "    O O O O O\n"
            + "   O O O O O O\n"
            + "  O O O O O O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", game1.getGameState());
    assertEquals("        O\n"
            + "       O O\n"
            + "      O O O\n"
            + "     O O O O\n"
            + "    O O _ O O\n"
            + "   O O O O O O\n"
            + "  O O O O O O O\n"
            + " O O O O O O O O\n"
            + "O O O O O O O O O", holeInCenterBoard.getGameState());
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O _ O", game2.getGameState());
    assertEquals("            O\n"
            + "           O O\n"
            + "          O O O\n"
            + "         O O O O\n"
            + "        O O O O O\n"
            + "       O O O O O O\n"
            + "      O O O O O O O\n"
            + "     O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "   O O O O O O O O O O\n"
            + "  O O O O _ O O O O O O\n"
            + " O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O", game3.getGameState());
  }

  @Test
  public void testScore() {
    int scoreBeforeMoves = defaultBoard.getScore();
    assertEquals(scoreBeforeMoves, 14);
    defaultBoard.move(2, 2, 0, 0);
    assertEquals(scoreBeforeMoves - 1, defaultBoard.getScore());
    defaultBoard.move(2, 0, 2, 2);
    assertEquals(scoreBeforeMoves - 2, defaultBoard.getScore());
    defaultBoard.move(4, 3, 2, 1);
    assertEquals(scoreBeforeMoves - 3, defaultBoard.getScore());
  }

  @Test
  public void testGameOverWin() {
    solveDefaultBoard();
    assertTrue(defaultBoard.isGameOver());
    assertEquals(1, defaultBoard.getScore());
    assertEquals("    O\n"
            + "   _ _\n"
            + "  _ _ _\n"
            + " _ _ _ _\n"
            + "_ _ _ _ _", defaultBoard.getGameState());
  }

  @Test
  public void testGameOverLose() {
    randomMoves();
    assertTrue(defaultBoard.isGameOver());
    assertNotEquals(1, defaultBoard.getScore());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  _ _ O\n"
            + " _ _ _ O\n"
            + "_ O _ _ O", defaultBoard.getGameState());
  }
}
