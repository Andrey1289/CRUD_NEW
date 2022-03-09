package andrey.controller;

import andrey.model.Skill;
import andrey.repository.jdbc.JdbcSkillRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class SkillController {
    private final JdbcSkillRepositoryImpl repo;

    public SkillController() {
       repo = new JdbcSkillRepositoryImpl();
    }

    public Skill get(Long id) throws SQLException {
     return repo.getById(id);
    }
    public List<Skill> getAll(){
        return repo.getAll();
    }
     public Skill create(String name){
        Skill s = new Skill();
        s.setName(name);
        return repo.save(s);
     }
     public void  delete(Long id){
       repo.deleteById(id);
     }
     public Skill update(Long id,String name){
        Skill s = new Skill();
        s.setId(id);
        s.setName(name);
        return repo.update(s);
     }

}
