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

package com.cedarsoft.otec.lecture.command;

import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class CommandsTest {
  @Test
  public void testIt() throws Exception {
    Car car = new Car();
    Driver driver = new Driver();
    printStatus( car );

    System.out.println( "Driver: Start the engine" );
    driver.command( new StartEngineCommand( car ) );
    printStatus( car );

    System.out.println( "Driver: Unlock the door" );
    driver.command( new UnlockDoorCommand( 3, car ) );
    printStatus( car );

    System.out.println( "Driver: Open the door" );
    driver.command( new OpenDoorCommand( 3, car ) );
    printStatus( car );

    System.out.println( "Driver: Close the doors" );
    driver.command( new CloseDoorCommand( 3, car ) );
    printStatus( car );

    System.out.println( "Driver: Switch on lights" );
    driver.command( new SwitchOnLightsCommand( car ) );
    printStatus( car );

    System.out.println( "-------------------" );
    System.out.println( "Now undo..." );
    System.out.println( "-------------------" );
    driver.undo();
    printStatus( car );

    driver.undo();
    printStatus( car );

    driver.undo();
    printStatus( car );

    driver.undo();
    printStatus( car );

    driver.undo();
    printStatus( car );
  }

  private void printStatus( Car car ) {
    System.out.println( "-----------------" );
    System.out.println( "Engine: " + car.isEngineRunning() );
    System.out.println( "Lights: " + car.areLightsOn() );

    StringBuilder builder = new StringBuilder();
    for ( Car.Door door : car.getDoors() ) {
      builder.append( door.getState().name() );
      builder.append( " " );
    }

    System.out.println( "Doors:  " + builder.toString() + "\n" );
  }
}
