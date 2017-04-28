package com.cedarsoft.otec.lecture.decorator.coffee;

import org.junit.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class CoffeeTest {
  @Test
  public void testCoffee() throws Exception {
    Coffee coffee = new SimpleCoffee();
    System.out.println( "Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getIngredients() );

    coffee = new SprinklesDecorator( coffee );
    System.out.println( "Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getIngredients() );

    coffee = new MilkDecorator( coffee );
    System.out.println( "Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getIngredients() );

    coffee = new WhipDecorator( coffee );
    System.out.println( "Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getIngredients() );

    // Note that you can also stack more than one decorator of the same type
    coffee = new SprinklesDecorator( coffee );
    System.out.println( "Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getIngredients() );
  }

}
