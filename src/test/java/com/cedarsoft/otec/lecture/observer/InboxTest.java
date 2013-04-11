package com.cedarsoft.otec.lecture.observer;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class InboxTest {
  @Test
  public void testSimple() throws Exception {
    Inbox inbox = new Inbox();
    assertEquals( 0, inbox.getMails().size() );

    inbox.receive( new Mail( "Hans", "Peter", "Hallo Peter" ) );
    assertEquals( 1, inbox.getMails().size() );
    assertEquals( "Hallo Peter", inbox.getMails().get( 0 ).getSubject() );

    inbox.receive( new Mail( "Hans2", "Peter2", "Hallo Peter2" ) );
    assertEquals( 2, inbox.getMails().size() );

    inbox.delete( inbox.getMails().get( 0 ) );
    assertEquals( 1, inbox.getMails().size() );
    assertEquals( "Hallo Peter2", inbox.getMails().get( 0 ).getSubject() );
  }

  @Test
  public void testListener() throws Exception {
    InboxObservable inbox = new InboxObservable();
    assertEquals( 0, inbox.getMails().size() );

    inbox.addListener( new InboxObservable.Listener() {
      @Override
      public void mailReceived( InboxObservable inbox, Mail mail ) {
        System.out.println( "--> New Mail received: " + mail.getSubject() );
      }

      @Override
      public void mailDeleted( InboxObservable inbox, Mail mail ) {
        System.out.println( "--> Mail deleted: " + mail.getSubject() );
      }
    } );


    inbox.receive( new Mail( "Hans", "Peter", "Hallo Peter" ) );
    inbox.receive( new Mail( "Hans2", "Peter2", "Hallo Peter2" ) );
    inbox.delete( inbox.getMails().get( 0 ) );

    //deleting non existant mail
    inbox.delete( new Mail( "does", "not", "exist" ) );
  }

  @Test
  public void testMailBackup() throws Exception {
    InboxObservable inbox = new InboxObservable();

    MailBackup backup = new MailBackup();
    inbox.addListener( new BackupListener( backup ) );

    assertEquals( 0, inbox.getMails().size() );
    assertEquals( 0, backup.getMails().size() );

    inbox.receive( new Mail( "a", "b", "1" ) );
    inbox.receive( new Mail( "a", "b", "2" ) );
    inbox.receive( new Mail( "a", "b", "3" ) );
    inbox.receive( new Mail( "a", "b", "4" ) );

    assertEquals( 4, inbox.getMails().size() );
    assertEquals( 4, backup.getMails().size() );

    inbox.delete( inbox.getMails().get( 0 ) );
    inbox.delete( inbox.getMails().get( 0 ) );
    inbox.delete( inbox.getMails().get( 0 ) );
    inbox.delete( inbox.getMails().get( 0 ) );

    assertEquals( 0, inbox.getMails().size() );
    assertEquals( 4, backup.getMails().size() );

    inbox.receive( new Mail( "a", "b", "5" ) );

    assertEquals( 1, inbox.getMails().size() );
    assertEquals( 5, backup.getMails().size() );
  }
}
