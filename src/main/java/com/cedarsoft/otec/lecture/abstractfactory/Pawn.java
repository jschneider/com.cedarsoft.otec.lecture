package com.cedarsoft.otec.lecture.abstractfactory;

import java.awt.Color;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Pawn extends ColoredPiece {
  public Pawn( Color color ) {
    super( color );
  }

  @Override
  public String toString() {
    return "Pawn - " + getColorAsString();
  }
}
