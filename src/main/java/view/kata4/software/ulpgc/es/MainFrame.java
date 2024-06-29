package view.kata4.software.ulpgc.es;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private BarChartDisplay barChartDisplay;

    public MainFrame() throws HeadlessException{
        this.setTitle("Histogram viewer");
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createBarChartDisplay());
    }

    private Component createBarChartDisplay() {
        JFreeBarChartDisplay display = new JFreeBarChartDisplay();
        this.barChartDisplay = display;
        return display;
    }

    public BarChartDisplay barChartDisplay() { return barChartDisplay; }
}
