package com.cedarsoft.otec.lecture.observer;

import org.junit.*;

import java.util.ConcurrentModificationException;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Problems {
  private InboxObservable inbox;

  @Before
  public void setUp() throws Exception {
    inbox = new InboxObservable();
  }

  @Test(expected = StackOverflowError.class)
  public void testEndless() throws Exception {
    InboxObservable.Listener copyListener = new InboxObservable.Listener() {
      @Override
      public void mailReceived( InboxObservable inbox, Mail mail ) {
        //we create a copy and it to the inbox
        inbox.receive( new Mail( mail.getFrom(), mail.getTo(), mail.getSubject() ) );
      }

      @Override
      public void mailDeleted( InboxObservable inbox, Mail mail ) {
      }
    };

    inbox.addListener( copyListener );
    inbox.receive( new Mail( "from", "to", "subject" ) );
  }

  @Test(expected = ConcurrentModificationException.class)
  public void testConCurrentProblem() throws Exception {
    InboxObservable.Listener waitForFirstMail = new InboxObservable.Listener() {
      @Override
      public void mailReceived( InboxObservable inbox, Mail mail ) {
        System.out.println( "First mail received: " + mail );
        System.out.println( "now going to unregister myself..." );

        inbox.removeListener( this );
      }

      @Override
      public void mailDeleted( InboxObservable inbox, Mail mail ) {
      }
    };

    inbox.addListener( waitForFirstMail );

    inbox.receive( new Mail( "from", "to", "subject" ) );
  }
}
