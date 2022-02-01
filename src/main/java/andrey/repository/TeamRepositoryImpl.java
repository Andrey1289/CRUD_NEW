package andrey.repository;


import andrey.model.Developer;
import andrey.model.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import static andrey.repository.DeveloperRepositoryImpl.connection;


public class TeamRepositoryImpl implements TeamRepository {

   public Team getById(Long id){
     getAllTeamsInternal().stream().filter(team -> team.getId().equals(id)).forEach(System.out::println);
    return getAllTeamsInternal().stream().filter(team -> team.getId().equals(id)).findFirst().orElse(null);

    }

  public List<Team> getAll(){
        return getAllTeamsInternal();
    }

  public Team save(Team team){

       return team;
    }

   public Team update(Team team){
     List<Team> teams = getAllTeamsInternal();
      teams.forEach(tm ->{
          if(tm.getId().equals(team.getId()))
          tm.setName(team.getName());
          tm.setDevelopers(team.getDevelopers());

      });

       return team;
           }

   public void deleteById(Long id){
      List<Team> teams = getAllTeamsInternal();
      teams.removeIf(tm -> tm.getId().equals(id));

    }



    private List<Team> getAllTeamsInternal(){
        List<Team> teams = new ArrayList<>();
        List<Developer> developers = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM teams");
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  null;
    }

}
