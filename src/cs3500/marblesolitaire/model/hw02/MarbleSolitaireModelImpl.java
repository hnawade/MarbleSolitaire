package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.SolitaireModel;

/**
 * This is one particular implementation of the {@code MarbleSolitaireModel} interface.
 */

public class MarbleSolitaireModelImpl extends SolitaireModel {

  private int armThickness;

  /**
   * Defualt constructor creates a board of arm thickness 3 with the empty slot in the middle.
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Creates a board of arm thickness 3 with the empty slot at the given coordinates.
   *
   * @param sRow The row number of the empty slot.
   * @param sCol The column number of the empty slot
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Creates a board of given arm thickness with an empty slot at the center.
   *
   * @param armThickness The thickness of each arm
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    this(armThickness, (3 * armThickness - 3) / 2, (3 * armThickness - 3) / 2);
  }

  /**
   * Creates a board with the given arm thickness and an empty slot at the given coordinates.
   *
   * @param armThickness The thickness of each arm
   * @param sRow         The row number of the empty slot
   * @param sCol         The column number of the empty slot
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    if (armThickness < 0) {
      throw new IllegalArgumentException("The specified arm thickness is negative");
    }
    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("The specified arm thickness is not odd");
    }
    this.armThickness = armThickness;
    this.initBoard(sRow, sCol);
  }

  private void initBoard(int sRow, int sCol) {
    this.board = new CellState[3 * armThickness - 2][3 * armThickness - 2];
    if (!onBoard(sRow, sCol)) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%d,%d)",
              sRow, sCol));
    }
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if (!onBoard(i, j)) {
          this.board[i][j] = CellState.INVALID;
        } else {
          this.board[i][j] = CellState.MARBLE;
        }
      }
    }
    this.board[sRow][sCol] = CellState.EMPTY;
  }


  private boolean onBoard(int r, int c) {
    return !((Math.abs((this.dimensions() - 1) / 2 - r) > (this.armThickness - 1) / 2)
            && (Math.abs((this.dimensions() - 1) / 2 - c) > (this.armThickness - 1) / 2))
            && r >= 0
            && c >= 0
            && r < this.dimensions()
            && c < this.dimensions();
  }
}
