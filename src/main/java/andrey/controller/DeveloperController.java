package andrey.controller;


import andrey.model.Developer;
import andrey.model.Skill;
import andrey.repository.jdbc.JdbcDeveloperRepositoryImpl;
import java.util.List;

public class DeveloperController {
    private final JdbcDeveloperRepositoryImpl devRepo;

    public DeveloperController() {
        devRepo = new JdbcDeveloperRepositoryImpl();
    }


    public Developer get(Long id){
        return devRepo.getById(id);
    }
    public List<Developer> getAll(){
        return devRepo.getAll();
    }

    public Developer create(String firstName, String lastName, int team_id){
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
       developer.setTeamId(team_id);
      return devRepo.save(developer);
    }

    public Developer update(Long id, String firstName, String lastName, int team_id){
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setTeamId(team_id);
        return devRepo.update(developer);
    }

    public void delete(Long id){
        devRepo.deleteById(id);
    }
}
