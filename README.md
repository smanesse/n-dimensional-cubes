# n-dimensional-cubes
In my linear algebra class, we were required to infer the number of vertices, edges, faces, and
cubes in a 4-dimensional hypercube. This got me thinking about what a formula might be for each of
those values. After analyzing a table of values on Wikipedia, I found a pattern and wrote a program
to tell the number of n dimensional faces (vertices, edges, faces, cubes, etc.) in a m-dimensional
cube. It takes two parameters (dimensions of each figure) and outputs the number of instances of
the child figure in the parent.