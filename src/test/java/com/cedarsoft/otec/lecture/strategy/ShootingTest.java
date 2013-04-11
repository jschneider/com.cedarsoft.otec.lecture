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

package com.cedarsoft.otec.lecture.strategy;

import org.junit.*;

import java.io.IOException;
import java.text.NumberFormat;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ShootingTest {
  @Test
  public void testSimple() throws Exception {
    System.out.println( "Default:" );
    run( new DefaultShootingStrategy() );
    System.out.println( "\nAggressive:" );
    run( new AggressiveShootingStrategy() );
    System.out.println( "\nPassive" );
    run( new PassiveShootingStrategy() );
  }

  private void run( ShootingStrategy strategy ) {
    printHeader();
    for ( int i = 1; i < 10; i++ ) {
      print( strategy, i / 10.0 );
    }
  }

  public static void main( String[] args ) throws IOException {
    final Player player = new Player( "Didier Drogba", new DefaultShootingStrategy() );

    new Thread( new Runnable() {
      @Override
      public void run() {
        System.out.println( "Starting Game..." );
        printHeader();

        while ( true ) {
          for ( int i = 0; i <= 100; i += 10 ) {
            double expectedSuccessRate = i / 100.0;
            boolean wannaShootWithBetterPlayer = player.wannaShoot( expectedSuccessRate, true );
            boolean wannaShootWithoutBetterPlayer = player.wannaShoot( expectedSuccessRate, false );

            print( expectedSuccessRate, wannaShootWithBetterPlayer, wannaShootWithoutBetterPlayer );

            try {
              Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {
              throw new RuntimeException( e );
            }
          }
        }

      }
    } ).start();

    while ( true ) {
      int read = System.in.read();
      System.in.read(); //skipping the enter key

      switch ( read ) {
        case 'd':
          System.out.println( "Changing Strategy to <Default>" );
          player.setCurrentStrategy( new DefaultShootingStrategy() );
          break;
        case 'a':
          System.out.println( "Changing Strategy to <Aggressive>" );
          player.setCurrentStrategy( new AggressiveShootingStrategy() );
          break;
        case 'p':
          System.out.println( "Changing Strategy to <Passive>" );
          player.setCurrentStrategy( new PassiveShootingStrategy() );
          break;
        default:
          System.out.println( "Those values are allowed: d(efault), a(ggressive), p(assive)" );
      }
    }
  }

  private void print( ShootingStrategy strategy, final double expectedSuccessRate ) {
    boolean result1 = strategy.shoot( expectedSuccessRate, true );
    boolean result2 = strategy.shoot( expectedSuccessRate, false );
    print( expectedSuccessRate, result1, result2 );
  }

  private static void printHeader() {
    System.out.println( "-----  Mit - Ohne (besser positioniertem Spieler" );
  }

  private static void print( double expectedSuccessRate, boolean result1, boolean result2 ) {
    System.out.println( NumberFormat.getPercentInstance().format( expectedSuccessRate ) + ":\t" + result1 + "\t " + result2 );
  }

  @Test
  public void testDummyTest() throws Exception {
  }
}
