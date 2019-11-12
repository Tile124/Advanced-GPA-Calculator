import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Advanced GPA Calculator
 *
 * @author Ryan A. Rodriguez
 * @version Release 1.0 (11/01/2019)
 */
public class AGC
{
    
    
    public static void main (String[] args) throws IOException,InterruptedException{
    // Enable only for testing
        System.out.println("[1] Convert to College UNweighted GPA scale");
        System.out.println("[2] Convert to Broward UNweighted GPA scale");
        System.out.println("[3] Convert to Broward Weighted GPA scale");
        System.out.println("[4] Convert to Broward Academic Core (Always Weighted)");
        System.out.println("[5] (NEW) Determine amount of Honors classes needed to get specific GPA");
        System.out.println("[9] Terminate Program");
        System.out.println("NOTE: YOU ARE CURRENTLY IN DEVELOPMENT MODE. MOST OF THE GUI HAS BEEN OMMITED FOR TESTING");
        System.out.println("DEV MODE: Input A = RYANTRANSCRIPT.TXT ||| B = RYANTRANSCRIPTFUTURE.TXT");
        while(true == true) {
        System.out.println(Interface());
    }
        
    }
    
    public static double Interface() throws IOException,InterruptedException{
        //System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
        //System.out.printf("%-8s", "Advanced GPA Calculator \n");
        //System.out.printf("%-8s", "Version: 1 \n");
        //System.out.println("<><><><><><><><><><><><><><><><><><><><><><> \n");
        Scanner in = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Calc_type:");
        int interfaceInput = in.nextInt();
        System.out.println("File:");
        String filename = in.next();
        
        // Enable only for testing mode only
         if (filename.equals("a")) {filename = ("RyanTranscript.txt");};
         if (filename.equals("b")) {filename = ("RyanTranscriptFuture.txt");};
        
        double GPA = classCaller(interfaceInput, filename);
        return GPA;
    }
    
    public static double classCaller(int calculationType, String filename)throws IOException,InterruptedException{
     Scanner in = new Scanner(System.in);
        if (calculationType == 1) {
            CollegeUNweighted calc = new CollegeUNweighted();
            double GPA = calc.CollegeUNweightedCalculator(filename);
            return GPA;
        }
        if (calculationType == 2) {
            BrowardUNWeighted calc = new BrowardUNWeighted();
            double GPA = calc.BrowardUNWeightedCalculator(filename);
            return GPA;
        }
        if (calculationType == 3) {
            BrowardWeighted calc = new BrowardWeighted();
            double GPA = calc.BrowardWeightedCalculator(filename);
            return GPA;
        }
        if (calculationType == 4) {
            BrowardAcademicCore calc = new BrowardAcademicCore();
            double GPA = calc.BrowardAcademicCore(filename);
            return GPA;
        }
        if (calculationType == 5) {
            System.out.println("[1]Weighted or [2]UnWeighted?");
            int calcType = in.nextInt();
            System.out.println("Desired GPA");
            double desiredGPA = in.nextDouble();
            if (calcType == 2 && desiredGPA > 4.0) {
                System.out.println("Bro please enter a realistic unweighted gpa");
                System.exit(0);
            }
            HonorsCalculation honorsCalc = new HonorsCalculation();
            System.out.println("Called HonorsCalculation");
            int honorsClassesNeeded = honorsCalc.HonorsClassesNeeded(filename, calcType, desiredGPA);
            return honorsClassesNeeded;
        }
        if (calculationType == 9) {
            System.exit(0);
        }
        
        
        return -1.001;
    }
    
    public static void endStatement(){
        System.out.println("What would you like to do now?");
        System.out.println("[1] Calculate amount of Honors Classes needed ");
        System.out.println("[2] ");
        System.out.println("[3] Convert to Broward Weighted GPA scale");
    }
    
}
