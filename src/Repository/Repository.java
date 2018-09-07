package Repository;

import Characters.Attributes.AttributeEnum;
import Characters.Enemy;
import Characters.Skills.Skill;
import Story.Dialog;
import Story.Scenario;
import Story.Scene;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private Connection dbconn;

    public Repository(String connstr) {
        try {
            dbconn = DriverManager.getConnection(connstr);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            if(dbconn != null) {
                try {
                    dbconn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** SKILLS (dat kills) **/
    public List<Skill> getAllSkills() {
        String stmt = "SELECT * FROM dbo.Skill";

        ArrayList<Skill> skillMasterList = new ArrayList<>();

        try (PreparedStatement sth = dbconn.prepareStatement(stmt)) {

            ResultSet res = sth.executeQuery();

            while (res.next()) {
                skillMasterList.add(newSkill(res));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return skillMasterList;
    }

    public Skill newSkill(ResultSet resultSet) throws SQLException {
        AttributeEnum attributeEnum = AttributeEnum.STRENGTH;

        switch (resultSet.getString(2)) {
            case "SPEED":
                attributeEnum = AttributeEnum.SPEED;
                break;
            case "INTELLIGENCE":
                attributeEnum = AttributeEnum.INTELLIGENCE;
                break;
            case "CHARISMA":
                attributeEnum = AttributeEnum.CHARISMA;
                break;
        }

        Skill skill = new Skill(resultSet.getString(3),
                resultSet.getString(4),
                attributeEnum,
                resultSet.getInt(5),
                resultSet.getInt(6));
        return skill;
    }


    /** ENEMY **/
    public Enemy getEnemyForScene (String sceneID) {
        String stmt = "SELECT dbo.Enemy.Name, " +
                "dbo.Enemy.Strength, " +
                "dbo.Enemy.Speed, " +
                "dbo.Enemy.Intelligence, " +
                "dbo.Enemy.Charisma,  " +
                "dbo.Enemy.HP " +
                "FROM dbo.Scen " +
                "WHERE dbo.Scen.ID = ? " +
                "INNER JOIN dbo.Enemy ON dbo.Scen.EnemyID = dbo.Enemy.ID";

        Enemy enemy = new Enemy("", 0, 0, 0, 0, 0);

        try (PreparedStatement sth = dbconn.prepareStatement(stmt)) {
            sth.setString(1, sceneID);

            ResultSet res = sth.executeQuery();

            if (res.next()) {
                enemy = new Enemy(res.getString(1),
                        res.getInt(2),
                        res.getInt(3),
                        res.getInt(4),
                        res.getInt(5),
                        res.getInt(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return enemy;
    }

    /** DIALOG, SCENES, AND SCENARIO **/
    public List<Scenario> getAllScenarios() {
        List<Scenario> allScenarios = new ArrayList<>();

        String stmt = "SELECT * FROM dbo.Scenario";

        try (PreparedStatement sth = dbconn.prepareStatement(stmt)) {

            ResultSet res = sth.executeQuery();

            while (res.next()) {
                String scenarioID = res.getString(1);
                allScenarios.add(getScenario(scenarioID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return allScenarios;
    }

    public Scenario getScenario(String scenarioID) {
        String stmt = "SELECT * FROM dbo.Scenario WHERE ID=?";
        Map<String, Scene> sceneMap = new HashMap<>();
        String firstSceneID = "";

        try (PreparedStatement sth = dbconn.prepareStatement(stmt)) {

            sth.setString(1, scenarioID);
            ResultSet res = sth.executeQuery();
            if(res.next()){
                firstSceneID = res.getString(1);
                sceneMap.put(firstSceneID,getScene(firstSceneID));
            }

            while (res.next()) {
                String sceneID = res.getString(1);
                sceneMap.put(sceneID,getScene(sceneID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return new Scenario(sceneMap,firstSceneID);
    }

    public Scene getScene(String sceneID) {
        String stmt = "SELECT * FROM dbo.Scenedialogs WHERE ID = ?";
        Map<String, Dialog> newSceneMap = new HashMap<>();
        String firstDialogID = "";

        try (PreparedStatement sth = dbconn.prepareStatement(stmt)) {
            sth.setString(1, sceneID);
            ResultSet res = sth.executeQuery();
            if(res.next()) {
                firstDialogID = res.getString(2);
                String dialogID = res.getString(1);
                newSceneMap.put(dialogID, getDialog(dialogID));
            }
            while (res.next()) {
                String dialogID = res.getString(1);
                newSceneMap.put(dialogID, getDialog(dialogID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return new Scene(newSceneMap, firstDialogID);
    }

    public Dialog getDialog(String dialogID) {
        String stmt = "SELECT * FROM dbo.Dialog WHERE ID = ?";
        Dialog dialog = null;
        try (PreparedStatement sth = dbconn.prepareStatement(stmt)) {
            sth.setString(1, dialogID);

            ResultSet res = sth.executeQuery();
            if(res.next()) {
                dialog = new Dialog(res.getString(2),
                                    res.getInt(5),
                                    res.getString(1),
                                    res.getString(3),
                                    res.getString(4),
                                    res.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return dialog;
    }
}
