package andrey.service;

import andrey.model.Team;
import andrey.repository.jdbc.JdbcTeamRepositoryImpl;

import java.util.List;

public class TeamService {
    private final JdbcTeamRepositoryImpl teamRepo;

    public TeamService(){
        teamRepo = new JdbcTeamRepositoryImpl();
    }
    public Team get(Long id){
        return teamRepo.getById(id);
    }
    public List<Team> getAll(){
        return teamRepo.getAll();
    }
    public Team redirectSavedTeam(Team team){
        return teamRepo.save(team);
    }
    public Team redirectUpdatedTeam(Team team){
        return teamRepo.update(team);
    }
    public void delete(Long id){
        teamRepo.deleteById(id);
    }
}
