import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Advanced GPA Calculator
 *
 * @author Ryan A. Rodriguez
 * @version Release 1.0 (1/21/2019)
 */
public class AGC
{
    
    
    public static void main (String[] args) throws IOException,InterruptedException{
    System.out.println(Interface());
        
        
    }
    
    public static double Interface() throws IOException,InterruptedException{
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
        System.out.printf("%-8s", "Advanced GPA Calculator \n");
        System.out.printf("%-8s", "Version: 1 \n");
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><> \n");
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("[1] Convert to College UNweighted GPA scale");
        System.out.println("[2] Convert to Broward UNweighted GPA scale");
        System.out.println("[3] Convert to Broward Weighted GPA scale");
        int interfaceInput = in.nextInt();
        
        System.out.println("What file name?");
        String filename = in.next();
        
        double GPA = classCaller(interfaceInput, filename);
        return GPA;
    }
    
    public static double classCaller(int calculationType, String filename)throws IOException,InterruptedException{
     
        if (calculationType == 1) {
            HarvardUNweighted calc = new HarvardUNweighted();
            double GPA = calc.harvardUNweightedCalculator(filename);
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
        
        
        return 0.0;
    }
    
    public static void endStatement(){
        System.out.println("What would you like to do now?");
        System.out.println("[1] Calculate amount of Honors Classes needed ");
        System.out.println("[2] ");
        System.out.println("[3] Convert to Broward Weighted GPA scale");
    }
    
}
