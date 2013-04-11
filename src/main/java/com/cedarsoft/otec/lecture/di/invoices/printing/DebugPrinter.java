package com.cedarsoft.otec.lecture.di.invoices.printing;

import com.google.inject.Inject;
import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class DebugPrinter implements Printer {
  @Nonnull
  private final Printer printer;

  @Inject
  public DebugPrinter( @Nonnull Printer printer ) {
    this.printer = printer;
  }

  @Override
  public void print( @Nonnull String invoiceAsString ) {
    System.out.println( "------------------" );
    System.out.println( " Print called for an invoice..." );
    System.out.println( "------------------" );
    printer.print( invoiceAsString );
    System.out.println( "------------------" );
  }
}
