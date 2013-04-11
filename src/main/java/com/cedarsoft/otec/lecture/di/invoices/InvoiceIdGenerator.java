package com.cedarsoft.otec.lecture.di.invoices;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InvoiceIdGenerator {
  private int lastId;

  public String createNewId() {
    lastId++;
    return "I" + lastId;
  }
}
