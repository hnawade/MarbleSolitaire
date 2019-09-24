package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

/**
 * Represents the class that contains the main function.
 */
public final class MarbleSolitaire {

  private static MarbleSolitaireController gameController =
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),
                  System.out);

  /**
   * The entry point for the game.
   *
   * @param args command line arguments
   */

  public static void main(String[] args) {
    gameController.playGame(getGame(args));
  }

  private static MarbleSolitaireModel getGame(String[] args) {
    String shape = "";
    boolean hasSize = false;
    boolean hasCoordinates = false;
    int size = 0;
    int row = 0;
    int col = 0;

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case ("english"):
        case ("european"):
        case ("triangular"):
          shape = args[i];
          break;
        case ("-size"):
          i++;
          try {
            size = Integer.parseInt(args[i]);
            hasSize = true;
          } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please specify the size after the '-size' keyword");
          } catch (NumberFormatException e) {
            System.out.println("The size of the board must be an integer");
            i--;
          }
          break;
        case ("-hole"):
          i++;
          try {
            row = Integer.parseInt(args[i]);
            i++;
            col = Integer.parseInt(args[i]);
            hasCoordinates = true;
          } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please specify the row and column coordinates after the '-hole' "
                    + "keyword");
          } catch (NumberFormatException e) {
            System.out.println("The row and column coordinates must both be integers");
            i--;
          }
          break;
        default:
          System.out.println("Unrecognized command: " + args[i]);
      }
    }


    switch (shape) {
      case ("english"):
        if (!hasSize) {
          if (!hasCoordinates) {
            return new MarbleSolitaireModelImpl();
          }
          return new MarbleSolitaireModelImpl(row, col);
        }
        if (!hasCoordinates) {
          return new MarbleSolitaireModelImpl(size);
        }
        return new MarbleSolitaireModelImpl(size, row, col);
      case ("triangular"):
        if (!hasSize) {
          if (!hasCoordinates) {
            return new TriangleSolitaireModelImpl();
          }
          return new TriangleSolitaireModelImpl(row, col);
        }
        if (!hasCoordinates) {
          return new TriangleSolitaireModelImpl(size);
        }
        return new TriangleSolitaireModelImpl(size, row, col);
      case ("european"):
        if (!hasSize) {
          if (!hasCoordinates) {
            return new EuropeanSolitaireModelImpl();
          }
          return new EuropeanSolitaireModelImpl(row, col);
        }
        if (!hasCoordinates) {
          return new EuropeanSolitaireModelImpl(size);
        }
        return new EuropeanSolitaireModelImpl(size, row, col);
      default:
        System.out.println("The board shape must be specified");
        throw new IllegalArgumentException("No board shape was specified");
    }
  }
}


