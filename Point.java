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

/**
 *
 * @author mangobanaani
 * @version 1.1
 * 
 */
public class Point {
    private double x;
    private double y;

    Point(){}; // empty constructor if ever needed
    Point(double x, double y){ // default constructor
        this.x=x;
        this.y=y;
    };
    
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    
    @Override
    public String toString(){
        return "\n\r"+(int)this.getX()+","+(int)this.getY(); // get rounded values, for debugging
    }
}
