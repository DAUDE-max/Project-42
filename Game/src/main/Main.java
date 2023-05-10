package main;

import javax.swing.JFrame;

class Main{
    public static void main(String[] args){
        // Configure window manager
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("S-RPG");
        window.setResizable(true);

        // Create GamePanel, add it to window and start game
        GamePanel gp = new GamePanel();
        window.add(gp);
        gp.startGameThread();
        gp.setup();

        // Apply window size, position and visibility
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}