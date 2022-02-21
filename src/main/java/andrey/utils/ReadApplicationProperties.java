package andrey.utils;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public  class ReadApplicationProperties {
    String JDBC_DRIVER ;
    String DATABASE_URL;
    String USER;
    String PASSWORD;
    Path filepath = Path.of("src/main/resources/aplication.properties");
    public ReadApplicationProperties(){
        InitialField();
    }
      public  void InitialField() {
          try (FileChannel fchan = (FileChannel) Files.newByteChannel(filepath)) {
              Scanner scanner = new Scanner(fchan);
              JDBC_DRIVER = scanner.findInLine("com.mysql.jdbc.Driver");
              setJDBC_DRIVER(this.JDBC_DRIVER);
              scanner.nextLine();
              DATABASE_URL = scanner.findInLine("jdbc:mysql://localhost:3306/finishjdbcdatabase");
              setDATABASE_URL(this.DATABASE_URL);
              scanner.nextLine();
              USER = scanner.findInLine("root");
              setUSER(this.USER);
              scanner.nextLine();
              PASSWORD = scanner.findInLine("root");
              setPASSWORD(this.PASSWORD);
             /* System.out.println("JDBC_DRIVER " + JDBC_DRIVER);
              System.out.println("DATABASE_URL " + DATABASE_URL);
              System.out.println("USER " + USER);
              System.out.println("PASSWORD " + PASSWORD);*/

          } catch (
                  InvalidPathException i) {
              i.printStackTrace();
          } catch (
                  IOException e) {
              e.printStackTrace();
          }
      }

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setJDBC_DRIVER(String JDBC_DRIVER) {
        this.JDBC_DRIVER = JDBC_DRIVER;
    }

    public void setDATABASE_URL(String DATABASE_URL) {
        this.DATABASE_URL = DATABASE_URL;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
