package com.cedarsoft.otec.lecture.abstractfactory;

import java.awt.Color;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public abstract class ColoredPiece implements Piece {
  protected final Color color;

  protected ColoredPiece( Color color ) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public String getColorAsString() {
    return "#" + getColor().getRed() + " " + getColor().getGreen() + " " + getColor().getBlue();
  }
}
