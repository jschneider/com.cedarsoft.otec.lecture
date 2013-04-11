package com.cedarsoft.otec.lecture.abstractfactory;

import org.junit.*;

import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class BoardGameTest {
  @Test
  public void testChess() throws Exception {
    ChessFactory factory = new ChessFactory();
    produce( factory );
  }

  @Test
  public void testHalma() throws Exception {
    HalmaFactory factory = new HalmaFactory();
    produce( factory );
  }

  private void produce( BoardGameFactory factory ) {
    Board board = factory.createBoard();
    List<? extends Piece> pieces = factory.createPieces();

    System.out.println( "Created a <" + board + "> with" );
    for ( Piece piece : pieces ) {
      System.out.println( "\t-" + piece );
    }
  }
}
