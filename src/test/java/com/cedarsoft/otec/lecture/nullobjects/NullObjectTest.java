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

package com.cedarsoft.otec.lecture.nullobjects;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class NullObjectTest {
  private List<Animal> animals;

  @Before
  public void setUp() throws Exception {
    animals = new ArrayList<Animal>();
  }

  @Test
  public void testName() throws Exception {
    animals.add( new Dog( "Hasso" ) );
    animals.add( new Cat( "Mohrli" ) );
    animals.add( new Cat( "Felix" ) );

    System.out.println( "--- Hasso: ---" );
    getAnimal( "Hasso" ).makeSound();

    System.out.println( "--- Mohrli: ---" );
    getAnimal( "Mohrli" ).makeSound();

    System.out.println( "--- Not Existing: ---" );
    getAnimal( "InvalidName" ).makeSound();

    System.out.println( "--- Felix: ---" );
    getAnimal( "Felix" ).makeSound();
  }

  private Animal getAnimal( String name ) {
    for ( Animal animal : animals ) {
      if ( animal.getName().equals( name ) ) {
        return animal;
      }
    }

    return new NullAnimal(); //I don't care if nothing happens. But please do not disturb me.
    //    throw new IllegalArgumentException( "No animal found with the given name" ); //Give me immediate information that something went wrong
  }
}
