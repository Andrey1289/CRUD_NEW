package andrey.controller;

import andrey.model.Developer;
import andrey.model.Team;
import andrey.repository.jdbc.JdbcTeamRepositoryImpl;
import andrey.service.TeamService;

import java.util.List;

public class TeamController {
    private final TeamService teamService;

    public TeamController() {
        teamService = new TeamService();
    }

    public Team get(Long id){
        return teamService.get(id);
    }
    public List<Team> getAll(){
        return teamService.getAll();
    }

    public Team create( String name){
     Team team = new Team();
     team.setName(name);
     return teamService.saveTeam(team);
    }

    public Team update(Long id, String name){
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        return teamService.updateTeam(team);
    }

    public void delete(Long id){
       teamService.delete(id);
    }
}
