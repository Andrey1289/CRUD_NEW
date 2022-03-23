package andrey.controller;

import andrey.model.Skill;
import andrey.repository.jdbc.JdbcSkillRepositoryImpl;
import andrey.service.DeveloperService;
import andrey.service.SkillService;

import java.sql.SQLException;
import java.util.List;

public class SkillController {
    private final SkillService skillService;

    public SkillController() {
       skillService = new SkillService();
    }

    public Skill get(Long id) throws SQLException {
     return skillService.get(id);
    }
    public List<Skill> getAll(){
        return skillService.getAll();
    }
     public Skill create(String name){
        Skill s = new Skill();
        s.setName(name);
        return skillService.saveSkill(s);
     }
     public void  delete(Long id){
      skillService.delete(id);
     }
     public Skill update(Long id,String name){
        Skill s = new Skill();
        s.setId(id);
        s.setName(name);
        return skillService.updateSkill(s);
     }

}
