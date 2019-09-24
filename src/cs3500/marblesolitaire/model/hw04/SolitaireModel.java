package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an abstraction of various Marble Solitaire models.
 */

public abstract class SolitaireModel implements MarbleSolitaireModel {
  protected enum CellState {
    MARBLE, EMPTY, INVALID
  }

  protected CellState[][] board;

  private boolean isValidPosition(int row, int col) {
    try {
      return (board[row][col] != CellState.INVALID);
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }

  protected int dimensions() {
    return board.length;
  }

  protected String invalidMoveMsg(int fromRow, int fromCol, int toRow, int toCol) {
    if (!this.isValidPosition(fromRow, fromCol)) {
      return "The 'from' coordinates must be valid.";
    }
    if (!this.isValidPosition(toRow, toCol)) {
      return "The 'to' coordinates must be valid.";
    }
    if (this.board[fromRow][fromCol] != CellState.MARBLE) {
      return "The 'from' slot must have a marble.";
    }
    if (this.board[toRow][toCol] != CellState.EMPTY) {
      return "The 'to' slot must be empty.";
    }
    if (toRow != fromRow && fromCol != toCol) {
      return "The 'to' and 'from' slot must be in the same row or column.";
    }
    if (Math.abs(toRow - fromRow) + Math.abs(toCol - fromCol) != 2) {
      return "The 'to' and 'from' slot must be two units away.";
    }
    return "The slot between the 'to' and 'from' slot must have a marble.";
  }

  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return isValidPosition(fromRow, fromCol)
            && isValidPosition(toRow, toCol)
            && this.board[fromRow][fromCol] == CellState.MARBLE
            && this.board[toRow][toCol] == CellState.EMPTY
            && ((fromRow == toRow && Math.abs(fromCol - toCol) == 2)
            || (fromCol == toCol && Math.abs(fromRow - toRow) == 2))
            && this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] == CellState.MARBLE;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (!isValidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException(invalidMoveMsg(fromRow, fromCol, toRow, toCol));
    }

    board[toRow][toCol] = CellState.MARBLE;
    board[fromRow][fromCol] = CellState.EMPTY;
    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = CellState.EMPTY;
  }

  @Override
  public String getGameState() {
    StringBuilder state = new StringBuilder();
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if (j > (this.board[i].length - 1) / 2 && this.board[i][j] == CellState.INVALID) {
          break;
        } else {
          if (j != 0) {
            state.append(" ");
          }
          switch (this.board[i][j]) {
            case INVALID:
              state.append(" ");
              break;
            case MARBLE:
              state.append("O");
              break;
            case EMPTY:
              state.append("_");
              break;
            default:
              throw new IllegalStateException("Unexpected value: " + this.board[i][j]);
          }
        }
      }
      if (i != this.board.length - 1) {
        state.append("\n");
      }
    }
    return state.toString();
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if ((this.board[i][j] == CellState.MARBLE)
                && ((this.isValidMove(i, j, i + 2, j)
                || this.isValidMove(i, j, i - 2, j)
                || this.isValidMove(i, j, i, j + 2)
                || this.isValidMove(i, j, i, j - 2)))) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getScore() {
    int totalMarbles = 0;
    for (CellState[] row : board) {
      for (CellState peg : row) {
        if (peg == CellState.MARBLE) {
          totalMarbles++;
        }
      }
    }
    return totalMarbles;
  }

  public static final class Builder {

  }
}
