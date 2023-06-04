import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class zad_4 extends JFrame {
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    eWork button = new eWork();

    public zad_4(String s){
        super(s);
        setLayout(new FlowLayout());
        b2 = new JButton("Отчистить");
        b1 = new JButton("Вычислить");
        l1 = new JLabel("Число №1");
        l2 = new JLabel("Число №2");
        l3 = new JLabel("Число №3");
        l4 = new JLabel("Число №4");
        l5 = new JLabel("Число №5");
        l6 = new JLabel("Число №6");
        l7 = new JLabel("Число №7");
        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t5 = new JTextField(15);
        t6 = new JTextField(15);
        t7 = new JTextField(15);
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(b1);
        add(b2);
        b2.addActionListener(button);
        b1.addActionListener(button);
    }

    public static void main(String[] args) {
        zad_4 g = new zad_4("Рандомайзер");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(300,260);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }

    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == b1) {
                    t1.setText(Double.toString(Math.random()));
                    t2.setText(Double.toString(Math.random()));
                    t3.setText(Double.toString(Math.random()));
                    t4.setText(Double.toString(Math.random()));
                    t5.setText(Double.toString(Math.random()));
                    t6.setText(Double.toString(Math.random()));
                    t7.setText(Double.toString(Math.random()));
                    JOptionPane.showMessageDialog(null, "Данные успешно вычислены.");
                } else if (e.getSource()==b2) {
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    t4.setText(null);
                    t5.setText(null);
                    t6.setText(null);
                    t7.setText(null);
                    JOptionPane.showMessageDialog(null, "Операция отчищения выполнена.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ошибка!");
            }
        }
    }
}