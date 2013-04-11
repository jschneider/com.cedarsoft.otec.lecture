package com.cedarsoft.otec.lecture.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class MailBackup {
  private final List<Mail> mails = new ArrayList<Mail>();

  public void addMail( Mail mail ) {
    this.mails.add( mail );
  }

  public List<? extends Mail> getMails() {
    return Collections.unmodifiableList( mails );
  }
}
