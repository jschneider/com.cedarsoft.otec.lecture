package com.cedarsoft.otec.lecture.di.invoices;

import com.cedarsoft.otec.lecture.decorator.Money;
import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Invoice {
  @Nonnull
  private final Money amount;
  @Nonnull
  private String id;

  public Invoice( @Nonnull String id, @Nonnull Money amount ) {
    this.id = id;
    this.amount = amount;
  }

  @Nonnull
  public Money getAmount() {
    return amount;
  }

  @Nonnull
  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return id + ": " + amount;
  }
}
