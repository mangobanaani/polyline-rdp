/*
    This file is part of RDP utility 

    Version v1.1 by Mangobanaani 2015

    Based on work of Na Li 2015

    RDP utility is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    RDP utility is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.mangobanaani;

import java.util.*;
import java.io.*;

/**
 *
 * @author mangobanaani
 * @version 1.1
 * 
 */
public class RDPTest {
    private static List<Point> readFile(String filename){
        List ll=new LinkedList();
        Point p;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = ""; // to hold single row
            String cvsSplitBy = ",";    // split by comma
            while ((line = in.readLine()) != null) {   // read the rows
                String tmp[]=line.split(cvsSplitBy);
                p=new Point(Double.parseDouble(tmp[0]),Double.parseDouble(tmp[1]));
                ll.add(p);
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File "+filename+" not found. \n" + e.getMessage());
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error reading file "+filename+" \n" + e.getMessage());
            System.exit(-1);
        }       
        return ll;
    }
    
    private static void printUsage(){
        System.out.println("usage java -jar RDP.jar [complete path to csv filename] [epsilion value]");
    }

    /**
     * Main method of the program 
     * @param args
     */
    public static void main(String[] args) {
        try{
            if(args.length<2){printUsage();System.exit(0);} // file argument given?
        }catch(Exception e){printUsage();System.exit(0);}
        
        SimplificationFactory sf=new SimplificationFactory();
        Simplifier sim=sf.getSimplifier("Ramer-Douglas-Peucker"); // get itf to RDP 
        
        Double epsilon=Double.parseDouble(args[1].trim()); // epsilon value to be used
        
        List ll=readFile(args[0].trim()); // list to hold the objects
        
        
        // print out points before start
        
        System.out.println("points in: ");
        Iterator itr=ll.iterator();             // iterate throught the list
        while(itr.hasNext()){                   // and print it out
            System.out.print(itr.next().toString());
        }

        long start=System.currentTimeMillis(); // store current time counter
        List<Point> result=new LinkedList<>();
        result=sim.reduce(ll, epsilon);          // call reduce with list, epsilon 4.0
        long end=System.currentTimeMillis(); // store current time counter
        
        // print out some stats what was just done 
        System.out.println(System.lineSeparator());
        System.out.println("Handled "+ll.size()+" items in "+(end-start)+"ms");
        System.out.println("Removed "+(ll.size()-result.size())+" points with epsilon of "+epsilon);
        System.out.println(System.lineSeparator());
        
        // print out resulting points
        System.out.println("points out: ");
        itr=result.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next().toString());
        }
    }
    
}
