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

package com.cedarsoft.otec.lecture.composite;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ArithmeticExpressionTest {
  @Test
  public void testIt() {
    CompositeOperand compositeOperand = new CompositeOperand( new NumericOperand( 7 ), new Plus(), new NumericOperand( 3 ) );
    assertEquals( 10, compositeOperand.evaluate(), 0 );
  }

  @Test
  public void testFormula() {
    ArithmeticExpression expression = new CompositeOperand(
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

    assertEquals( -418, expression.evaluate(), 0 );
    assertEquals( "(2.0-((3.0+(17.0+3.0+12.0))*12.0))", expression.toString() );
  }


  @Test
  public void testSumOperand() throws Exception {
    SumOperand operand = new SumOperand( new NumericOperand( 2 ), new NumericOperand( 7 ), new NumericOperand( 12 ) );
    assertEquals( 21, operand.evaluate(), 0 );
    assertEquals( "(2.0+7.0+12.0)", operand.toString() );
  }
}
