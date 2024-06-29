package kata4.software.ulpgc.es;

import model.kata4.software.ulpgc.es.*;
import statistic.kata4.software.ulpgc.es.TeamPointsStatistic;
import view.kata4.software.ulpgc.es.MainFrame;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<F1DriverRegister> registers = CSVFileLoader
                .with(new File("drivers_updated.csv"))
                .load();



        TeamPointsStatistic statistic = new TeamPointsStatistic();
        Map<String, Float> map = statistic.calculate(registers);
        map = statistic.bestTenTeams(map);

        MainFrame mainFrame = new MainFrame();
        mainFrame.barChartDisplay().show("Team Points Statistics", map);
        mainFrame.setVisible(true);
    }

}
