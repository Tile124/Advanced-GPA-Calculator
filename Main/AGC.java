import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Advanced GPA Calculator
 *
 * @author Ryan A. Rodriguez
 * @version Development 1 (1/20/2019)
 */
public class AGC
{
    
    
    public static void main (String[] args) throws IOException{
    System.out.println(Interface());
        
        
    }
    
    public static double Interface() throws IOException{
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><>");
        System.out.printf("%-8s", "Advanced GPA Calculator \n");
        System.out.printf("%-8s", "Version: DEV 1.0 \n");
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><> \n");
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("[1] Convert to Harvard UNweighted GPA scale");
        
        int interfaceInput = in.nextInt();
        
        System.out.println("What file name?");
        String filename = in.next();
        
        double GPA = classCaller(interfaceInput, filename);
        return GPA;
    }
    
    public static double classCaller(int calculationType, String filename)throws IOException{
     
        if (calculationType == 1) {
            HarvardUNweighted calc = new HarvardUNweighted();
            double GPA = calc.harvardUNweightedCalculater(filename);
            return GPA;
        }
        
        
        return 0.0;
    }
    
}
