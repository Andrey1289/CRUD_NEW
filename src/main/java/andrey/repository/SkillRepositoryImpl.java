package andrey.repository;


import andrey.model.Skill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import static andrey.repository.DeveloperRepositoryImpl.connection;


public class SkillRepositoryImpl implements SkillRepository {

     public Skill getById(Long id){
         getAllSkillsInternal().stream().filter(s -> s.getId().equals(id)).forEach(System.out::println);
         return  getAllSkillsInternal().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
   }
 public List<Skill> getAll() {
     getAllSkillsInternal().stream().forEach(System.out::println);
      return getAllSkillsInternal();
    }
   public Skill save(Skill skill){
     PreparedStatement ps = null;
     try{
         ps = connection().prepareStatement("INSERT INTO skills VALUE(?,?)");
         ps.setLong(1,0);
         ps.setString(2, skill.getName());
         ps.executeUpdate();
     } catch (SQLException e){
         e.printStackTrace();
     }finally {
         try {
             ps.close();
             connection().close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
       return skill;
    }
   public Skill update(Skill skill) {
       PreparedStatement ps = null;
       try {
           ps = connection().prepareStatement("UPDATE skills SET name = ? WHERE id =?");
           ps.setString(1, skill.getName());
           ps.setLong(2, skill.getId());
           ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try {
               ps.close();
               connection().close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return skill;
   }
   public void deleteById(Long id){
        PreparedStatement ps = null;
        try {
            ps = connection().prepareStatement("DELETE FROM skills WHERE id = ?");
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                connection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    private List<Skill> getAllSkillsInternal(){
        List<Skill> skills = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        String SQL = "SELECT * FROM skills";
        try {
            statement= connection().createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String skillname = resultSet.getString("name");
                skills.add(new Skill(id,skillname));
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
        return skills;
    }
    }


