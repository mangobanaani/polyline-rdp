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

import java.util.*;

/**
 *
 * @author mangobanaani
 * @version 1.1
 * 
 */
public final class Line {
    private Point start;
    private Point end;
    
    private double dx;
    private double dy;
    private double sxey;
    private double exsy;
    private double length;

    public Point getStart() { return start; }
    public Point getEnd() { return end; }
    public double getDx() { return dx; }
    public double getDy() { return dy; }
    public double getSxey() { return sxey; }
    public double getExsy() { return exsy; }
    public double getLength() { return length; }
    public void setStart(Point start) { this.start = start; }
    public void setEnd(Point end) { this.end = end; }
    public void setDx(double dx) { this.dx = dx; }
    public void setDy(double dy) { this.dy = dy; }
    public void setSxey(double sxey) { this.sxey = sxey; }
    public void setExsy(double exsy) { this.exsy = exsy; }
    public void setLength(double length) { this.length = length; }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.setDx(end.getX() - start.getX());
        this.setDy(start.getY() - end.getY());
        this.setSxey(start.getX() * end.getY());
        this.setExsy(end.getX() * start.getY());
        this.setLength(Math.sqrt(dx*dx + dy*dy));
    }

    public List<Point> asList() { // wrapper, return this object as java.util.List
        return Arrays.asList(getStart(), getEnd());
    }
    
    // distance is from furthest point to beginning point and endpoint divided by dist between start and end 
    double distance(Point p) {
        try{ 
            if (getLength() == 0.0) {
                // If start and end points are the same, return distance to that point
                double dx = p.getX() - start.getX();
                double dy = p.getY() - start.getY();
                return Math.sqrt(dx*dx + dy*dy);
            }
            return Math.abs(getDy() * p.getX() - getDx() * p.getY() + getSxey() - getExsy()) / getLength();
        }catch(Exception e){
            System.out.println("Error calculating distance: " + e.getLocalizedMessage());
        }
        return 0.0;
    }

}
