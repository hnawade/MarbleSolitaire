import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Contains the tests for the {@code MarbleSolitaireModelImpl} implementation.
 */

public class MarbleSolitaireModelImplTest {

  @Test
  public void testDefaultConstructorGameState() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireModelImpl().getGameState());
  }

  @Test
  public void test1ArgConstructorGameState() {
    assertEquals("                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O", new MarbleSolitaireModelImpl(9).getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test1ArgConstructorPosError() {
    new MarbleSolitaireModelImpl(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test1ArgConstructorOddError() {
    new MarbleSolitaireModelImpl(8);
  }

  @Test
  public void test2ArgConstructorGameState() {
    assertEquals("    O O O\n" +
            "    _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireModelImpl(1, 2).getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test2ArgConstructorOffGridError1() {
    new MarbleSolitaireModelImpl(-5, -3).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test2ArgConstructorOffGridError2() {
    new MarbleSolitaireModelImpl(7, 2).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test2ArgConstructorOffGridError3() {
    new MarbleSolitaireModelImpl(0, 1).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test2ArgConstructorOffGridError4() {
    new MarbleSolitaireModelImpl(6, 5).getGameState();
  }

  @Test
  public void test3ArgConstructorGameState() {
    assertEquals("            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O _ O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O",
            new MarbleSolitaireModelImpl(7, 7, 15).getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorOffGridError1() {
    new MarbleSolitaireModelImpl(5, -2, -1).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorOffGridError2() {
    new MarbleSolitaireModelImpl(9, 27, 18).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorOffGridError3() {
    new MarbleSolitaireModelImpl(11, 27, 5).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorOffGridError4() {
    new MarbleSolitaireModelImpl(7, 2, 18).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorOddError1() {
    new MarbleSolitaireModelImpl(-7, 7, 7).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorOddGridError2() {
    new MarbleSolitaireModelImpl(-13, 13, 2).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorPosGridError1() {
    new MarbleSolitaireModelImpl(12, 12, 17).getGameState();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test3ArgConstructorPosGridError2() {
    new MarbleSolitaireModelImpl(4, 2, 5).getGameState();
  }

  @Test
  public void testDefaultGameOver() {
    assertEquals(false, new MarbleSolitaireModelImpl().isGameOver());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    new MarbleSolitaireModelImpl().move(0, 3, 0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove2() {
    new MarbleSolitaireModelImpl().move(0, 3, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    new MarbleSolitaireModelImpl().move(0, 3, -2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    new MarbleSolitaireModelImpl().move(0, 3, 2, 3);
  }

  @Test
  public void testMove() {
    MarbleSolitaireModelImpl marbleGame = new MarbleSolitaireModelImpl();
    marbleGame.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", marbleGame.getGameState());
  }
}
