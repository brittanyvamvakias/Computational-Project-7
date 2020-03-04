import java.io.*;

public class Problem1b {
    public static void main(String[] args) { 
          double t=0.;
          double start = 0.75;
          double end = 1.0;
          double range = end - start;
          double r = 0.9571;
          double dt=range/1000;
          double x0 = 0.1;
          double x = x0;
          double f3, f1, f2;
          double xplot;
          double i = 0;

  try{
      FileWriter wtraject = new FileWriter("problem1_b_extra.txt");
      BufferedWriter trajectout = new BufferedWriter(wtraject);
        for(double n = 0;n<1000;n++) {
            f1 = 4.0 * r * x * (1 - x);
            f2 = 4.0 * r * f1 * (1 - f1);
            f3 = 4.0 * r * f2 * (1 - f2);
            trajectout.write(i+ " " + f3);
            trajectout.newLine();
            i += 1;
            x = f3;
            }// end of the inner for-loop
        
      trajectout.close(); 
      
      }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
                         }
      System.out.println("  ");					      
      System.out.println("All done!");
                        }
                     }
  
  
  