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

import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
@Ignore //this test should be ignored, because it depends on an existing directory (/home/johannes)
public class UsersTest {
  private Users users;

  @Before
  public void setUp() throws Exception {
    users = new Users();
    users.add( new User( "johannes", "Johannes Schneider" ) );
  }

  @Test
  public void testInitializeInvalid() throws Exception {
    try {
      users.add( new User( "ms", "Markus Mustermann" ) );
      fail( "Where is the Exception" );
    } catch ( Exception e ) {
    }

    try {
      users.add( new User( null, null ) );
      fail( "Where is the Exception" );
    } catch ( Exception ignore ) {
    }

    try {
      users.add( null );
      fail( "Where is the Exception" );
    } catch ( Exception e ) {
    }
  }

  @Test
  public void testListAssUsers() throws Exception {
    List<? extends User> userList = users.getUsers();

    for ( User user : userList ) {
      String login = user.getLogin();
      System.out.println( login + ":" );

      HomeDir homeDir = user.getHomeDir();
      File baseDir = homeDir.getBaseDir();
      System.out.println( "\tBase Dir:" + baseDir.getAbsolutePath() );

      File documentsDir = homeDir.getDocumentsDir();
      System.out.println( "\tDocumentsDir: " + documentsDir.getAbsolutePath() );
    }
  }

  @Test
  public void testFindDocumentsDirForUser() throws Exception {
    try {
      File dir = users.findUser( "em" ).getHomeDir().getDocumentsDir();
      System.out.println( "Found dir " + dir );
    } catch ( UserNotFoundException e ) {
      System.out.println( "Uups - no user found: " + e.getUserId() );
    } catch ( FileNotFoundException e ) {
      System.out.println( "File not found... " + e.getMessage() );
    }
  }

  @Test
  public void testFindDocumentsDirForUserExisting() throws Exception {
    try {
      File dir = users.findUser( "johannes" ).getHomeDir().getDocumentsDir();
      System.out.println( "Found dir " + dir );
    } catch ( UserNotFoundException e ) {
      System.out.println( "Uups - no user found: " + e.getUserId() );
    } catch ( FileNotFoundException e ) {
      System.out.println( "File not found... " + e.getMessage() );
    }
  }
}
