package com.cedarsoft.otec.lecture.di.invoices;

import com.cedarsoft.otec.lecture.decorator.Money;
import com.cedarsoft.otec.lecture.di.invoices.printing.DefaultPrinter;
import com.cedarsoft.otec.lecture.di.invoices.printing.InvoicePrintingService;
import org.junit.*;

import java.util.Currency;

import static org.junit.Assert.assertEquals;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ManualTest {
  @Test
  public void testDollar() throws Exception {
    Currency currency = Currency.getInstance( "USD" );
    Money shippingCosts = new Money( 10, 0, currency );
    InvoiceFactory invoiceFactory = new OnlineInvoiceFactory( shippingCosts );
    InvoiceIdGenerator invoiceIdGenerator = new InvoiceIdGenerator();
    DefaultPrinter printer = new DefaultPrinter();
    InvoicePrintingService printingService = new InvoicePrintingService( printer );


    InvoiceManager invoiceManager = new InvoiceManager( invoiceFactory, invoiceIdGenerator, currency, printingService );
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 87.33 USD", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 33.51 USD", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }
}
