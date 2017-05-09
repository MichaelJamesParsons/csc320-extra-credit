# Box Stacking
O(n<sup>2</sup>)

###### Recursive Definition
H(j) = max{ H(i) } + h <sub>j</sub>, where, W<sub>i</sub> > W<sub>j</sub>, D<sub>i</sub> > D<sub>j</sub>

# Building Bridges
O(n<sup>2</sup>) or O(nlgn) for optimized solutions

###### Recursive Definition

@TODO!

# Integer Knapsack
O(nC)

###### Recursive Definition
M(i,j) = max{ M(i-1,j), M(i-1, j-S<sub>i</sub>) + V<sub>i</sub> }

# Balanced Partition
O(n<sup>2</sup>k)

###### Recursive definition
M(i,j) = max{ M(i-1,j), M(i-1, j-S<sub>i</sub>) + V<sub>i</sub> }

# Edit Distance
O(nm)

###### Recursive Definition
    T(i,j) = min {
                C<sub>d</sub> + T(i-1,j)
                T(i,j-1) + C<sub>i</sub>
                {
                    T(i-1,j-1), if A[i] == B[i],
                    T(i-1,j-1) + C<sub>r</sub>, if A[i] != B[i]
                }
             }

# Counting Parenthesizations
O(n<sup>3</sup>)

###### Recursive Definition
    Base Case
        T(i,i) = {
                    1, if symbol = T
                    0, if symbol = F
                 }
               
    T(i,j) = sum i <= k <= j-1 {
                T(i,k)*T(k+1,j),
                [T(i,k)+F(i,k)][T(k+1,j)+F(k+1,j)]-[F(i,k)F(k+1,j)],
                T(i,k)F(k+1,j)+F(i,k)T(k+1,j)
             }