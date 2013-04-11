package com.cedarsoft.otec.lecture.di.invoices.bad;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceIdGenerator {
  private static InvoiceIdGenerator INSTANCE = new InvoiceIdGenerator();

  public static InvoiceIdGenerator getInstance() {
    return INSTANCE;
  }

  private int lastId;

  public String createNewId() {
    lastId++;
    return "I" + lastId;
  }
}
