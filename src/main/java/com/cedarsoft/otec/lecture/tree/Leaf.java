package com.cedarsoft.otec.lecture.tree;

import java.util.Collections;
import java.util.List;

/**
 * Diese Klasse repräsentiert ein Blatt.
 * Sie wird nicht wirklich benötigt, da sie ein Spezialfall von ParentNode ist. Daher kann sie - je nach Umständen häufig eingespart werden.
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Leaf extends AbstractNode{
  public Leaf( String id ) {
    super( id );
  }

  @Override
  public List<Node> getChildren() {
    return Collections.emptyList();
  }
}
