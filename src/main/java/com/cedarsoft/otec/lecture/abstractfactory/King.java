package com.cedarsoft.otec.lecture.abstractfactory;

import java.awt.Color;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class King extends ColoredPiece {
  public King( Color color ) {
    super( color );
  }

  @Override
  public String toString() {
    return "King - " + getColorAsString();
  }
}
