import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.*;
/**
 * Calculates *Weighted* Academic Core GPA in Broward County
 *
 * @author Ryan A. Rodriguez
 * @version Last revised 1/20/2019
 */
public class BrowardAcademicCore
{
    public static double BrowardAcademicCore(String fileName) throws IOException,InterruptedException{
        File transcript = new File(fileName);
        Scanner inTxtFile = new Scanner(transcript);
        double unWeightedGPA = 0.0;
        int counter = 0;
        int classCounter = 0;
        int lines = lineFinder(fileName);
        
        // Settings
        double A_Level = 4.0;
        double Bplus_Level = 3.0;
        double B_Level = 3.0;
        double Cplus_Level = 2.0;
        double C_Level = 2.0;
        double Dplus_Level = 1.0;
        double D_Level = 1.0;
        double F_Level = 0.0;
        
        while (counter != lines){
          String currentCourse = inTxtFile.next();
         // System.out.println("Loaded: " + currentCourse);
          
          String tempGrade = inTxtFile.next();
          int classType = inTxtFile.nextInt();
          String academic = inTxtFile.next();
          if (academic.equals("Y")){
          if (tempGrade.equals("A")){
               unWeightedGPA += A_Level;
            }else if (tempGrade.equals("B+")){
                unWeightedGPA += Bplus_Level;
            }else if (tempGrade.equals("B")){
                unWeightedGPA += B_Level;
            }else if (tempGrade.equals("C+")){
                unWeightedGPA += Cplus_Level;
            }else if (tempGrade.equals("C")){
                unWeightedGPA += C_Level;
            }else if (tempGrade.equals("D+")){
                unWeightedGPA += Dplus_Level;
            }else if (tempGrade.equals("D")){
                unWeightedGPA += D_Level;
            }else if (tempGrade.equals("F")){
                unWeightedGPA += F_Level;
            }else {
             System.out.println("A SERIOUS ERROR OCCURED! INVALID GRADE FORMATTING FOR CLASS: " + currentCourse);
             System.out.println("Restart program and fix error");
             System.exit(0);
            }
            
            if ((classType == 2) || (classType == 3)) {
            unWeightedGPA += 0.5;
            }
            classCounter++;
        }
          counter++;
    }
    inTxtFile.close();
    System.out.println("DEV: Raw GPACount = " + unWeightedGPA);
    System.out.println("DEV: Raw ClassCount " + classCounter);
    return (unWeightedGPA / classCounter);
}
    
    public static int lineFinder(String fileName) throws IOException{
     BufferedReader reader = new BufferedReader(new FileReader(fileName));
     int lines = 0;
     while (reader.readLine() != null) lines++;
     reader.close();
     return lines;
        
    }
}
