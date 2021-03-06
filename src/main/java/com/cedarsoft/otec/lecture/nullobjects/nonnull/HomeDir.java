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

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class HomeDir {
  @Nonnull
  private final File baseDir;

  public HomeDir( @Nonnull String userName ) throws FileNotFoundException {
    Preconditions.checkNotNull( userName );
    baseDir = new File( "/home/" + userName );
    if ( !baseDir.isDirectory() ) {
      throw new FileNotFoundException( "BaseDir not found at " + baseDir.getAbsolutePath() );
    }
  }

  @Nonnull
  public File getBaseDir() {
    return baseDir;
  }

  @Nonnull
  public File getDocumentsDir() throws FileNotFoundException {
    File dir = new File( baseDir, "documents" );
    if ( !dir.isDirectory() ) {
      throw new FileNotFoundException( "not documents dir found at " + dir.getAbsolutePath() );
    }
    return dir;
  }
}
