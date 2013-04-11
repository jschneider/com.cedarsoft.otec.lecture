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

package com.cedarsoft.otec.lecture.nullobjects.nonnull;

import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Users {
  @Nonnull
  private final List<User> users = new ArrayList<User>();

  @Nonnull
  public List<? extends User> getUsers() {
    return Collections.unmodifiableList( users );
  }

  public void add( @Nonnull User user ) {
    Preconditions.checkNotNull( user );
    this.users.add( user );
  }

  @Nonnull
  public User findUser( @Nonnull String userId ) throws UserNotFoundException {
    for ( User user : users ) {
      String login = user.getLogin();
      if ( login.equals( userId ) ) {
        return user;
      }
    }

    throw new UserNotFoundException( "No user found for id <" + userId + ">" );
  }
}
