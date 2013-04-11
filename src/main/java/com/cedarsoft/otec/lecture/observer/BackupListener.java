package com.cedarsoft.otec.lecture.observer;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class BackupListener implements InboxObservable.Listener {
  private final MailBackup backup;

  public BackupListener( MailBackup backup ) {
    this.backup = backup;
  }

  @Override
  public void mailReceived( InboxObservable inbox, Mail mail ) {
    backup.addMail( mail );
  }

  @Override
  public void mailDeleted( InboxObservable inbox, Mail mail ) {
    //we do not delete mails from our backup
  }
}
