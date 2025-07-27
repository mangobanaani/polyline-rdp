# Polyline RDP - Ramer-Douglas-Peucker Algorithm

A Java implementation of the **Ramer-Douglas-Peucker** (RDP) algorithm for polyline simplification and smoothing.

## Overview

The Ramer-Douglas-Peucker algorithm is a line simplification algorithm that reduces the number of points in a curve while preserving its essential shape. It's widely used in cartography, computer graphics, and GPS track simplification.

## Features

- **Efficient polyline simplification** using the RDP algorithm
- **Configurable epsilon tolerance** for controlling simplification level
- **CSV file input support** for point data
- **Factory pattern implementation** for extensibility
- **Clean, well-documented Java code**

## Algorithm

The RDP algorithm works by:
1. Finding the point with the maximum distance from the line segment between the first and last points
2. If this distance is greater than epsilon (tolerance), recursively apply the algorithm to the segments before and after this point
3. If the distance is less than epsilon, remove all intermediate points

## Usage

### Command Line
```bash
javac *.java
java RDPTest [path_to_csv_file] [epsilon_value]
```

### Example
```bash
java RDPTest test_data.csv 1.5
```

### Input Format
CSV file with X,Y coordinates:
```
0.0,0.0
1.0,1.0
2.0,0.0
3.0,1.0
4.0,0.0
5.0,1.0
```

### Parameters
- **epsilon**: Tolerance value that controls the level of simplification
  - Smaller values = more points retained (less simplification)
  - Larger values = fewer points retained (more simplification)

## Classes

- `Point`: Represents a 2D point with X,Y coordinates
- `Line`: Represents a line segment with distance calculation methods
- `Simplifier`: Interface for simplification algorithms
- `RDPsimplifier`: Implementation of the Ramer-Douglas-Peucker algorithm
- `SimplificationFactory`: Factory for creating simplifier instances
- `RDPTest`: Main class for testing and command-line usage

## License

GNU General Public License v3.0 - see LICENSE file for details.

## Credits

- Version v1.1 by Mangobanaani 2015
- Based on work of Na Li 2015
