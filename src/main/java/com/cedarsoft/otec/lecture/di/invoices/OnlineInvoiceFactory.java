package com.cedarsoft.otec.lecture.di.invoices;

import com.cedarsoft.otec.lecture.decorator.Money;
import com.google.inject.Inject;
import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class OnlineInvoiceFactory implements InvoiceFactory {
  @Nonnull
  private final Money shippingCosts;

  @Inject
  public OnlineInvoiceFactory( @ShippingCosts @Nonnull Money shippingCosts ) {
    this.shippingCosts = shippingCosts;
  }

  @Nonnull
  @Override
  public Invoice create( @Nonnull String id, @Nonnull Money amount ) {
    return new Invoice( id, amount.plus( shippingCosts ) );
  }
}
