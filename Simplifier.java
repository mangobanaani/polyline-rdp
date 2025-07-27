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

import java.util.List;

/**
 *
 * @author mangobanaani
 * @version 1.1
 * 
 */
public interface Simplifier { // classes must implement these methods
    public List<Point> reduce(List<Point> points, double epsilon);
}
