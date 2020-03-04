/*
 * Open Source Physics software is free software as described near the bottom of this code file.
 *
 * For additional information and documentation on Open Source Physics please see: 
 * <http://www.opensourcephysics.org/>
 */

import org.opensourcephysics.controls.*;
import org.opensourcephysics.frames.PlotFrame;

/**
 * GraphicalSolutionApp presents a graphical solution to the logistic map.
 *
 * @author Wolfgang Christian, Jan Tobochnik, Harvey Gould
 * @version 1.0  revised 03/23/05
 */
public class FractalApp extends AbstractSimulation {
  PlotFrame plotFrame = new PlotFrame("x", "f(x)", "Fern Fractal");
  double r;    // control parameter
  double x, y;
  double x0, y0;
  double rdn;
  double x_new, y_new;
  int i;
  double[] a = {0.80,0.23,0.23,0.0};
  double[] b = {0.04,-0.23,0.23,0.0};
  double[] e = {0.0,0.0,0.0,0.0};
  double[] c = {-0.04,0.23,-0.23,0.0};
  double[] d = {0.80,0.23,0.23,0.25};
  double[] f = {0.20,0.15,0.18,0.0};


  public FractalApp() {
    plotFrame.setPreferredMinMax(0, 1, 0, 1);
    plotFrame.setConnected(true);
    plotFrame.setXPointsLinked(true);
    plotFrame.setMarkerShape(0, 0); // second argument indicates no marker
    plotFrame.setMarkerShape(2, 0);
  }

  public void reset() { // resets the plot
    control.setValue("x", 0.5);
    control.setValue("y", 0.5);
  }

  public void initialize() { // initializes the plot
    x = control.getDouble("x");
    y = control.getDouble("y");
    x0 = x;
    y0 = y;
    clear();
  }



//   void drawLine() { // draws line y = x
//     for(double x = 0;x<1;x += 0.001) {
//       plotFrame.append(2, x, x);
//     }
//   }

  public void transformation() {
    rdn = Math.random();
    if (rdn<0.75) { //transformation 1
        i = 0;
    }
    else if (rdn<0.85) { //transformation 2
        i = 1;
    }
    else if (rdn<0.95) { //transformation 3
        i = 2;
    }
    else { //transformation 4
       i = 3;
    }
    x_new = a[i]*x + b[i]*y + e[i];
    y_new = c[i]*x + d[i]*y + f[i];
    x = x_new;
    y = y_new;
    
  }

  void drawFunction() {
    int nplot = 10000; // # of points at which function computed
    double delta = 1.0/nplot;
    double x = 0;
    double y = 0;
    for(int i = 0;i<=nplot;i++) {
      transformation();
      if (i>=100) {
        plotFrame.append(0, x, y); 
    }
  }
}

  public void clear() {
    plotFrame.clearData();
    drawFunction();
    plotFrame.repaint();
  }

  public static void main(String[] args) {
    SimulationControl control = SimulationControl.createApp(new FractalApp());
    control.addButton("clear", "Clear", "Clears the trajectory.");
  }
}


/* 
 * Open Source Physics software is free software; you can redistribute
 * it and/or modify it under the terms of the GNU General Public License (GPL) as
 * published by the Free Software Foundation; either version 2 of the License,
 * or(at your option) any later version.

 * Code that uses any portion of the code in the org.opensourcephysics package
 * or any subpackage (subdirectory) of this package must must also be be released
 * under the GNU GPL license.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston MA 02111-1307 USA
 * or view the license online at http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2007  The Open Source Physics project
 *                     http://www.opensourcephysics.org
 */
