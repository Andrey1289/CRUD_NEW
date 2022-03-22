package andrey.controller;
import andrey.model.Developer;
import andrey.service.DeveloperService;

import java.util.List;

public class DeveloperController {
    private final DeveloperService devService;

    public DeveloperController() {
        devService = new DeveloperService();
    }


    public Developer get(Long id){
        return devService.get(id);
    }
    public List<Developer> getAll(){
        return devService.getAll();
    }

    public Developer create(String firstName, String lastName, int team_id){
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
       developer.setTeamId(team_id);
      return devService.redirectSavingDeveloper(developer);
    }

    public Developer update(Long id, String firstName, String lastName, int team_id){
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setTeamId(team_id);
        return devService.redirectUpdatedDeveloper(developer);
    }

    public void delete(Long id){
        devService.delete(id);
    }
}
