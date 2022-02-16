package andrey.model;

import java.util.List;

public class Developer {
  private Long id;
  private String firstName;
  private String lastName;
  private List<Skill> skills;

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  private int teamId;

  public Developer(){}

  public Developer(Long id, String firstName, String lastName, int teamId){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.teamId = teamId;
  }

  public Developer(Long id, String firstName, String lastName, List<Skill> skills) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.skills = skills;
  }
  public Developer(String firstName){
    this.firstName= firstName;
  }
  public Developer(String firstName,String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  @Override
  public String toString() {
    return "Developer{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", teamId=" + teamId +
            '}';
  }


}
