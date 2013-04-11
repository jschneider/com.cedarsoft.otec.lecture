/**
 * Licensed under the GNU General Public License version 2 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.gnu.org/licenses/gpl-2.0.txt
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.cedarsoft.otec.lecture.factory;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class FactoryTest {
  @Test
  public void testHuman() throws Exception {
    Human human = new Human( "Otto Normalverbraucher" );
    assertEquals( "Otto Normalverbraucher", human.getName() );

    try {
      human.fly();
      fail();
    } catch ( UnsupportedOperationException e ) {
      assertEquals( "I can't fly!!!", e.getMessage() );
    }
  }

  @Test
  public void testSuperHuman() throws Exception {
    Human human = new SuperHuman( "Superman" );
    assertEquals( "Superman", human.getName() );

    human.fly();
  }

  @Test
  public void testDefaultFactory() throws Exception {
    HumanFactory factory = new DefaultHumanFactory();
    assertSame( Human.class, factory.createHuman( "Test" ).getClass() );
  }

  @Test
  public void testSuperFactory() throws Exception {
    HumanFactory factory = new SuperHumanFactory();
    assertSame( SuperHuman.class, factory.createHuman( "Test" ).getClass() );
  }

  @Test
  public void testMoreComplex() throws Exception {
    List<Human> population1 = createPopulation( new DefaultHumanFactory() );
    List<Human> population2 = createPopulation( new SuperHumanFactory() );

    System.out.println( "let them fly 1:" );
    letThemFly( population1 );
    System.out.println();
    System.out.println( "let them fly 2" );
    letThemFly( population2 );
  }

  private void letThemFly( List<Human> population ) {
    for ( Human human : population ) {
      System.out.println( "Letting fly: " + human.getName() );
      try {
        human.fly();
        System.out.println( "Flew successfully" );
      } catch ( UnsupportedOperationException ignore ) {
        System.out.println( "Uuuh. He cannot fly!" );
      }
    }
  }

  private List<Human> createPopulation( HumanFactory factory ) {
    List<Human> population = new ArrayList<Human>();
    //Erstellt 10 Menschen
    for ( int i = 0; i < 10; i++ ) {
      population.add( factory.createHuman( "Human No " + i ) );
    }

    return population;
  }
}
