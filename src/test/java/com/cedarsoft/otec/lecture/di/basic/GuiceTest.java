package com.cedarsoft.otec.lecture.di.basic;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class GuiceTest {
  @Test
  public void testBasic() throws Exception {
    //creating a simple injector without any special configuration.
    Injector injector = Guice.createInjector();

    //Get an instance for each class.
    //If those objects are not configured, the default constructor is used
    assertNotNull( injector.getInstance( Foo.class ) );
    assertNotNull( injector.getInstance( Bar.class ) );

    //The returned objects are not the same! Every time a new object is created
    assertNotSame( injector.getInstance( Foo.class ), injector.getInstance( Foo.class ) );
  }

  @Test
  public void testFooBar() throws Exception {
    Injector injector = Guice.createInjector();

    //The default constructor is used
    FooBar fooBar = injector.getInstance( FooBar.class );
    assertNotNull( fooBar );
    assertEquals( "default", fooBar.getId() );
  }

  @Test
  public void testFooBarConfigured() throws Exception {
    Injector injector = Guice.createInjector( new AbstractModule() {
      @Override
      protected void configure() {
        bind( FooBar.class ).toInstance( new FooBar( "myFooBar" ) );
      }
    } );

    //Returns the configured object
    assertEquals( "myFooBar", injector.getInstance( FooBar.class ).getId() );
    //Always returns the same object
    assertSame( injector.getInstance( FooBar.class ), injector.getInstance( FooBar.class ) );
  }

  @Test
  public void testFooFooBar() throws Exception {
    Injector injector = Guice.createInjector();

    SuperObject superObject = injector.getInstance( SuperObject.class );
    assertNotNull( superObject.getFoo() );
    assertNotNull( superObject.getBar() );
    assertNotNull( superObject.getFooBar() );
    assertEquals( "default", superObject.getFooBar().getId() );
  }

  @Test
  public void testFooFooBar2() throws Exception {
    Injector injector = Guice.createInjector( new AbstractModule() {
      @Override
      protected void configure() {
        bind( FooBar.class ).toInstance( new FooBar( "myFooBar" ) );
      }
    } );

    SuperObject superObject = injector.getInstance( SuperObject.class );
    assertNotNull( superObject.getFoo() );
    assertNotNull( superObject.getBar() );
    assertNotNull( superObject.getFooBar() );
    assertEquals( "myFooBar", superObject.getFooBar().getId() );
  }

  @Test
  public void testProviderMethod() throws Exception {
    Injector injector = Guice.createInjector( new AbstractModule() {
      @Override
      protected void configure() {
      }

      @Provides
      FooBar provideFooBar() {
        return new FooBar( "myFooBar" );
      }

    } );

    SuperObject superObject = injector.getInstance( SuperObject.class );
    assertNotNull( superObject.getFoo() );
    assertNotNull( superObject.getBar() );
    assertNotNull( superObject.getFooBar() );
    assertEquals( "myFooBar", superObject.getFooBar().getId() );
  }

}
