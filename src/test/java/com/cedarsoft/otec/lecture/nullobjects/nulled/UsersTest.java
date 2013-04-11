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

import org.junit.*;

import java.io.File;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class UsersTest {
  private Users users;

  @Before
  public void setUp() throws Exception {
    users = new Users();
    users.add( new User( "ms", "Markus Mustermann" ) );
    users.add( new User( null, null ) );
    users.add( null );
    users.add( new User( "guest", "Guest User" ) );
    users.add( new User( "em", "Elsbeth Musterfrau" ) );
    users.add( new User( "johannes", "Johannes Schneider" ) );
  }

  @Test
  public void testListAssUsers() throws Exception {
    if ( users != null ) {
      List<? extends User> userList = users.getUsers();

      if ( userList != null ) {
        for ( User user : userList ) {
          if ( user != null ) {
            String login = user.getLogin();
            if ( login != null ) {
              System.out.println( login + ":" );
            } else {
              System.out.println( "User without a login" );
            }

            HomeDir homeDir = user.getHomeDir();
            if ( homeDir != null ) {
              File baseDir = homeDir.getBaseDir();
              if ( baseDir != null ) {
                System.out.println( "\tBase Dir:" + baseDir.getAbsolutePath() );
              } else {
                System.out.println( "No Base Dir available" );
              }

              File documentsDir = homeDir.getDocumentsDir();
              if ( documentsDir != null ) {
                System.out.println( "\tDocumentsDir: " + documentsDir.getAbsolutePath() );
              } else {
                System.out.println( "No Base dir available" );
              }
            }
          } else {
            System.out.println( "Null user found" );
          }
        }
      } else {
        System.out.println( "No users available" );
      }
    } else {
      System.out.println( "No user object available" );
    }
  }

  @Test
  public void testFindDocumentsDirForUserNotExisting() throws Exception {
    if ( users != null ) {
      File dir = users.findDocumentsDirForUser( "em" );
      if ( dir != null ) {
        System.out.println( "Found dir: " + dir );
      } else {
        System.out.println( "No documents dir found!" );
      }
    }
  }

  @Test
  public void testFindDocumentsDirForUserExisting() throws Exception {
    if ( users != null ) {
      File dir = users.findDocumentsDirForUser( "johannes" );
      if ( dir != null ) {
        System.out.println( "Found dir: " + dir );
      } else {
        System.out.println( "No documents dir found!" );
      }
    }
  }
}
