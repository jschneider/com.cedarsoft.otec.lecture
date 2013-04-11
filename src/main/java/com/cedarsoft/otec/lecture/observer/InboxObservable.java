package com.cedarsoft.otec.lecture.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InboxObservable {
  private final List<Mail> mails = new ArrayList<Mail>();

  public List<? extends Mail> getMails() {
    return Collections.unmodifiableList( mails );
  }

  public void receive( Mail mail ) {
    this.mails.add( mail );
    for ( Listener listener : listeners ) {
      listener.mailReceived( this, mail );
    }
  }

  public void delete( Mail mail ) {
    if ( this.mails.remove( mail ) ) {
      for ( Listener listener : listeners ) {
        listener.mailDeleted( this, mail );
      }
    }
  }

  private final List<Listener> listeners = new ArrayList<Listener>();

  public void addListener( Listener listener ) {
    this.listeners.add( listener );
  }

  public void removeListener( Listener listener ) {
    this.listeners.remove( listener );
  }

  public interface Listener {
    void mailReceived( InboxObservable inbox, Mail mail );

    void mailDeleted( InboxObservable inbox, Mail mail );
  }

}
