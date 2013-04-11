package com.cedarsoft.otec.lecture.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ParentNode extends AbstractNode{
  private final List<Node> children = new ArrayList<Node>();

  public ParentNode( String id ) {
    super( id );
  }

  public void add( Node child ) {
    this.children.add( child );
  }
  
  @Override
  public List<Node> getChildren() {
    return Collections.unmodifiableList( children );
  }
}
