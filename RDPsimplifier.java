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

/**
 *
 * @author mangobanaani
 * @version 1.1
 * 
 */
public class RDPsimplifier implements Simplifier{
   /**
     * Reduces number of points using Ramer-Douglas-Peucker algorithm
     * @param points as list
     * @param epsilon
     * @return list of reduced points
     */
    @Override
    public List<Point> reduce(List<Point> points, double epsilon)  {
        double furthestPointDistance = 0.0; // distance to furthest point from start
        int furthestPointIndex = 0;         // index of furthest point
        Point first=points.get(0);          // first point in list, fetch
        Point second=points.get(points.size()-1);    // last point in list, fetch
        Line line;
        line = new Line(first,second);      // define line between first and last point
        
        for (int x = 1; x < points.size() - 1; x++) { // go through the points from beginning
            double distance = line.distance(points.get(x)); // what if the pendicular distance to this
            if (distance > furthestPointDistance ) { // store the distance
                furthestPointDistance = distance;    // and when all list have been crawled through 
                furthestPointIndex = x;              // we got the point with of maximum distance here
            }
        }
        if (furthestPointDistance > epsilon) {  // if maximum distance > epsilon 
            List<Point> reduced1 = reduce(points.subList(0, furthestPointIndex+1), epsilon); // call self w/ points from beginning to the max distance point+1
            List<Point> reduced2 = reduce(points.subList(furthestPointIndex, points.size()), epsilon); // and store points after to end that to another list
            List<Point> result = new ArrayList<>(reduced1); // combine the arrays with points left 
            result.addAll(reduced2.subList(1, reduced2.size())); // and fall out from method
            return result; 
        } else {
            return line.asList(); 
        }
    }
}

