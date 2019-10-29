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
public interface HW3Maze {
 public void ReadMazeFromFile()throws IOException; // Maze file will be read
 public void SolveMaze(); // If there is a solution find
 public void PrintSolution(); // The solution will be printed 
}
