package com.cedarsoft.otec.lecture.di.invoices.printing;

import com.cedarsoft.otec.lecture.di.invoices.Invoice;
import com.google.inject.Inject;
import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoicePrintingService {
  @Nonnull
  private final Printer printer;

  @Inject
  public InvoicePrintingService( @Nonnull Printer printer ) {
    this.printer = printer;
  }

  @Nonnull
  public Printer getPrinter() {
    return printer;
  }

  public void print( @Nonnull Invoice invoice ) {
    //do some magic/preparation/...
    //....

    String invoiceAsString = "Printing " + invoice.getId() + ": " + invoice.getAmount();
    printer.print( invoiceAsString );
  }
}
