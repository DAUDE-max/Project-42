package Tiles.InteractiveTiles.NPC;

import Entities.Patient;
import diagnosen.DiagnoseManager;
import java.util.Scanner;
import main.GamePanel;

public class Selector extends NPC{

    int diagnoseNR;

    public Selector(int wX, int wY, GamePanel gp, String[] args) {
        super(wX,wY,gp, args);
    }
    
    public void action(){
        System.out.println("Input");
        Scanner scanner = new Scanner(System.in);
        diagnoseNR = scanner.nextInt();
        scanner.close();
        gp.patient = new Patient(gp, new DiagnoseManager(), 64, 58, diagnoseNR);
        System.out.print("Flag");
    }
}
