package main;

import javax.swing.*;

class Main{
    public static void main(String[] Args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("2d-Game");
        window.setResizable(false);

        GamePanel gp = new GamePanel();

        window.add(gp);
        gp.startGameThread();
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}