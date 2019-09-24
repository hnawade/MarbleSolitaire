package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an implementation of the {@code MarbleSolitaireController} interface.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable in;
  private final Appendable out;

  /**
   * Constructs a controller with the given input and output fields.
   *
   * @param rd the input stream
   * @param ap the output stream
   * @throws IllegalArgumentException if either rd or ap are null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Neither the Readable nor Appendable object can be null");
    }
    this.in = rd;
    this.out = ap;
  }

  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException,
          IllegalStateException {

    if (model == null) {
      throw new IllegalArgumentException("The model can not be null");
    }

    Scanner scan = new Scanner(in);
    if (!model.isGameOver()) {
      try {
        out.append(String.format("%s\nScore: %d\n", model.getGameState(), model.getScore()));
      } catch (IOException e) {
        throw new IllegalStateException();
      }
    }
    while (!model.isGameOver()) {
      int fromRow;
      int fromCol;
      int toRow;
      int toCol;
      try {
        fromRow = getNextInput(scan);
        fromCol = getNextInput(scan);
        toRow = getNextInput(scan);
        toCol = getNextInput(scan);
      } catch (IllegalStateException e) {
        throw e;
      } catch (Exception e) {
        break;
      }

      try {
        model.move(fromRow, fromCol, toRow, toCol);
        if (model.isGameOver()) {
          break;
        }
        try {
          out.append(String.format("%s\nScore: %d\n", model.getGameState(), model.getScore()));
        } catch (IOException e) {
          throw new IllegalStateException("Error in printing game state");
        }
      } catch (IllegalArgumentException e) {
        try {
          out.append(String.format("Invalid move. Play again. %s\n", e.getMessage()));
        } catch (IOException ex) {
          throw new IllegalStateException("Error in outputting error message");
        }
      }
    }

    if (model.isGameOver()) {
      try {
        out.append(String.format("Game over!\n%s\nScore: %d", model.getGameState(),
                model.getScore()));
      } catch (IOException e) {
        throw new IllegalStateException("Error in outputting game over");
      }
    } else {
      try {
        out.append(String.format("Game quit!\nState of game when quit:\n%s\nScore: %d",
                model.getGameState(),
                model.getScore()));
      } catch (IOException e) {
        throw new IllegalStateException("Error in outputting game quit");
      }
    }
    scan.close();
  }

  private int getNextInput(Scanner scan) throws Exception {
    if (scan.hasNextInt()) {
      int nextInt = scan.nextInt();
      if (nextInt > 0) {
        return nextInt - 1;
      }
      try {
        out.append("Integers can not be negative. Please enter again.\n");
      } catch (IOException ex) {
        throw new IllegalStateException("Error in outputting error message");
      }
      return getNextInput(scan);
    }

    if (!scan.hasNext()) {
      throw new IllegalStateException();
    }

    String input = scan.next();
    if (input.equalsIgnoreCase("q")) {
      throw new Exception("Quit game");
    }
    try {
      out.append("Invalid input. Please enter again.\n");
    } catch (IOException ex) {
      throw new IllegalStateException("Error in outputting error message");
    }
    return getNextInput(scan);
  }
}
