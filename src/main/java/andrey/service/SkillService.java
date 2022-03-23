package andrey.service;
import andrey.model.Skill;
import andrey.repository.jdbc.JdbcSkillRepositoryImpl;

import java.util.List;

public class SkillService {
    private final JdbcSkillRepositoryImpl skillRepo;

    public SkillService(){
        skillRepo = new JdbcSkillRepositoryImpl();
    }
    public Skill get(Long id){
        return skillRepo.getById(id);
    }
    public List<Skill> getAll(){
        return skillRepo.getAll();
    }
    public Skill saveSkill(Skill skill){
        return skillRepo.save(skill);
    }
    public Skill updateSkill(Skill skill){
        return skillRepo.update(skill);
    }
    public void delete(Long id){
        skillRepo.deleteById(id);
    }

}
