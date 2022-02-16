package andrey.repository.jdbc;

import andrey.model.Team;
import andrey.repository.TeamRepository;
import andrey.utils.JdbcUtils;
import andrey.utils.SQLQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import static andrey.utils.JdbcUtils.getPreparedStatement;


public class JdbcTeamRepositoryImpl implements TeamRepository {

   public Team getById(Long id){
       Team team = null;
       try(PreparedStatement pr = getPreparedStatement(SQLQueries.GET_TEAM_BY_ID_QUERY.getValue())) {
           pr.setLong(1,id);
           ResultSet rs =  pr.executeQuery();
           rs.next();
           team = convertResultSetToTeam(rs);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       System.out.println(team);
       return team;

    }

    private Team convertResultSetToTeam(ResultSet rs)  {
        Long id = 0L;
        String teamName = null;
       try {
           id = rs.getLong("id");
           teamName = rs.getString("name");
      }catch (SQLException e){
           System.out.println("В таблице teams нет записи о команде по этому id  ");
      }
       return new Team(id,teamName);
    }

    public List<Team> getAll(){
       getAllTeamsInternal().stream().forEach(System.out::println);
        return getAllTeamsInternal();
    }

  public Team save(Team team){
      try(PreparedStatement ps = JdbcUtils.getPreparedStatement(SQLQueries.INSERT_TEAMS_QUERY.getValue())){
          ps.setLong(1,0);
          ps.setString(2,team.getName());
          ps.executeUpdate();
      }catch (SQLException e){
          e.printStackTrace();
      }
       return team;
    }

   public Team update(Team team){
    try (PreparedStatement ps = getPreparedStatement(SQLQueries.UPDATE_TEAM_QUERY.getValue())){
        ps.setString(1,team.getName());
        ps.setLong(2,team.getId());
        ps.executeUpdate();
    }catch (SQLException e){
        e.printStackTrace();
    }
    return team;
           }

   public void deleteById(Long id){
       try(PreparedStatement ps = JdbcUtils.getPreparedStatement(SQLQueries.DELETE_TEAMS_QUERY.getValue())) {
           ps.setLong(1,id);
           ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
    private List<Team> getAllTeamsInternal(){
        List<Team> teams = new ArrayList<>();
        ResultSet resultSet;
        try(Statement statement = JdbcUtils.getConnection().createStatement();){
            resultSet = statement.executeQuery(SQLQueries.GET_TEAMS_QUERY.getValue());
            while (resultSet.next()){
                teams.add(convertResultSetToTeam(resultSet));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  teams;
    }

}
