package com.cedarsoft.otec.lecture.di.invoices;

import com.cedarsoft.otec.lecture.decorator.Money;
import com.cedarsoft.otec.lecture.di.invoices.printing.InvoicePrintingService;
import com.google.inject.Inject;
import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceManager {
  @Nonnull
  private final List<Invoice> invoices = new ArrayList<Invoice>();
  @Nonnull
  private final InvoiceFactory invoiceFactory;
  @Nonnull
  private final InvoiceIdGenerator invoiceIdGenerator;
  @Nonnull
  private final Currency currency;
  @Nonnull
  private final InvoicePrintingService printingService;

  @Inject
  public InvoiceManager( @Nonnull InvoiceFactory invoiceFactory, @Nonnull InvoiceIdGenerator invoiceIdGenerator, @Nonnull Currency currency, @Nonnull InvoicePrintingService printingService ) {
    this.invoiceFactory = invoiceFactory;
    this.invoiceIdGenerator = invoiceIdGenerator;
    this.currency = currency;
    this.printingService = printingService;
  }

  @Nonnull
  public Invoice createInvoice( int full, int cents ) {
    Invoice invoice = invoiceFactory.create( invoiceIdGenerator.createNewId(), new Money( full, cents, currency ) );
    this.invoices.add( invoice );
    return invoice;
  }

  @Nonnull
  public List<? extends Invoice> getInvoices() {
    return Collections.unmodifiableList( invoices );
  }

  public void printInvoices() {
    for ( Invoice invoice : invoices ) {
      printingService.print( invoice );
    }
  }
}
