package com.cedarsoft.otec.lecture.abstractfactory;

import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface BoardGameFactory {
  Board createBoard();

  List<? extends Piece> createPieces();
}
