// import EncryptorSubsystem.EncryptorFacade;
// import FileInterfacePackage.BlackFileInterface;
// import FileInterfacePackage.RedFileInterface;
// import P2PInterfacePackage.*;

import java.util.ArrayList;
import java.util.Scanner;

public class WheelImp {
  static int i;
  static WheelAssy wAssy;
  // static PlugBoard pBd;
  // static Reflector ref;

  public static void main(String[] args) {
    // final int wS = 95;

    ArrayList<Integer> iList = new ArrayList<>();

    AuditInterfaceFactory aIf = new AuditInterfaceFactory();

    AuditInterfaceStubBase aInt = aIf.create(1);

    EncryptorFacade eFac = EncryptorFacade.Instance();
    AuthorizationInterfaceStubBase authorize = new AuthorizationInterfaceStubBase();

    /*  for (int i = 0; i < 5; ++i) {
      final int t1 = eFac.encrypt(i % wS);
      iList.add(t1);
    }

    aInt.SendEOK("Teamx", "good", true);

    int kLast = 0;
    for (int i = 4; i >= 0; --i) {
      int t1 = iList.get(i);

      int k = eFac.decrypt(t1);

      if (((k - kLast) > 1) && (kLast != 0)) {
        System.out.println("ERROR ********");
        System.exit(k);
      }
      kLast = k;
      System.out.println(k);
    }

    aInt.SendDOK("Teamx", "good", true);*/

    RedFileInterface dfi = new RedFileInterface();
    BlackFileInterface efi = new BlackFileInterface();
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEnter a teamname: ");
    String teamname = scanner.nextLine();
    System.out.println("Enter your password: ");
    String password = scanner.nextLine();

    if (authorize.authenticate(teamname, password)) {
      aInt.SendLOK(teamname, "good login", true);
    } else {
      aInt.SendLNOK(teamname, "bad login", true);
      System.exit(-1);
    }

    System.out.println("\nPlease choose from the following options: Enter -1 to exit().\n");

    System.out.println("(1) Encrypt File:");
    System.out.println("(2) Decrypt File:");

    while (i != -1) {
      i = scanner.nextInt();

      switch (i) {
        case 1:
          dfi.openForRead("MyInFile.txt");
          efi.openForWrite("MyOutFile.dat");
          char c = dfi.readInputFile();
          while (dfi.EOF() == false) {
            System.out.print(c);
            System.out.print(" ");
            int outc = dfi.convert(c);
            System.out.print(outc);
            int oute = eFac.encrypt(outc);
            System.out.print(" ");
            efi.writeToFile(oute);
            System.out.println(oute);
            c = dfi.readInputFile();
            // System.out.print(eFac.encrypt(outc));
          }

          dfi.closeInFile();
          efi.closeOutFile();

          wAssy = WheelAssy.Instance();
          // pBd = new PlugBoard();
          // ref = Reflector.Instance();

          int wp = wAssy.getCurPos1();
          int wp2 = wAssy.getCurPos2();
          int wp3 = wAssy.getCurPos3();

          System.out.println("\nWheel Position 1: " + wp);
          System.out.println("Wheel Position 2: " + wp2);
          System.out.println("Wheel Position 3: " + wp3);
          aInt.SendEOK("Testteam", "Success", true);

          System.out.println("\nPlease choose from the following options: Enter -1 to exit().\n");
          System.out.println("\n(1) Encrypt File:");
          System.out.println("(2) Decrypt File:");
          break;

        case 2:
          WheelAssy ref = WheelAssy.Instance();

          System.out.println("Set Wheel Position 1:");
          int s1 = scanner.nextInt();
          ref.setCurPos1(s1);

          System.out.println("Set Wheel Position 2:");
          int s2 = scanner.nextInt();
          ref.setCurPos2(s2);

          System.out.println("Set Wheel Position 3:");
          int s3 = scanner.nextInt();
          ref.setCurPos3(s3);

          // dfi.openForRead("MyOutFile.dat");
          efi.openForRead("MyOutFile.dat");

          int ine = efi.readFromFile();
          while (efi.EOF() == false) {
            dfi.addToBuf(ine);
            ine = efi.readFromFile();
          }
          efi.closeInFile();

          dfi.openForWrite("MyOutFile.txt");

          while (dfi.emptyBuf() == false) {
            int id = dfi.removeFromBuf();
            id = eFac.decrypt(id);
            dfi.addToRevBuf(id);
          }

          while (dfi.emptyRevBuf() == false) {
            int id = dfi.removeFromRevBuf();
            c = dfi.unConvert(id);
            dfi.writeToFile(c);
          }

          dfi.closeOutFile();

          System.out.println("\n" + s1);
          System.out.println(s2);
          System.out.println(s3);
          aInt.SendDOK("Testteam", "Success", true);

          System.out.println("\nPlease choose from the following options: Enter -1 to exit().\n");
          System.out.println("\n(1) Encrypt File:");
          System.out.println("(2) Decrypt File:");
          break;
        case -1:
          return;

        default:
          System.out.println("Try again!");

          break;
      }
    }
  }
}
