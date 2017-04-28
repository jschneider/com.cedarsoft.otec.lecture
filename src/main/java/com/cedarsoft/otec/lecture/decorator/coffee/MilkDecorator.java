package com.cedarsoft.otec.lecture.decorator.coffee;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class MilkDecorator implements Coffee {
  protected final Coffee decoratedCoffee;

  public MilkDecorator(Coffee decoratedCoffee ) {
    this.decoratedCoffee = decoratedCoffee;
  }

  @Override
  public double getCost() {
    return decoratedCoffee.getCost() + 0.5;
  }

  @Override
  public String getIngredients() {
    return decoratedCoffee.getIngredients() + ", " + "Milk";
  }
}