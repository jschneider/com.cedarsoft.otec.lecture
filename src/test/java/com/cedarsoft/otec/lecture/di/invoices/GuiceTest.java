package com.cedarsoft.otec.lecture.di.invoices;

import com.cedarsoft.otec.lecture.decorator.Money;
import com.cedarsoft.otec.lecture.di.invoices.printing.DebugPrinter;
import com.cedarsoft.otec.lecture.di.invoices.printing.DefaultPrinter;
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

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class GuiceTest {
  @Ignore
  @Test
  public void testWithoutAnyBindings() throws Exception {
    Injector injector = Guice.createInjector();

    InvoiceManager invoiceManager = injector.getInstance( InvoiceManager.class );
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 77.33 EUR", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 23.51 EUR", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

  @Test
  public void testSimple() throws Exception {
    Injector injector = Guice.createInjector( new AbstractModule() {
      @Override
      protected void configure() {
        bind( Printer.class ).to( DefaultPrinter.class ).in( Singleton.class );
        bind( InvoiceFactory.class ).to( DefaultInvoiceFactory.class ).in( Singleton.class );
        bind( Currency.class ).toInstance( Currency.getInstance( "EUR" ) );
      }
    } );

    InvoiceManager invoiceManager = injector.getInstance( InvoiceManager.class );
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 77.33 EUR", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 23.51 EUR", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

  @Test
  public void testDebug() throws Exception {
    Injector injector = Guice.createInjector( new AbstractModule() {
      @Override
      protected void configure() {
        bind( Printer.class ).toInstance( new DebugPrinter( new DefaultPrinter() ) ); //Changed this to DebugPrinter Delegate!
        bind( InvoiceFactory.class ).to( DefaultInvoiceFactory.class );
        bind( Currency.class ).toInstance( Currency.getInstance( "EUR" ) );
      }
    } );

    InvoiceManager invoiceManager = injector.getInstance( InvoiceManager.class );
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 77.33 EUR", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 23.51 EUR", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

  @Test
  public void testOnline() throws Exception {
    Injector injector = Guice.createInjector( new AbstractModule() {
      @Override
      protected void configure() {
        bind( Printer.class ).to( DefaultPrinter.class ).in( Singleton.class );
        bind( InvoiceFactory.class ).to( OnlineInvoiceFactory.class );
        bind( Currency.class ).toInstance( Currency.getInstance( "EUR" ) );
      }

      @Provides
      @ShippingCosts
      Money shippingCosts( @Nonnull Currency currency ) {
        return new Money( 10, 0, currency );
      }

    } );

    InvoiceManager invoiceManager = injector.getInstance( InvoiceManager.class );
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 87.33 EUR", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 33.51 EUR", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

  @Test
  public void testDollar() throws Exception {
    Injector injector = Guice.createInjector( new AbstractModule() {
      @Override
      protected void configure() {
        bind( Printer.class ).to( DefaultPrinter.class ).in( Singleton.class );
        bind( InvoiceFactory.class ).to( OnlineInvoiceFactory.class );
        bind( Currency.class ).toInstance( Currency.getInstance( "USD" ) );
      }

      @Provides
      @ShippingCosts
      Money shippingCosts( @Nonnull Currency currency ) {
        return new Money( 10, 0, currency );
      }
    } );

    InvoiceManager invoiceManager = injector.getInstance( InvoiceManager.class );
    assertEquals( 0, invoiceManager.getInvoices().size() );

    assertEquals( "I1: 87.33 USD", invoiceManager.createInvoice( 77, 33 ).toString() );
    assertEquals( "I2: 33.51 USD", invoiceManager.createInvoice( 23, 51 ).toString() );
    assertEquals( 2, invoiceManager.getInvoices().size() );

    invoiceManager.printInvoices();
  }

}
