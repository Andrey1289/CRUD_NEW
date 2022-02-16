package andrey.utils;

public enum SQLQueries {
    GET_SKILL_BY_ID_QUERY("SELECT * FROM skills WHERE id = ?"),
    GET_SKILLS_QUERY("SELECT * FROM skills"),
    UPDATE_SKILLS_QUERY("UPDATE skills SET name = ? WHERE id =?"),
    INSERT_SKILLS_QUERY("INSERT INTO skills VALUE(?,?)"),
    DELETE_SKILLS_QUERY("DELETE FROM skills WHERE id = ?"),
    GET_DEVELOPER_BY_ID_QUERY("SELECT * FROM developers WHERE id = ?"),
    GET_DEVELOPERS_QUERY("SELECT * FROM developers"),
    UPDATE_DEVELOPERS_QUERY("UPDATE developers SET firstname = ?,  lastname = ?, team_id = ?  WHERE id = ?"),
    INSERT_DEVELOPERS_QUERY("INSERT INTO developers VALUES(?,?,?,?)"),
    DELETE_DEVELOPERS_QUERY("DELETE  FROM developers WHERE id = ?"),
    GET_TEAM_BY_ID_QUERY("SELECT * FROM teams WHERE id = ?"),
    GET_TEAMS_QUERY("SELECT * FROM teams"),
    UPDATE_TEAM_QUERY("UPDATE teams SET name = ? WHERE id =?"),
    INSERT_TEAMS_QUERY("INSERT INTO teams VALUE(?,?)"),
    DELETE_TEAMS_QUERY("DELETE FROM teams WHERE id = ?");

   SQLQueries(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return this.value;
    }
}
