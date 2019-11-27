package com.training.swingPractise.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JFrame win;
    private static JTextField name;
    private static JTextField old;
    private static JTextField color;
    private static JButton create;
    private static boolean createRes = false;

    public static void main(String[] args) {
        win = new JFrame();
        createGUI(win);
        setListeners(name,old,color,create);
        showDialog(win, createRes);
    }



    private static void createGUI(JFrame win) {
        // создадим окно нашего генератора
        win.setVisible(true);
        win.setFocusable(true);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // зададим панель на которой будем размещать элементы
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        panel.setVisible(true);
        win.add(panel);

        // создадим элементы
        JLabel nameLabel = new JLabel("Имя:");
        JLabel oldLabel = new JLabel("Возраст:");
        JLabel colorLabel = new JLabel("Цвет:");
        name = new JTextField(15);
        old = new JTextField(3);
        color = new JTextField(20);
        create = new JButton("Создать песика");

        // опишем положение элементов относительно других элементов
        layout.putConstraint(SpringLayout.WEST, name, 60, SpringLayout.WEST, nameLabel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 1, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, name,1, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.NORTH, oldLabel, 5, SpringLayout.SOUTH, nameLabel);
        layout.putConstraint(SpringLayout.WEST, old, 60, SpringLayout.WEST, oldLabel);
        layout.putConstraint(SpringLayout.NORTH, old, 5, SpringLayout.SOUTH, name);


        layout.putConstraint(SpringLayout.NORTH, colorLabel, 5, SpringLayout.SOUTH, oldLabel);
        layout.putConstraint(SpringLayout.WEST, color, 60, SpringLayout.WEST, colorLabel);
        layout.putConstraint(SpringLayout.NORTH, color, 5, SpringLayout.SOUTH, old);



        layout.putConstraint(SpringLayout.NORTH,create,15, SpringLayout.SOUTH,color);
        layout.putConstraint(SpringLayout.WEST, create, 10, SpringLayout.WEST, panel);

        // разместим элементы на панели
        panel.add(nameLabel);
        panel.add(name);
        panel.add(oldLabel);
        panel.add(old);
        panel.add(colorLabel);
        panel.add(color);
        panel.add(create);
        win.setSize(300, 230);
    }

    public static void setListeners(JTextField name, JTextField old, JTextField color, JButton create){
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(name.getText());
                System.out.println(old.getText());
                System.out.println(color.getText());
                createRes = !createRes;
                showDialog(win, createRes);

            }
        });
    }
    private static void showDialog(JFrame win, boolean createRes) {
        if (createRes){
            JOptionPane.showMessageDialog(win, "123123" );
        }

    }
}
