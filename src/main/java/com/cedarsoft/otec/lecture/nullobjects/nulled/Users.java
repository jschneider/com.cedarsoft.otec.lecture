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

package com.cedarsoft.otec.lecture.nullobjects.nulled;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Users {
  private List<User> users;

  public List<? extends User> getUsers() {
    return Collections.unmodifiableList( users );
  }

  public void add( User user ) {
    if ( users == null ) {
      users = new ArrayList<User>();
    }
    this.users.add( user );
  }

  public User findUser( String userId ) {
    if ( users != null ) {
      for ( User user : users ) {
        if ( user != null ) {
          String login = user.getLogin();
          if ( login != null ) {
            if ( userId != null ) {
              if ( login.equals( userId ) ) {
                return user;
              }
            }
          }
        }
      }
      return null;
    } else {
      return null;
    }
  }

  public File findDocumentsDirForUser( String id ) {
    User found = findUser( id );
    if ( found == null ) {
      return null;
    } else {
      HomeDir homeDir = found.getHomeDir();
      if ( homeDir == null ) {
        return null;
      } else {
        File documentsDir = homeDir.getDocumentsDir();
        if ( documentsDir == null ) {
          return null;
        } else {
          return documentsDir;
        }
      }
    }
  }
}
