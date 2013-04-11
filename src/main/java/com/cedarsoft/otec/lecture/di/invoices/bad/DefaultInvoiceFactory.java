package com.cedarsoft.otec.lecture.di.invoices.bad;

import com.cedarsoft.otec.lecture.decorator.Money;
import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DefaultInvoiceFactory implements InvoiceFactory {
  @Nonnull
  @Override
  public Invoice create( @Nonnull String id, @Nonnull Money amount ) {
    return new Invoice( id, amount );
  }
}
