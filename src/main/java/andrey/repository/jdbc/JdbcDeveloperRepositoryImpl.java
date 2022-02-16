package andrey.repository.jdbc;

import andrey.model.Developer;
import andrey.model.Skill;
import andrey.model.Team;
import andrey.utils.JdbcUtils;
import andrey.utils.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcDeveloperRepositoryImpl {

       public Developer getById(Long id){
           Developer developer = null;
        try(PreparedStatement ps = JdbcUtils.getPreparedStatement(SQLQueries.GET_DEVELOPER_BY_ID_QUERY.getValue())){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            developer = convertResultSetToDeveloper(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }
           System.out.println(developer);
        return developer;
    }
   public List<Developer> getAll(){
       getAllDevelopersInternal().stream().forEach(System.out::println);
        return getAllDevelopersInternal();

    }

 public Developer save(Developer developer){
     try(PreparedStatement pstatement = JdbcUtils.getPreparedStatement(SQLQueries.INSERT_DEVELOPERS_QUERY.getValue())) {
         pstatement.setLong(1,0);
         pstatement.setString(2, developer.getFirstName());
         pstatement.setString(3,developer.getLastName());
         pstatement.setInt(4,developer.getTeamId());
         pstatement.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return developer;
    }
   public Developer update(Developer developer ){
        try (PreparedStatement pstatement = JdbcUtils.getPreparedStatement(SQLQueries.UPDATE_DEVELOPERS_QUERY.getValue())) {
           String firstName = developer.getFirstName();
           String lastName = developer.getLastName();
           int team_id = developer.getTeamId();
            pstatement.setString(1,firstName);
            pstatement.setString(2,lastName);
            pstatement.setInt(3,team_id);
            pstatement.setLong(4,developer.getId());
            pstatement.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return developer;
    }
   public  void deleteById(Long id){
       try(PreparedStatement pstatement = JdbcUtils.getPreparedStatement(SQLQueries.DELETE_DEVELOPERS_QUERY.getValue())) {
           pstatement.setLong(1,id);
           pstatement.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    private List<Developer> getAllDevelopersInternal(){
     List<Developer> developers = new ArrayList<>();
     ResultSet resultSet;
        try (Statement statement = JdbcUtils.getConnection().createStatement()){
            resultSet = statement.executeQuery(SQLQueries.GET_DEVELOPERS_QUERY.getValue());
            while (resultSet.next()){
             developers.add(convertResultSetToDeveloper(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return developers;
    }
    private Developer convertResultSetToDeveloper(ResultSet resultSet) throws SQLException {

           Long id = resultSet.getLong("id");
           String firstName = resultSet.getString("firstName");
           String lastName = resultSet.getString("lastName");
           int teamId =  resultSet.getInt("team_id");

           return new Developer(id,firstName,lastName,teamId);
    }
  }
