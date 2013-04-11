package com.cedarsoft.otec.lecture.di.invoices.bad;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ManualTest {
  @Test
  public void testBasic() throws Exception {
    InvoiceManager invoiceManager = new InvoiceManager();
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 77.33 USD", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 23.51 USD", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

  @Ignore
  @Test
  public void testAndNowInEuroWithShipping() throws Exception {
    InvoiceManager invoiceManager = new InvoiceManager();
    //todo: How to set currency?
    //todo: How to change factory?
    //todo: how to enable debugging?

    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 87.33 €", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 33.51 €", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

  @Ignore
  @Test
  public void testMultipleIds() throws Exception {
    InvoiceManager invoiceManager = new InvoiceManager();
    Invoice invoice = invoiceManager.createInvoice( 7, 88 );

    assertEquals( "I1", invoice.getId() ); //warum stimmt das nicht?
  }
}
