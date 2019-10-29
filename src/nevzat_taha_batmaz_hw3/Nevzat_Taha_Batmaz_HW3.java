/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nevzat_taha_batmaz_hw3;

import java.io.IOException;

/**
 *
 * @author Taha
 */
public class Nevzat_Taha_Batmaz_HW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        DataBase mydb = new DataBase();
        mydb.ReadMazeFromFile();
        mydb.SolveMaze();
        mydb.PrintSolution();
        // TODO code application logic here
    }
    
}
