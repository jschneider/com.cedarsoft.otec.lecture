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

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Car {
  private boolean lightsOn;
  private boolean engineRunning;
  private final Door[] doors = {new Door(), new Door(), new Door(), new Door()};

  public boolean areLightsOn() {
    return lightsOn;
  }

  public boolean isEngineRunning() {
    return engineRunning;
  }

  /**
   * Returns the door
   *
   * @param index the index (0..3)
   * @return the door
   */
  public Door getDoor( int index ) {
    return doors[index];
  }

  public Door[] getDoors() {
    return doors;
  }

  public void switchOnLights() throws IllegalStateException {
    if ( lightsOn ) {
      throw new IllegalStateException( "Lights are still on" );
    }
    this.lightsOn = true;
  }

  public void switchOffLights() throws IllegalStateException {
    if ( !lightsOn ) {
      throw new IllegalStateException( "Lights are still off" );
    }
    this.lightsOn = false;
  }

  public void startEngine() throws IllegalStateException {
    if ( engineRunning ) {
      throw new IllegalStateException( "Engine still running" );
    }
    this.engineRunning = true;
  }

  public void stopEngine() throws IllegalStateException {
    if ( !engineRunning ) {
      throw new IllegalStateException( "Engine not running" );
    }
    this.engineRunning = false;
  }


  public static class Door {
    private DoorState state = DoorState.LOCKED;

    public DoorState getState() {
      return state;
    }

    public void unlock() {
      if ( state != DoorState.LOCKED ) {
        throw new IllegalStateException( "door not locked " + state );
      }
      state = DoorState.CLOSED;
    }

    public void open() {
      if ( state != DoorState.CLOSED ) {
        throw new IllegalStateException( "door not closed " + state );
      }
      state = DoorState.OPEN;
    }

    public void close() {
      if ( state != DoorState.OPEN ) {
        throw new IllegalStateException( "door not open " + state );
      }
      state = DoorState.CLOSED;
    }

    public void lock() {
      if ( state != DoorState.CLOSED ) {
        throw new IllegalStateException( "door not closed " + state );
      }
      state = DoorState.LOCKED;
    }
  }
}
