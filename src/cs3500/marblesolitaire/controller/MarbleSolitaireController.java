package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the operations offered by the marble solitaire controller.
 */
public interface MarbleSolitaireController {
  /**
   * Play a new game of Marble Solitaire.
   *
   * @param model the model that is used to play the game
   * @throws IllegalArgumentException if the model is null
   * @throws IllegalStateException    if the controller is unable to receive input or transmit
   *                                  output
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException;
}
