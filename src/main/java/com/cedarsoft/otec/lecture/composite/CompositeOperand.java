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

import com.cedarsoft.otec.lecture.visitor.ArithmeticExpressionVisitor;

/**
 * Composite Operand that consists of two expressions and one operator
 *
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class CompositeOperand implements ArithmeticExpression {
  private final ArithmeticExpression first;
  private final Operator operator;
  private final ArithmeticExpression second;

  public CompositeOperand( ArithmeticExpression first, Operator operator, ArithmeticExpression second ) {
    this.first = first;
    this.operator = operator;
    this.second = second;
  }

  public ArithmeticExpression getFirst() {
    return first;
  }

  public Operator getOperator() {
    return operator;
  }

  public ArithmeticExpression getSecond() {
    return second;
  }

  @Override
  public double evaluate() {
    return operator.apply( first.evaluate(), second.evaluate() );
  }

  @Override
  public String toString() {
    return "(" + first.toString() + operator.toString() + second.toString() + ")";
  }

  @Override
  public void accept(ArithmeticExpressionVisitor visitor) {
    visitor.visitCompositeOperand( this );
  }
}
