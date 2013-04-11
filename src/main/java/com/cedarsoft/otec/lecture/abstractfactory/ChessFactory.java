package com.cedarsoft.otec.lecture.abstractfactory;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ChessFactory implements BoardGameFactory {
  @Override
  public Board createBoard() {
    return new ChessBoard();
  }

  @Override
  public List<? extends Piece> createPieces() {
    List<Piece> pieces = new ArrayList<Piece>();


    pieces.add( new King( Color.WHITE ) );
    for ( int i = 0; i < 8; i++ ) {
      pieces.add( new Pawn( Color.WHITE) );
    }


    pieces.add( new King( Color.BLACK ) );
    for ( int i = 0; i < 8; i++ ) {
      pieces.add( new Pawn( Color.BLACK) );
    }


    return pieces;
  }

}
