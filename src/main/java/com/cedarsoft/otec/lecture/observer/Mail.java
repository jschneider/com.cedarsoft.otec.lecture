package com.cedarsoft.otec.lecture.observer;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Mail {
  private final String from;
  private final String to;
  private final String subject;

  public Mail( String from, String to, String subject ) {
    this.from = from;
    this.to = to;
    this.subject = subject;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public String getSubject() {
    return subject;
  }
}
