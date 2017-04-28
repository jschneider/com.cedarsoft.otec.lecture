package com.cedarsoft.otec.lecture.decorator.coffee;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class WhipDecorator implements Coffee {
  protected final Coffee decoratedCoffee;

  public WhipDecorator(Coffee decoratedCoffee ) {
    this.decoratedCoffee = decoratedCoffee;
  }

  @Override
  public double getCost() {
    return decoratedCoffee.getCost() + 0.7;
  }

  @Override
  public String getIngredients() {
    return decoratedCoffee.getIngredients() + ", " + "Whip";
  }
}