import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class zad_1 extends JFrame{
    JButton but;
    JLabel l1, l2;
    JTextField t1, t2;
    eWork button = new eWork();

    public zad_1(String s) {
        super(s);
        setLayout(new FlowLayout());
        but = new JButton("Записать");
        l1 = new JLabel("Введите текст");
        l2 = new JLabel("Введите путь  ");
        t1 = new JTextField(25);
        t2 = new JTextField(25);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(but);
        but.addActionListener(button);
    }

    public static void main(String[] args) {
        zad_1 g = new zad_1("Запись текста в файл");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(400,130);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }

    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try (PrintWriter pw = new PrintWriter(t2.getText())){
                if(t1.getText().length() <= 25){
                    pw.write(t1.getText());
                    pw.close();
                    JOptionPane.showMessageDialog(null, "Данные успешно записаны в файл.");
                }else {
                    JOptionPane.showMessageDialog(null, "Ошибка при записи в файл! ");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка при записи в файл: " + ex.getMessage());
            }
        }
    }
}
