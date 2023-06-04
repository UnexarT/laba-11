import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class zad_5  {
    public static void main(String[] args) {
        Graph fun = new Graph();
        fun.Pole();
    }
}

class Graph{
    JFrame frame = new JFrame("График");
    public void Pole()  {
        double delta = 0.5;
        XYSeries series1 = new XYSeries("1");
        drawLine(-4, 0, 1, 4,delta,series1);
        XYSeries series2 = new XYSeries("2");
        drawLine(1, 4, -7, 5,delta,series2);
        XYSeries series3 = new XYSeries("3");
        drawLine(-6, -4, -7, 5,delta,series3);
        XYSeries series4 = new XYSeries("4");
        drawLine(-2, -6, -6, -4,delta,series4);
        XYSeries series5 = new XYSeries("5");
        drawLine(-2, -6, -4, 0,delta,series5);
        XYSeries series6 = new XYSeries("6");
        for(double i = -7 ; i <= -2; i+=2*delta/100){
            series6.add(1, i );
        }
        XYSeries series7 = new XYSeries("7");
        drawLine(1, -2, 3, -1,delta,series7);
        XYSeries series8 = new XYSeries("8");
        drawLine(1, -7, 3, -4,delta,series8);
        XYSeries series9 = new XYSeries("9");
        drawLine(3, -1, 5,2,delta,series9);
        XYSeries series10 = new XYSeries("10");
        drawLine(3, -4, 6, -3,delta,series10);
        XYSeries series11 = new XYSeries("11");
        drawLine(6, -3, 5,2,delta,series11);

        XYSeriesCollection xyDataset = new XYSeriesCollection();
        xyDataset.addSeries(series1);
        xyDataset.addSeries(series2);
        xyDataset.addSeries(series3);
        xyDataset.addSeries(series4);
        xyDataset.addSeries(series5);
        xyDataset.addSeries(series6);
        xyDataset.addSeries(series7);
        xyDataset.addSeries(series8);
        xyDataset.addSeries(series9);
        xyDataset.addSeries(series10);
        xyDataset.addSeries(series11);


        JFreeChart chart = ChartFactory.
                createXYLineChart("", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);

        chart.setBackgroundPaint(Color.white);

        Plot plot = chart.getPlot();
        plot.setBackgroundPaint(Color.white);

        ((XYPlot) plot).setDomainGridlinePaint(Color.black);
        ((XYPlot) plot).setRangeGridlinePaint(Color.black);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) ((XYPlot) plot).getRenderer();

        renderer.setSeriesPaint(0, Color.black);
        renderer.setSeriesPaint(1, Color.black);
        renderer.setSeriesPaint(2, Color.black);
        renderer.setSeriesPaint(3, Color.black);
        renderer.setSeriesPaint(4, Color.black);
        renderer.setSeriesPaint(5, Color.black);
        renderer.setSeriesPaint(6, Color.black);
        renderer.setSeriesPaint(7, Color.black);
        renderer.setSeriesPaint(8, Color.black);
        renderer.setSeriesPaint(9, Color.black);
        renderer.setSeriesPaint(10, Color.black);

        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(2.0f));
        renderer.setSeriesStroke(4, new BasicStroke(2.0f));
        renderer.setSeriesStroke(5, new BasicStroke(2.0f));
        renderer.setSeriesStroke(6, new BasicStroke(2.0f));
        renderer.setSeriesStroke(7, new BasicStroke(2.0f));
        renderer.setSeriesStroke(8, new BasicStroke(2.0f));
        renderer.setSeriesStroke(9, new BasicStroke(2.0f));
        renderer.setSeriesStroke(10, new BasicStroke(2.0f));

        JFrame frame = new JFrame("Фигуры");
        frame.getContentPane().add(new ChartPanel(chart));
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    public static void drawLine(double x1, double y1, double x2, double y2, double delta, XYSeries series){
        for(double i = Math.min(x1,x2) ; i <= Math.max(x1,x2); i+=2*delta/100){
            series.add(i, i * k(x1,y1,x2,y2) + b(x1,y1,x2,y2));
        }
    }

    public static double k(double x1,double y1,double x2,double y2){
        return (y1 - y2)/(x1 - x2);
    }
    public static double b(double x1,double y1,double x2,double y2){
        return y1 - x1*k(x1,y1,x2,y2);
    }
}
