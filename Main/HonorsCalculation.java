import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.*;
/**
 * Determines amount of Honors classes needed to achieve a certain GPA
 *
 * @Ryan A. Rodriguez 
 * @version 1 (2/1/2019)
 */
public class HonorsCalculation
{
    public static int HonorsClassesNeeded(String fileName, int type, double desiredGPA) throws IOException, InterruptedException {
        BrowardWeighted weightedAccessPanel = new BrowardWeighted();
        double classes = weightedAccessPanel.lineFinder(fileName);
        double WeightedGPA = weightedAccessPanel.BrowardWeightedCalculator(fileName);
        int additionalClassCount = 0;
        double rawScore = (WeightedGPA * classes);
        double newRawScore = rawScore;
        System.out.println("Current GPA: "+ WeightedGPA);
        while (WeightedGPA < desiredGPA) {
            System.out.println("Loop "+ additionalClassCount);
            classes += 1;
            newRawScore += 6;
            WeightedGPA = newRawScore / classes;
            additionalClassCount++;
            System.out.println(WeightedGPA);
        }
        
        return additionalClassCount;
    }
}
