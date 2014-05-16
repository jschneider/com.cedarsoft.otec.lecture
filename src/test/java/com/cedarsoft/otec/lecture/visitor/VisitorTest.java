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

package com.cedarsoft.otec.lecture.visitor;

import com.cedarsoft.otec.lecture.composite.ArithmeticExpression;
import com.cedarsoft.otec.lecture.composite.CompositeOperand;
import com.cedarsoft.otec.lecture.composite.Minus;
import com.cedarsoft.otec.lecture.composite.Multiply;
import com.cedarsoft.otec.lecture.composite.NumericOperand;
import com.cedarsoft.otec.lecture.composite.Plus;
import com.cedarsoft.otec.lecture.composite.SumOperand;
import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class VisitorTest {
  private ArithmeticExpression compositeOperand;

  @Before
  public void setUp() throws Exception {
    compositeOperand = new CompositeOperand(
      new NumericOperand( 2 ),
      new Minus(),
      new CompositeOperand(
        new CompositeOperand(
          new NumericOperand( 3 ),
          new Plus(),
          new SumOperand(
            new NumericOperand( 17 ), new NumericOperand( 3 ), new NumericOperand( 12 ) ) ),
        new Multiply(),
        new NumericOperand( 12 ) )
    );
  }

  @Test
  public void testManually() throws Exception {
    printType( compositeOperand );
    printType( new NumericOperand( 2 ) );
    printType( new SumOperand( new NumericOperand( 17 ), new NumericOperand( 3 ), new NumericOperand( 12 ) ) );
  }

  /**
   * This is ugly! This is a really bad example!
   *
   * @param arithmeticExpression the arithmetic expression
   */
  private void printType( ArithmeticExpression arithmeticExpression ) {
    if ( arithmeticExpression instanceof CompositeOperand ) {
      System.out.println( "A CompositeOperand with that operator: " + ( ( CompositeOperand ) arithmeticExpression ).getOperator() );
    } else if ( arithmeticExpression instanceof NumericOperand ) {
      System.out.println( "A NumericOperand: " + ( ( NumericOperand ) arithmeticExpression ).getValue() );
    } else if ( arithmeticExpression instanceof SumOperand ) {
      System.out.println( "A SumOperand with " + ( ( SumOperand ) arithmeticExpression ).getSummands().size() + " summands" );
    } else {
      System.out.println( "Unknown type!" );
    }
  }

  @Test
  public void testIt() {
    SimpleVisitor visitor = new SimpleVisitor();

    compositeOperand.accept(visitor);
    new NumericOperand( 2 ).accept(visitor);
    new SumOperand( new NumericOperand( 17 ), new NumericOperand( 3 ), new NumericOperand( 12 ) ).accept(visitor);
  }
}
