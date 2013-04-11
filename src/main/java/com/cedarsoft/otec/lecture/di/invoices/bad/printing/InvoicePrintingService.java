package com.cedarsoft.otec.lecture.di.invoices.bad.printing;

import com.cedarsoft.otec.lecture.di.invoices.bad.Invoice;
import com.google.inject.Inject;
import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoicePrintingService {
  @Nonnull
  private final Printer printer;

  private InvoicePrintingService() {
    this.printer = new DefaultPrinter();
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

  public static InvoicePrintingService getInstance() {
    return INSTANCE;
  }

  private static final InvoicePrintingService INSTANCE = new InvoicePrintingService();
}
