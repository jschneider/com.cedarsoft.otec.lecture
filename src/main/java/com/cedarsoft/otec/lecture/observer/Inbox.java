package com.cedarsoft.otec.lecture.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Inbox {
  private final List<Mail> mails = new ArrayList<Mail>();

  public List<? extends Mail> getMails() {
    return Collections.unmodifiableList( mails );
  }

  public void receive( Mail mail ) {
    this.mails.add( mail );
  }

  public void delete( Mail mail ) {
    this.mails.remove( mail );
  }
}
