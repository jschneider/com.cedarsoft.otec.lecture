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

import java.io.FileNotFoundException;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class User {
  @Nonnull
  private final String login;
  @Nonnull
  private final String name;

  @Nonnull
  private final HomeDir homeDir;

  public User( @Nonnull String login, @Nonnull String name ) throws FileNotFoundException {
    Preconditions.checkNotNull( login );
    Preconditions.checkNotNull( name );
    this.login = login;
    this.name = name;
    this.homeDir = new HomeDir( login );
  }

  @Nonnull
  public String getLogin() {
    return login;
  }

  @Nonnull
  public String getName() {
    return name;
  }

  @Nonnull
  public HomeDir getHomeDir() {
    return homeDir;
  }
}
