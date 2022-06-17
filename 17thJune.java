Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
 

Example 1:

Input: 

      0
     / \
    1    2
Output: 1
Explanation: The given graph can be colored 
in two colors so, it is a bipartite graph.
Example 2:

Input:

      0   1
     / \ /
    2---3
Output: 0
Explanation: The given graph cannot be colored 
in two colors such that color of adjacent 
vertices differs. 
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
Code:

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[]=new int[V];
        Arrays.fill(color,0);
        for(int i=0;i<V;i++)
        {
            if(color[i]==0)
            {
                color[i]=1;
                if(!dfs(i,adj,color))
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int vertex,ArrayList<ArrayList<Integer>>adj,int color[])
    {
        ArrayList<Integer>neighbours=adj.get(vertex);
        for(int neighbour:neighbours)
        {
           if(color[neighbour]==color[vertex])
           {
               return false;
           }
           else if(color[neighbour]==0)
           {
               color[neighbour]=(color[vertex]==1)?2:1;
               if(!dfs(neighbour,adj,color))
               return false;
           }
        }
        return true;
    }
}
