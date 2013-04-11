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

package com.cedarsoft.otec.lecture.decorator;

import org.junit.*;

import java.util.Currency;

import static org.junit.Assert.assertEquals;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ArticleTest {
  @Test
  public void testSimple() throws Exception {
    Article article = new DefaultArticle( new Money( 7, 33, Currency.getInstance( "EUR" ) ), "Book1" );

    assertEquals( "Book1", article.getDescription() );
    assertEquals( 7.33, article.getPrice().getAmount(), 0 );

    //Sales Tax
    article = new SalesTaxDecorator( article, 0.19 );
    assertEquals( "Book1", article.getDescription() );
    assertEquals( 7.33 * 1.19, article.getPrice().getAmount(), 0.009 );
  }

  @Test
  public void testBargain() throws Exception {
    Article article = new DefaultArticle( new Money( 7, 33, Currency.getInstance( "EUR" ) ), "Book1" );

    //Bargain
    article = new BargainDecorator( article, 0.3 );
    assertEquals( "Book1", article.getDescription() );
    assertEquals( 7.33 * 0.7, article.getPrice().getAmount(), 0.009 );

    //Sales Tax
    article = new SalesTaxDecorator( article, 0.19 );
    assertEquals( "Book1", article.getDescription() );
    assertEquals( 7.33 * 0.7 * 1.19, article.getPrice().getAmount(), 0.009 );
  }
}
