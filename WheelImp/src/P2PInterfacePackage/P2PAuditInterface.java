public class P2PAuditInterface extends AuditInterfaceStubBase {
  private void prt(String TeamName, String msg, boolean alert) {
    System.out.print(TeamName);
    System.out.print(" ");
    System.out.print(msg);
    System.out.print(" ");
    if (alert) System.out.println("Alert");
    else System.out.println("  X");
  }

  public void SendLOK(String TeamName, String msg, boolean alert) {
    System.out.println("Login OK  X");
    prt(TeamName, msg, alert);
  }

  public void SendLNOK(String TeamName, String msg, boolean alert) {
    System.out.println("Login NOT OK  X");
    prt(TeamName, msg, alert);
  }

  public void SendEOK(String TeamName, String msg, boolean alert) {
    System.out.println("Encrypt OK  X");
    prt(TeamName, msg, alert);
  }

  public void SendENOK(String TeamName, String msg, boolean alert) {
    System.out.println("Encrypt NOT OK  X");
    prt(TeamName, msg, alert);
  }

  public void SendDOK(String TeamName, String msg, boolean alert) {
    System.out.println("Decrypt OK  X");
    prt(TeamName, msg, alert);
  }

  public void SendDNOK(String TeamName, String msg, boolean alert) {
    System.out.println("Decrypt NOT OK  X");
    prt(TeamName, msg, alert);
  }

  public void FreeText(String TeamName, String msg, boolean alert) {
    System.out.println("FREETEXT  X");
    prt(TeamName, msg, alert);
  }
}
