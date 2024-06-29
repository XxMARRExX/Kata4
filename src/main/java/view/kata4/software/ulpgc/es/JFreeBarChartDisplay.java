package view.kata4.software.ulpgc.es;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class JFreeBarChartDisplay extends JPanel implements BarChartDisplay{

    public void show(String tittle, Map<String, Float> teamPoints){
        DefaultCategoryDataset dataset = createDataSet(teamPoints);
        JFreeChart barChart = createChart(tittle, dataset);
        ChartPanel chartPanel = createChartPanel(barChart);

        add(chartPanel);
    }

    private ChartPanel createChartPanel(JFreeChart chart) {
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800,600));
        return chartPanel;
    }

    private JFreeChart createChart(String tittle, DefaultCategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                tittle,
                "Team",
                "Points",
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false);

        configurePlot(barChart);
        configureRenderer((BarRenderer) barChart.getCategoryPlot().getRenderer(), dataset);
        configureFonts(barChart);

        return barChart;
    }

    private void configurePlot(JFreeChart barChart) {
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setOutlineVisible(false);
        plot.setInsets(new RectangleInsets(10, 5, 5, 5));
    }

    private void configureFonts(JFreeChart barChart) {
        barChart.getTitle().setFont(new Font("Arial", Font.BOLD, 18));
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.getDomainAxis().setTickLabelFont(new Font("Arial", Font.PLAIN,12));
        plot.getDomainAxis().setLabelFont(new Font("Arial", Font.BOLD,14));
        plot.getRangeAxis().setTickLabelFont(new Font("Arial", Font.PLAIN,12));
        plot.getRangeAxis().setLabelFont(new Font("Arial", Font.BOLD,14));
    }

    private void configureRenderer(BarRenderer renderer, DefaultCategoryDataset dataset) {
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.1);

        Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA,
                Color.CYAN, Color.ORANGE, Color.BLACK, Color.PINK, Color.LIGHT_GRAY};

        for (int i = 0; i < dataset.getRowCount(); i++){
            renderer.setSeriesPaint(i, colors[i % colors.length]);
        }
    }

    private DefaultCategoryDataset createDataSet(Map<String, Float> teamPoints) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Float> entry: teamPoints.entrySet()){
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }

        return dataset;
    }

}
