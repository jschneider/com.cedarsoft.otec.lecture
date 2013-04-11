package com.cedarsoft.otec.lecture.decorator.coffee;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class SimpleCoffee implements Coffee {
  @Override
  public double getCost() {
    return 1;
  }

  @Override
  public String getIngredients() {
    return "Coffee";
  }
}