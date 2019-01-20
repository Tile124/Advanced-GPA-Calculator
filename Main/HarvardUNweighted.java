import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.*;
/**
 * Component 1. HarvardUNWeightedGPA Calculator
 *
 * @author Ryan A. Rodriguez
 * @version Last Revised 1/20/2019
 */
public class HarvardUNweighted
{
    public static double harvardUNweightedCalculater(String fileName) throws IOException{
        File transcript = new File(fileName);
        Scanner inTxtFile = new Scanner(transcript);
        double unWeightedGPA = 0.0;
        int counter = 0;
        int lines = lineFinder(fileName) -1;
        
        // Settings
        double A_Level = 4.0;
        double Bplus_Level = 3.3;
        double B_Level = 3.0;
        double Cplus_Level = 2.3;
        double C_Level = 2.0;
        double Dplus_Level = 1.3;
        double D_Level = 1.0;
        double F_Level = 0.0;
        
        while (counter != lines){
          String currentCourse = inTxtFile.next();
          System.out.print("Detected: " + currentCourse);
          
          String tempGrade = inTxtFile.next();
          
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
          int classType = inTxtFile.nextInt();
          if (classType == 0) {
            System.out.println(" Regular");  
            }else if (classType == 1) {
            System.out.println(" Local Honors");  
            }else if (classType == 2) {
                System.out.println(" Honors");  
            }else if (classType == 3) {
                System.out.println(" AP / Dual Enrollment");  
            }
          
          counter++;
    }
    
    return (unWeightedGPA / counter);
}
    
    public static int lineFinder(String fileName) throws IOException{
     BufferedReader reader = new BufferedReader(new FileReader(fileName));
     int lines = 0;
     while (reader.readLine() != null) lines++;
     reader.close();
     return lines;
        
    }
}
