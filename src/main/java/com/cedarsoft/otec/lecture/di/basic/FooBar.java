package com.cedarsoft.otec.lecture.di.basic;

/**
* @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
*/
public class FooBar {
  private final String id;

  public FooBar() {
    this.id = "default";
  }

  public FooBar( String id ) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
