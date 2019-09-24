package cs3500.marblesolitaire.model.hw04;

import java.util.Arrays;

/**
 * Represents an implementation of {@code MarbleSolitaireModel} interface where the board is in the
 * shape of a triangle.
 */

public class TriangleSolitaireModelImpl extends SolitaireModel {

  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
  }

  public TriangleSolitaireModelImpl(int dimensions) {
    this(dimensions, 0, 0);
  }

  public TriangleSolitaireModelImpl(int row, int col) {
    this(5, row, col);
  }

  /**
   * Constructs a triangle shaped board with the specified dimension and empty slot at the specified
   * slot.
   *
   * @param dimensions number of rows in the triangle
   * @param row        the row of the empty slot
   * @param col        the column of the empty slot
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col) {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("The dimensions of the board must be positive!");
    }
    board = new CellState[dimensions][];

    if (!onBoard(row, col)) {
      throw new IllegalArgumentException("The specified slot is not on the board!");
    }
    for (int i = 0; i < dimensions(); i++) {
      board[i] = new CellState[i + 1];
      Arrays.fill(board[i], CellState.MARBLE);
    }
    board[row][col] = CellState.EMPTY;
  }

  private boolean onBoard(int row, int col) {
    return row >= 0 && col >= 0 && row < dimensions() && col <= row;
  }

  protected String invalidMoveMsg(int fRow, int fCol, int tRow, int tCol) {
    if (!onBoard(fRow, fCol)) {
      return "The 'from' coordinates must be on the board.";
    }

    if (!onBoard(tRow, tCol)) {
      return "The 'to' coordinates must be on the board.";
    }

    if (board[fRow][fCol] != CellState.MARBLE) {
      return "The 'from' slot must contain a marble.";
    }

    if (board[tRow][tCol] != CellState.EMPTY) {
      return "The 'to' slot must be empty.";
    }

    if (fRow == tRow) {
      if (Math.abs(fCol - tCol) != 2) {
        return "Moves along the same row should be two columns away.";
      }
      return "The slot between the move must contain a marble.";
    }

    if (fCol == tCol || ((fCol - fRow) == (tCol - tRow))) {
      if (Math.abs(fRow - tRow) != 2) {
        return "Moves along diagonals should be two rows away.";
      }
      return "The slot between the move must contain a marble.";
    }
    return "Moves must be along the same row or a diagonal.";
  }

  protected boolean isValidMove(int fRow, int fCol, int tRow, int tCol) {
    return onBoard(fRow, fCol) && onBoard(tRow, tCol)
            && (((Math.abs(fRow - tRow) == 2) && ((fRow - fCol == tRow - tCol) || fCol == tCol))
            || ((Math.abs(fCol - tCol) == 2) && fRow == tRow))
            && board[fRow][fCol] == CellState.MARBLE
            && board[tRow][tCol] == CellState.EMPTY
            && board[(tRow + fRow) / 2][(tCol + fCol) / 2] == CellState.MARBLE;
  }

  @Override
  public String getGameState() {
    StringBuilder gameState = new StringBuilder();
    for (int i = 0; i < dimensions(); i++) {
      for (int j = 1; j < dimensions() - i; j++) {
        gameState.append(" ");
      }
      for (int j = 0; j <= i; j++) {
        if (board[i][j] == CellState.MARBLE) {
          gameState.append("O");
        } else {
          gameState.append("_");
        }
        if (j != i) {
          gameState.append(" ");
        }
      }

      if (i + 1 < dimensions()) {
        gameState.append("\n");
      }
    }
    return gameState.toString();
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < dimensions(); i++) {
      for (int j = 0; j <= i; j++) {
        if (this.board[i][j] == CellState.MARBLE
                && ((isValidMove(i, j, i, j + 2))
                || (isValidMove(i, j, i, j - 2))
                || (isValidMove(i, j, i + 2, j + 2))
                || (isValidMove(i, j, i - 2, j - 2))
                || (isValidMove(i, j, i + 2, j))
                || (isValidMove(i, j, i - 2, j)))) {
          return false;
        }
      }
    }
    return true;
  }
}
