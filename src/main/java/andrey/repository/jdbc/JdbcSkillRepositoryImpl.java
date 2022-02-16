package andrey.repository.jdbc;


import andrey.model.Skill;
import andrey.repository.SkillRepository;
import andrey.utils.SQLQueries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import static andrey.utils.JdbcUtils.getConnection;
import static andrey.utils.JdbcUtils.getPreparedStatement;


public class JdbcSkillRepositoryImpl implements SkillRepository {

    public Skill getById(Long id) {
        Skill skill = null;
        try(PreparedStatement pr = getPreparedStatement(SQLQueries.GET_SKILL_BY_ID_QUERY.getValue())) {
            pr.setLong(1,id);
           ResultSet rs =  pr.executeQuery();
           rs.next();
       skill = convertResultSetToSkill(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }
 public List<Skill> getAll() {
     getAllSkillsInternal().stream().forEach(System.out::println);
      return getAllSkillsInternal();
    }
   public Skill save(Skill skill){
     try(PreparedStatement ps = getPreparedStatement(SQLQueries.INSERT_SKILLS_QUERY.getValue())){
         ps.setInt(1, 0);
         ps.setString(2, skill.getName());
         ps.executeUpdate();
     } catch (SQLException e){
         e.printStackTrace();
     }
       return skill;
    }
   public Skill update(Skill skill) {
       try (PreparedStatement ps = getPreparedStatement(SQLQueries.UPDATE_SKILLS_QUERY.getValue())){
           ps.setString(1, skill.getName());
           ps.setLong(2, skill.getId());
           ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return skill;
   }
   public void deleteById(Long id){
        try(PreparedStatement ps = getPreparedStatement(SQLQueries.DELETE_SKILLS_QUERY.getValue())) {
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    private List<Skill> getAllSkillsInternal(){
        List<Skill> skills = new ArrayList<>();
        ResultSet resultSet;
        try (Statement statement= getConnection().createStatement()){
            resultSet = statement.executeQuery(SQLQueries.GET_SKILLS_QUERY.getValue());
               while (resultSet.next()) {
                   skills.add(convertResultSetToSkill(resultSet));
               }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }
    private Skill convertResultSetToSkill(ResultSet resultSet) throws SQLException {

           Long id = resultSet.getLong("id");
           String name = resultSet.getString("name");

          return  new Skill(id,name);

    }
    }


