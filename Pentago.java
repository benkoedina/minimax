/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pentago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dell
 */

public class Pentago {

    private final static int d = 2;
    static PentagoTable table;
    static int turnPlayer = 0;
    
    public static void main(String[] args) {
        
        table = new PentagoTable();
        turnPlayer = 1;
        table.printTable();
        go();

    }
      private static void guest(BufferedReader in,  PentagoGame currentTree,String input )
    {
        System.out.println("Row-Column-Rotation: ");
                try {
                    input = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (input != null) {
                    pars(input);
                    table.printTable();
                }
    }
    private static void computer(BufferedReader in,  PentagoGame currentTree,String input)
    {
                System.out.println("Computer move:");
                Computer computer = new Computer(d);
                int aiMove = computer.step(d, currentTree, false);
                pars(computer.getTable().getLastMove());
                table.printTable();
    }
    private static void pars(String input) {
        
        String[] userInput = input.split(" ");
        table.makeMove(turnPlayer, Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]));
        if (turnPlayer == 1) {
            turnPlayer = 2;
        } else {
            turnPlayer = 1;
        }
        if (table.isWinner() == 0) {
            table.rotate(userInput[2]);
        } else if (table.isWinner() == 1) {
            System.out.println("You are the winner");
        } else {
            System.out.println("Computer wins!");
        }

    }

    private static void go() {
        
        PentagoGame currentTree = new PentagoGame(table);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while (table.isWinner() == 0) {
            if (turnPlayer == 1) {
               guest(in,currentTree,input);
            } else 
            {
                computer(in,currentTree,input);
            }

        }
        if (table.isWinner() == 1) {
            System.out.println("You are the winner!");
        } else {
            System.out.println("Computer wins!");
        }
    }

}
