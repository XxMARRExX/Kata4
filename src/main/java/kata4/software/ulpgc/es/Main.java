package kata4.software.ulpgc.es;

import db.kata4.software.ulpgc.es.DataExtractor;
import db.kata4.software.ulpgc.es.DataInserter;
import db.kata4.software.ulpgc.es.DatabaseConnector;
import db.kata4.software.ulpgc.es.TableManagerF1Championship;
import model.kata4.software.ulpgc.es.*;
import statistic.kata4.software.ulpgc.es.TeamPointsStatistic;
import view.kata4.software.ulpgc.es.MainFrame;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<F1DriverRegister> registers = CSVFileLoader
                .with(new File("drivers_updated.csv"))
                .load();

        Connection connection = DatabaseConnector.connect();
        if(connection != null){
            TableManagerF1Championship.createTable(connection);
            new DataInserter().insertDirverRegisters(registers, connection);
            registers = new DataExtractor().extractF1ChampionshipRecords(connection);
        }

        TeamPointsStatistic statistic = new TeamPointsStatistic();
        Map<String, Float> map = statistic.calculate(registers);
        map = statistic.bestTenTeams(map);

        MainFrame mainFrame = new MainFrame();
        mainFrame.barChartDisplay().show("Team Points Statistics", map);
        mainFrame.setVisible(true);
    }

}
