package cs3500.marblesolitaire.model.hw04;

/**
 * This is an implementation of the {@code MarbleSolitaireModel} interface with a European-Style
 * octagon solitaire board.
 */

public class EuropeanSolitaireModelImpl extends SolitaireModel {
  /**
   * Creates an octagonal board with side length 3 and empty lot in the center.
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs an octagonal board with the given side length and an empty lot in the center.
   *
   * @param sideLength represents the side length of the octagon
   */
  public EuropeanSolitaireModelImpl(int sideLength) {
    this(sideLength, (sideLength * 3 - 3) / 2, (sideLength * 3 - 3) / 2);
  }

  /**
   * Constructs an octagonal board with side length 3 and the specified empty slot.
   *
   * @param row the row of the empty slot
   * @param col the column of the empty slot
   */
  public EuropeanSolitaireModelImpl(int row, int col) {
    this(3, row, col);
  }

  /**
   * Constructs an octagonal board with the given specifications.
   *
   * @param sideLength the side length of the octagon
   * @param row        the row of the empty slot
   * @param col        the column of the empty slot
   */
  public EuropeanSolitaireModelImpl(int sideLength, int row, int col) {
    if (sideLength <= 0) {
      throw new IllegalArgumentException("The side length of the board must be positive");
    }
    if (sideLength % 2 == 0) {
      throw new IllegalArgumentException("The side length of the board must be odd");
    }
    this.board = new CellState[sideLength * 3 - 2][sideLength * 3 - 2];
    if ((row + col < sideLength - 1)
            || (row > col + 2 * sideLength - 2)
            || (row + col >= 5 * sideLength - 4)
            || (col > row + 2 * sideLength - 2)
            || row < 0
            || col < 0
            || row >= this.board.length
            || col >= this.board.length) {
      throw new IllegalArgumentException("The specified slot is not on the board");
    }
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if ((i + j < sideLength - 1)
                || (i > j + 2 * sideLength - 2)
                || (i + j >= 5 * sideLength - 4)
                || (j > i + 2 * sideLength - 2)
                || i < 0
                || j < 0
                || i >= this.board.length
                || j >= this.board.length) {
          this.board[i][j] = CellState.INVALID;
        } else {
          this.board[i][j] = CellState.MARBLE;
        }
      }
    }
    this.board[row][col] = CellState.EMPTY;
  }
}
