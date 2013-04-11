package com.cedarsoft.otec.lecture.di.invoices;

import com.cedarsoft.otec.lecture.decorator.Money;
import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface InvoiceFactory {
  @Nonnull
  Invoice create( @Nonnull String id, @Nonnull Money amount );
}