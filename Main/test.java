import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.*;
/**
 * For testing purposes
 *
 * @author Ryan A. Rodriguez
 * @version 1/20/2019
 */
public class test
{
    public static void main(String[] args) throws IOException{
        File transcript = new File("test.txt");
        Scanner inTxtFile = new Scanner(transcript);
        double unweightedGPA = 0.0;
        int counter = 0;
        int lines = lineFinder("test.txt");
        // Settings
        double A_Level = 4.0;
        
        while (counter != lines){
          System.out.print("Detected: " + inTxtFile.next());
          
          String tempGrade = inTxtFile.next();
          
          if (tempGrade.equals("A")){
               
            }
          
          System.out.println(inTxtFile.nextInt());
          
          counter++;
        }
        
        
        
    }

    
    public static int lineFinder(String fileName) throws IOException{
     BufferedReader reader = new BufferedReader(new FileReader(fileName));
     int lines = 0;
     while (reader.readLine() != null) lines++;
     reader.close();
     return lines;
        
    }
}
