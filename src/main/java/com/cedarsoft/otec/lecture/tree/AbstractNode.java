package com.cedarsoft.otec.lecture.tree;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public abstract class AbstractNode implements Node {
private final String id;

  protected AbstractNode( String id ) {
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }
}
