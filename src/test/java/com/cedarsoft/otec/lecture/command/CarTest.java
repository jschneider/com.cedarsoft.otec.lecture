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

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class CarTest {
  @Test
  public void testDefault() throws Exception {
    Car car = new Car();
    assertFalse( car.isEngineRunning() );
    assertFalse( car.areLightsOn() );
    assertEquals( DoorState.LOCKED, car.getDoor( 0 ).getState() );
    assertEquals( DoorState.LOCKED, car.getDoor( 1 ).getState() );
    assertEquals( DoorState.LOCKED, car.getDoor( 2 ).getState() );
    assertEquals( DoorState.LOCKED, car.getDoor( 3 ).getState() );
  }

  @Test
  public void testDoors() throws Exception {
    Car car = new Car();
    assertEquals( DoorState.LOCKED, car.getDoor( 0 ).getState() );
    car.getDoor( 0 ).unlock();
    assertEquals( DoorState.CLOSED, car.getDoor( 0 ).getState() );
    car.getDoor( 0 ).open();
    assertEquals( DoorState.OPEN, car.getDoor( 0 ).getState() );
    car.getDoor( 0 ).close();
    assertEquals( DoorState.CLOSED, car.getDoor( 0 ).getState() );
    car.getDoor( 0 ).lock();
    assertEquals( DoorState.LOCKED, car.getDoor( 0 ).getState() );
  }

  @Test
  public void testEngine() throws Exception {
    Car car = new Car();
    assertFalse( car.isEngineRunning() );
    car.startEngine();
    assertTrue( car.isEngineRunning() );

    try {
      car.startEngine();
      fail();
    } catch ( IllegalStateException ignore ) {
    }

    car.stopEngine();
    assertFalse( car.isEngineRunning() );

    try {
      car.stopEngine();
      fail();
    } catch ( IllegalStateException ignore ) {
    }
  }
}
