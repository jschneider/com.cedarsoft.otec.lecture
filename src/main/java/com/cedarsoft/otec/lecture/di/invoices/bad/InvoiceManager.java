package com.cedarsoft.otec.lecture.di.invoices.bad;

import com.cedarsoft.otec.lecture.decorator.Money;
import com.cedarsoft.otec.lecture.di.invoices.bad.printing.InvoicePrintingService;
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
  private final Currency currency = Currency.getInstance( "USD" );

  @Nonnull
  public Invoice createInvoice( int full, int cents ) {
    String newId = InvoiceIdGenerator.getInstance().createNewId();
    Invoice invoice = new DefaultInvoiceFactory().create( newId, new Money( full, cents, currency ) );
    this.invoices.add( invoice );
    return invoice;
  }

  @Nonnull
  public List<? extends Invoice> getInvoices() {
    return Collections.unmodifiableList( invoices );
  }

  @Nonnull
  public InvoicePrintingService getPrintingService() {
    return InvoicePrintingService.getInstance();
  }

  public void printInvoices() {
    for ( Invoice invoice : invoices ) {
      getPrintingService().print( invoice );
    }
  }
}
