Solution of Clément Mihailescu's YouTube video
"Medium Google Coding Interview" in Java.

https://www.youtube.com/watch?v=4tYoVx0QoN0&ab_channel=Cl%C3%A9mentMihailescu

## Problem: convert 1's that are not adjacent to the 1's at the boundaries to zero.
## Diagonal adjacency is not accepted.Just Up, Right Left and Down

### Sample input

    1 0 0 0 0 0
    0 1 0 1 1 1 
    0 0 1 0 1 0 
    1 1 0 0 1 0 
    1 0 1 1 0 0 
    1 0 0 0 0 1 

### Sample Output

    1 0 0 0 0 0
    0 0 0 1 1 1
    0 0 0 0 1 0
    1 1 0 0 1 0
    1 0 0 0 0 0
    1 0 0 0 0 1
