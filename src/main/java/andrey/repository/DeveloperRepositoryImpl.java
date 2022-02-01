package andrey.repository;

import andrey.model.Developer;
import andrey.model.Skill;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeveloperRepositoryImpl {
    /**
     * JDBC Driver and database url
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cruddatabase";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static Connection connection(){
        Connection con = null;
               try {
            Class.forName(JDBC_DRIVER);
             con = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

            } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
        }
        return con;
    }

    public Developer getById(Long id){
        getAllDevelopersInternal().stream().filter(dev -> dev.getId().equals(id)).forEach(System.out::println);
        return getAllDevelopersInternal().stream().filter(dev -> dev.getId().equals(id)).findFirst().orElse(null);
    }
   public List<Developer> getAll(){
       getAllDevelopersInternal().stream().forEach(System.out::println);
        return getAllDevelopersInternal();

    }

 public Developer save(Developer developer){
        PreparedStatement pstatement = null;
     try {
         pstatement = connection().prepareStatement("INSERT INTO developers VALUES(?,?,?,?)");
         pstatement.setLong(1, 0);
         pstatement.setString(2, developer.getFirstName());
         pstatement.setString(3,developer.getLastName());
         pstatement.setString(4, );
         pstatement.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }finally {
         try {
             pstatement.close();
            connection().close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     return developer;
    }
   public Developer update(Developer developer ){
         PreparedStatement pstatement = null;
       try {
           pstatement = connection().prepareStatement("UPDATE developers SET firstname = ?,  lastname = ?,  skill = ? WHERE id = ?");
           String firstName = developer.getFirstName();
           String lastName = developer.getLastName();
         String skills = String.valueOf(developer.getSkills());
           pstatement.setString(1,firstName);
           pstatement.setString(2,lastName);
           pstatement.setString(3,skills);
           pstatement.setLong(4,developer.getId());
           pstatement.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           try {
               pstatement.close();
               connection().close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
        return developer;
    }
   public  void deleteById(Long id){

       PreparedStatement pstatement = null;
       try {
           pstatement = connection().prepareStatement("DELETE  FROM developers WHERE id = ?");
           pstatement.setLong(1,id);
           pstatement.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           try {
               pstatement.close();
               connection().close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
    private List<Developer> getAllDevelopersInternal(){
     List<Developer> developers = new ArrayList<>();
     List<Skill> skills = new ArrayList<>();
     Skill skill = new Skill();
     Statement statement = null;
     ResultSet resultSet;
        String SQL = "SELECT * FROM developers";
        try {
            statement= connection().createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
             Long id = resultSet.getLong("id");
             String firstname = resultSet.getString("firstname");
             String lastname = resultSet.getString("lastname");
             String skillname = resultSet.getString("skill");
             developers.add(new Developer(id,firstname,lastname,Collections.singletonList(new Skill(id,skillname))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
          return developers;
    }
  }
