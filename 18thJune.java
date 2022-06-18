Longest Possible Route in a Matrix with Hurdles 

Given an N x M matrix, with a few hurdles(denoted by 0) arbitrarily placed, calculate the length of the longest possible route
possible from source(xs,ys) to a destination(xd,yd) within the matrix. We are allowed to move to only adjacent cells which are not
hurdles. The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.
If it is impossible to reach the destination from the source return -1.

 

Example 1:

Input:
{xs,ys} = {0,0}
{xd,yd} = {1,8}
matrix = 1 1 1 1 1 1 1 1 1 1
         1 1 0 1 1 0 1 1 0 1
         1 1 1 1 1 1 1 1 1 1
Output: 24
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
A:  class Solution {
    public static boolean isSafe(int mat[][], boolean visited[][], int x, int y) {
        if (x >= 0 && x <= mat.length - 1 && y >= 0 && y <= mat[0].length - 1 && mat[x][y] == 1 && visited[x][y] == false)
            return true;
        return false;
    }

    public static int findLongestPathUtil(int mat[][], boolean visited[][], int i, int j, int x, int y, int maxDist,int Dist) 
    {
        if (mat[i][j] == 0)
            return 0;
        if (i == x && j == y)
            return Integer.max(Dist, maxDist);

        visited[i][j] = true;

        // Down
        if (isSafe(mat, visited, i + 1, j)) {
            maxDist = findLongestPathUtil(mat, visited, i + 1, j, x, y, maxDist, Dist + 1);
        }

        // Left
        if (isSafe(mat, visited, i, j - 1)) {
            maxDist = findLongestPathUtil(mat, visited, i, j-1, x, y, maxDist, Dist + 1);
        }

        // Right
        if (isSafe(mat, visited, i, j + 1)) {
            maxDist = findLongestPathUtil(mat, visited, i, j + 1, x, y, maxDist, Dist + 1);
        }

        // Up
        if (isSafe(mat, visited, i - 1, j)) {
            maxDist = findLongestPathUtil(mat, visited, i - 1, j, x, y, maxDist, Dist + 1);
        }

        visited[i][j] = false;
        return maxDist;
    }
    
    public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        if(mat==null || mat.length==0 || mat[xs][ys]==0 || mat[xd][yd]==0)
        return -1;
        boolean visited[][]=new boolean[n][m];
        return findLongestPathUtil(mat,visited,xs,ys,xd,yd,0,0);
    }
}
