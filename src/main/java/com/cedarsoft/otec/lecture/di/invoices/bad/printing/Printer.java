package com.cedarsoft.otec.lecture.di.invoices.bad.printing;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public interface Printer {
  void print( @Nonnull String invoiceAsString );
}