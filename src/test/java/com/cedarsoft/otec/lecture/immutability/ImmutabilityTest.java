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

package com.cedarsoft.otec.lecture.immutability;

import org.junit.*;

import java.util.Map;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ImmutabilityTest {
  private Book bgb;
  private Book erbarmen;

  @Before
  public void setUp() throws Exception {
    bgb = new Book( "978-3423050012", "Bürgerliches Gesetzbuch BGB" );
    erbarmen = new Book( "978-3423247511", "Erbarmen" );
  }

  @Test
  public void testName() throws Exception {

    ShoppingCart shoppingCart = new ShoppingCart();

    shoppingCart.getEntries().put( bgb, 1 );
    print( shoppingCart );
    shoppingCart.getEntries().put( erbarmen, 3 );
    print( shoppingCart );

    System.out.println( "--- Evil ---" );
    printEvil( shoppingCart );
    System.out.println( "--- /Evil ---" );

    print( shoppingCart );

    System.out.println( "--- SuperEvil ---" );
    superEvil();
    System.out.println( "--- /SuperEvil ---" );

    print( shoppingCart );
  }

  private void print( ShoppingCart shoppingCart ) {
    System.out.println();
    System.out.println( "Einkaufswagen:" );
    System.out.println( "--------------" );
    for ( Map.Entry<Book, Integer> entry : shoppingCart.getEntries().entrySet() ) {
      Book book = entry.getKey();
      int amount = entry.getValue();

      System.out.println( amount + " Stück: " + book.getTitle() + " (" + book.getIsbn() + ")" );
    }
  }

  private void superEvil() {
    erbarmen.setIsbn( "999-999999999" );
    erbarmen.setTitle( "Ein peinlicher Titel" );
  }

  private void printEvil( ShoppingCart shoppingCart ) {
    print( shoppingCart );
    int oldAmount = shoppingCart.getEntries().get( erbarmen );
    shoppingCart.getEntries().put( erbarmen, oldAmount + 1 );
  }
}
