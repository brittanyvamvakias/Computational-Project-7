import java.io.*;

public class FractalApp_1 {
    public static void main(String[] args) { 
        double x = 0.5;
        double y = 0.5;
        double rdn;
        double x_new, y_new;
        int i;
        double[] a = {0.80,0.23,0.23,0.0};
        double[] b = {0.04,-0.23,0.23,0.0};
        double[] ee = {0.0,0.0,0.0,0.0};
        double[] c = {-0.04,0.23,-0.53,0.0};
        double[] d = {0.80,0.53,0.23,0.25};
        double[] f = {0.20,0.15,0.18,0.0};

  try{
      FileWriter wtraject = new FileWriter("Problem3e.txt");
      BufferedWriter trajectout = new BufferedWriter(wtraject);
            for(int n = 0;n<20000;n++) {
                rdn = Math.random();
                if (rdn<0.50) { //transformation 1
                    i = 0;
                }
                else if (rdn<0.60) { //transformation 2
                    i = 1;
                }
                else if (rdn<0.85) { //transformation 3
                    i = 2;
                }
                else { //transformation 4
                i = 3;
                }
                x_new = a[i]*x + b[i]*y + ee[i];
                y_new = c[i]*x + d[i]*y + f[i];
                x = x_new;
                y = y_new;
                
                if(n>=100){
                    trajectout.write(x+ " " + y);
                    trajectout.newLine();
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
  

  