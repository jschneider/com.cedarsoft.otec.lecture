package com.cedarsoft.otec.lecture.di.basic;

import com.google.inject.Inject;

/**
* @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
*/
public class SuperObject {
  private final Foo foo;
  private final Bar bar;
  private final FooBar fooBar;

  @Inject
  public SuperObject( Foo foo, Bar bar, FooBar fooBar ) {
    this.foo = foo;
    this.bar = bar;
    this.fooBar = fooBar;
  }

  public Foo getFoo() {
    return foo;
  }

  public Bar getBar() {
    return bar;
  }

  public FooBar getFooBar() {
    return fooBar;
  }
}
