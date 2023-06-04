import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import java.awt.event.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class zad_3 extends JFrame {
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2;
    double x0,  x, f;
    eWork button = new eWork();
    JFrame frame = new JFrame("График");

    public zad_3 (String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 =new JButton("Очистить");
        b2 =new JButton("Диаграмма");
        b3 =new JButton("Закрыть диаграмму");
        l1 =new JLabel("Введите константу x0");
        l2 =new JLabel("Введите константу x    ");
        l3 =new JLabel("Построить f(x) = e^(x^2 + 5x) + 9                                            ");
        l4 =new JLabel("                    ");
        l5 =new JLabel("              ");
        l6 =new JLabel("     ");
        t1 =new JTextField(10);
        t2 =new JTextField(10);
        add(l1);
        add(t1);
        add(l4);
        add(b2);
        add(l2);
        add(t2);
        add(l6);
        add(b3);
        add(l5);
        add(l3);
        add(b1);

        b2.addActionListener(button);
        b3.addActionListener(button);
        b1.addActionListener(button);
    }

    public static void main(String args[]) {
        zad_3 g = new zad_3("Задача");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(450, 170);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }
    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==b2) {
                    double delta = 0.5;
                    x0 = Double.parseDouble(t1.getText());
                    x = Double.parseDouble(t2.getText());
                    XYSeries series = new XYSeries("Math.exp(x*x + 5*x) + 9");
                    for(double i = x0 ; i <= x; i+=2*delta/100){
                        series.add(i, Math.exp(i*i + 5*i) + 9);
                    }
                    XYDataset xyDataset = new XYSeriesCollection(series);
                    JFreeChart chart = ChartFactory.createXYLineChart("Math.exp(x*x + 5*x) + 9", "x", "Math.exp(x*x + 5*x) + 9",
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
                    renderer.setSeriesStroke(0, new BasicStroke(4.0f));
                    frame.getContentPane().add(new ChartPanel(chart));
                    frame.setSize(600,600);
                    frame.setVisible(true);
                }
                if (e.getSource()==b3) {
                    frame.dispose();
                }
                if (e.getSource()==b1) {
                    t1.setText(null);
                    t2.setText(null);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Введите значения в числовом формате!");
            }
        }
    }
}