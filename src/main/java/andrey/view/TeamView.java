package andrey.view;

import andrey.controller.TeamController;
import andrey.model.Developer;
import andrey.model.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TeamView {
 private final TeamController tcont = new TeamController();

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.tmView();
    }

    public  void tmView() {
        Developer developer =new Developer();
        ArrayList<Developer> developers = new ArrayList<>();
        Skill skill = new Skill();
        ArrayList<Skill> skills = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("Меню для создания Team");
            System.out.println("Для завершения нажмите 'Exit'");
            String strUser ="";

            while(!strUser.equals("EXIT")) {
                System.out.println("Введите действие: 'create' 'get' 'getAll' 'update' 'delete' ");
                strUser= br.readLine().trim();
                switch (strUser) {
                    case "create":
                        Long id;
                        System.out.println("Введите Team 'Name'");
                        String teamName = br.readLine().trim();
                       tcont.create(teamName);
                        System.out.println("Team успешно создана");
                        break;
                    case "get":
                        System.out.println("Введите 'ID' ");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("Введите 'ID'");
                            id = Long.parseLong(br.readLine().trim());
                        }
                        tcont.get(id);
                        break;
                    case "getAll":
                        tcont.getAll();
                        break;
                   case "update":
                        id = 0L;
                        System.out.println("Введите 'ID' имя которого хотите изменить");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("Введите 'ID' имя которого хотите изменить");
                            id = Long.parseLong(br.readLine().trim());
                        }
                       System.out.println("Введите Team 'Name'");
                        teamName = br.readLine().trim();
                       tcont.update(id,teamName);
                        System.out.println("Team успешно изменена");
                        break;
                    case "delete":
                        System.out.println("ВВедите 'ID' для удаления");
                        try {
                            id = Long.parseLong(br.readLine().trim());
                        }catch (NumberFormatException e){
                            System.out.println("Вы ввели не число");
                            System.out.println("ВВедите 'ID' для удаления");
                            id = Long.parseLong(br.readLine().trim());
                        }
                        tcont.delete(id);
                        System.out.println("Team успешно удалена");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
