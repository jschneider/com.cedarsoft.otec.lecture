package com.cedarsoft.otec.lecture.abstractfactory;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class HalmaFactory implements BoardGameFactory {
  @Override
  public Board createBoard() {
    return new HalmaBoard();
  }

  @Override
  public List<? extends Piece> createPieces() {
    List<Piece> pieces = new ArrayList<Piece>();

    pieces.add( new WoodPeg( Color.RED ) );
    pieces.add( new WoodPeg( Color.BLUE ) );
    pieces.add( new WoodPeg( Color.GREEN ) );

    return pieces;
  }

}
