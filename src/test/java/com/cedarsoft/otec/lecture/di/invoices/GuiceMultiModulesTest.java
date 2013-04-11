package com.cedarsoft.otec.lecture.di.invoices;

import com.cedarsoft.otec.lecture.decorator.Money;
import com.cedarsoft.otec.lecture.di.invoices.Invoice;
import com.cedarsoft.otec.lecture.di.invoices.InvoiceFactory;
import com.cedarsoft.otec.lecture.di.invoices.InvoiceManager;
import com.cedarsoft.otec.lecture.di.invoices.OnlineInvoiceFactory;
import com.cedarsoft.otec.lecture.di.invoices.ShippingCosts;
import com.cedarsoft.otec.lecture.di.invoices.printing.DebugPrinter;
import com.cedarsoft.otec.lecture.di.invoices.printing.DefaultPrinter;
import com.cedarsoft.otec.lecture.di.invoices.printing.InvoicePrintingService;
import com.cedarsoft.otec.lecture.di.invoices.printing.Printer;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import javax.annotation.Nonnull;
import org.junit.*;

import java.util.Currency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class GuiceMultiModulesTest {
  @Test
  public void testMultiModules() throws Exception {
    Injector injector = Guice.createInjector( new InvoiceModule(), new PrintingModule() );
    //    Injector injector = Guice.createInjector( new InvoiceModule(), new DebugPrintingModule() );

    InvoiceManager invoiceManager = injector.getInstance( InvoiceManager.class );
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 87.33 USD", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 33.51 USD", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

  @Test
  public void testOnlyPrinting() throws Exception {
    Injector injector = Guice.createInjector( new PrintingModule() );
    assertNotNull( injector.getInstance( InvoicePrintingService.class ) );

    //We can create the objects very easily
    injector.getInstance( InvoicePrintingService.class ).print( new Invoice( "test1", new Money( 1, 2, Currency.getInstance( "GBP" ) ) ) );
    injector.getInstance( InvoicePrintingService.class ).print( new Invoice( "test2", new Money( 3, 4, Currency.getInstance( "VEB" ) ) ) );
  }

  private static class InvoiceModule extends AbstractModule {
    @Override
    protected void configure() {
      //Invoice related stuff
      bind( InvoiceFactory.class ).to( OnlineInvoiceFactory.class );
      bind( Currency.class ).toInstance( Currency.getInstance( "USD" ) );
    }

    @Provides
    @ShippingCosts
    Money shippingCosts( @Nonnull Currency currency ) {
      return new Money( 10, 0, currency );
    }
  }

  private static class PrintingModule extends AbstractModule {
    @Override
    protected void configure() {
      //Printing related stuff
      bind( Printer.class ).to( DefaultPrinter.class ).in( Singleton.class );
    }
  }

  private static class DebugPrintingModule extends AbstractModule {
    @Override
    protected void configure() {
      //Printing related stuff
      bind( Printer.class ).toInstance( new DebugPrinter( new DefaultPrinter() ) );
    }
  }
}
