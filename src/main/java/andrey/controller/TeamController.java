package andrey.controller;

import andrey.model.Developer;
import andrey.model.Team;
import andrey.repository.jdbc.JdbcTeamRepositoryImpl;
import java.util.List;

public class TeamController {
    private final JdbcTeamRepositoryImpl tRepo;

    public TeamController() {
        tRepo = new JdbcTeamRepositoryImpl();
    }


    public Team get(Long id){
        return tRepo.getById(id);
    }
    public List<Team> getAll(){
        return tRepo.getAll();
    }

    public Team create( String name){
     Team team = new Team();
     team.setName(name);
     return tRepo.save(team);
    }

    public Team update(Long id, String name){
        Team team = new Team();
        team.setId(id);
        team.setName(name);
        return tRepo.update(team);
    }

    public void delete(Long id){
        tRepo.deleteById(id);
    }
}
