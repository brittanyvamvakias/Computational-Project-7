import java.io.*;

public class Problem4 {
    public static void main(String[] args) { 
        double x = 0.5;
        double y = 0.5;
        double rdn;
        double x_new, y_new;
        int i;
        double[] a = {0.05,0.05,0.46,0.47,0.43,0.42};
        double[] b = {0.0,0.0,-0.15,-0.15,0.28,0.26};
        double[] ee = {0.0,0.0,0.0,0.0,0.0,0.0};
        double[] c = {0.0,0.0,0.39,0.17,-0.25,-0.35};
        double[] d = {0.6,-0.5,0.38,0.42,0.45,0.31};
        double[] f = {0.0,0.8,0.6,1.1,1.1,0.7};

  try{
      FileWriter wtraject = new FileWriter("Problem4.txt");
      BufferedWriter trajectout = new BufferedWriter(wtraject);
            for(int n = 0;n<20000;n++) {
                rdn = Math.random();
                if (rdn<0.10) { //transformation 1
                    i = 0;
                }
                else if (rdn<0.20) { //transformation 2
                    i = 1;
                }
                else if (rdn<0.40) { //transformation 3
                    i = 2;
                }
                else if (rdn<0.60) { //transformation 4
                    i = 3;
                }
                else if (rdn<0.90) { //transformation 5
                    i = 4;
                }
                else { //transformation 6
                    i = 5;
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
  

  