import java.io.*;

public class Problem1a {
    public static void main(String[] args) { 
          double t=0.;
          double start = 0.75;
          double end = 1.0;
          double range = end - start;
          double dt=range/1000;
          double x0 = 0.7;
          double x = x0;
          final double rcos = Math.cos(3.141592653*76.11/180.0);
          final double rsin = Math.sin(3.141592653*76.11/180.0);
          double [] y0 = {0.1, 0.2, 0.3, 0.4, 0.441, 0.442, 0.5, 0.6, 0.65, 0.66, 0.665,
            0.67, 0.68, 0.69, 0.71, 0.715, 0.72, 0.725, 0.73, 0.735};
          double n;
          double xplot;

  try{
      FileWriter wtraject = new FileWriter("bifur.txt");
      BufferedWriter trajectout = new BufferedWriter(wtraject);
        for(double r = start;r<end;r += dt) {
            x = x0;
                if (r > 0.891) {
                    for(n=0;n<601;n++) {
                        x = 4.0 * r * x * (1-x);
                        if (n>400) {
                            trajectout.write(r+ " " + x);
                            trajectout.newLine();
                        }
                }
            }
                else {
                    for(n=0;n<81;n++) {
                        x = 4.0 * r * x * (1-x);
                        if (n>70) {
                            trajectout.write(r+ " " + x);
                            trajectout.newLine();
                        }
                    }
                }

            }// end of the inner for-loop
        
      trajectout.close(); 
      
      }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
                         }
      System.out.println("  ");					      
      System.out.println("All done!");
                        }
                     }
  
  
  