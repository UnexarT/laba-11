import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class zad_2 extends JFrame {
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    eWork button = new eWork();

    public zad_2(String s){
        super(s);
        setLayout(new FlowLayout());
        b1 = new JButton("Записать");
        b2 = new JButton("Загрузить");
        l1 = new JLabel("Введите фамилию          ");
        l2 = new JLabel("Введите имя                      ");
        l3 = new JLabel("Введите отчество            ");
        l4 = new JLabel("Введите дату рождения");
        l5 = new JLabel("Введите группу                ");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
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
        add(b1);
        add(b2);
        b2.addActionListener(button);
        b1.addActionListener(button);
    }

    public static void main(String[] args) {
        zad_2 g = new zad_2("Гослинг момент");
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setSize(300,220);
        g.setResizable(false);
        g.setLocationRelativeTo(null);
    }

    public class eWork implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == b2) {
                    String[] data = ReadFile("DataForZad_2.txt");
                    if(data.length == 0){
                        JOptionPane.showMessageDialog(null, "Файл пуст! ");
                    } else {
                        t1.setText(data[0]);
                        t2.setText(data[1]);
                        t3.setText(data[2]);
                        t4.setText(data[3]);
                        t5.setText(data[4]);
                        JOptionPane.showMessageDialog(null, "Данные успешно згружены.");
                    }

                } else if (e.getSource() == b1) {
                    String[] data = {t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText()};
                    CreateNewFile(null, "DataForZad_2.txt");
                    try (PrintWriter pw = new PrintWriter("DataForZad_2.txt")){
                        int count = 0;
                        for(String text : data) {
                            if (text.length() > 0) {
                                pw.println(text);
                                count++;
                            }
                        }
                        pw.close();
                        if (count == 5){
                            JOptionPane.showMessageDialog(null, "Данные успешно записаны в файл.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ошибка при записи в файл! ");
                        }

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка при записи в файл: " + ex.getMessage());
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ошибка!");
            }
        }
    }
    public static void CreateNewFile(String path,String FileName) throws IOException {
        File file = new File(path,FileName);
        if (!file.exists()){
            file.createNewFile();
        }
    }
    public static String[] ReadFile(String FileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            list.add(line);
        }
        String[] arr = new String[list.size()];
        list.toArray(arr);
        return arr;
    }
}

