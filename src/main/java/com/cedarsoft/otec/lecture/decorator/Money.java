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

import java.util.Currency;
import java.util.Locale;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Money {
  private final int cents;
  private final Currency currency;

  public Money( int full, int cents, Currency currency ) {
    this( full * 100 + cents, currency );
  }

  public Money( int cents, Currency currency ) {
    this.cents = cents;
    this.currency = currency;
  }

  public int getCents() {
    return cents;
  }

  public Money plus( Money money ) {
    ensureCurrencyFits( money );
    return new Money( cents + money.getCents(), currency );
  }

  public Money minus( Money money ) {
    ensureCurrencyFits( money );
    return new Money( cents - money.getCents(), currency );
  }

  private void ensureCurrencyFits( Money money ) {
    if ( money.getCurrency() != currency ) {
      throw new IllegalArgumentException( "Invalid currency. Was <" + money.getCurrency() + "> but expected <" + currency + ">" );
    }
  }

  public Currency getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return cents / 100.0 + " " + currency.toString();
  }

  public String format( Locale locale ) {
    //todo this should/could be done using NumberFormat
    return cents / 100.0 + currency.getSymbol( locale );
  }

  public String format() {
    return format( Locale.getDefault() );
  }

  public double getAmount() {
    return cents / 100.0;
  }
}
