#our method is to DFS through each unvisited black spot and increase our counter by one
inp = input().split()
m,n = [int(i) for i in inp]

grid = [] #storing the grid here
for i in range(0,m):
    grid.append(input())

visited = [[False]*len(grid[0]) for i in range(len(grid))] #this 2d array will let us keep track of which nodes were visited
count = 0

def DFS(i, j, grid,visited):
    #if we are out of bounds, or we have already been visited, or our value is not # then do not do a dfs from here
    if(i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or visited[i][j] or grid[i][j] != '#'):
        return

    visited[i][j] = True #mark ourselves as visited

    #doing a DFS from all of our adjacent nodes
    DFS(i+1,j,grid,visited)
    DFS(i-1,j,grid,visited)
    DFS(i,j+1,grid,visited)
    DFS(i,j-1,grid,visited)
    DFS(i-1,j-1,grid,visited)
    DFS(i+1,j-1,grid,visited)
    DFS(i-1,j+1,grid,visited)
    DFS(i+1,j+1,grid,visited)

    return

for i in range(0,len(grid)):
    for j in range(0,len(grid[i])):
        if(not visited[i][j] and grid[i][j] == '#'):
            DFS(i,j,grid,visited)
            count += 1

print(count) 
