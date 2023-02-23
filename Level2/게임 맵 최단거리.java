import java.util.*;

class Solution {
    int visited[][] = new int[101][101];
    int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void bfs(int[][] maps) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        
        Queue<Node> q = new LinkedList();
        q.add(new Node(x, y));
        
        while (!q.isEmpty()) {
            Node n = q.remove();
            
            for (int i = 0; i < 4; i++) {
                int nX = n.getX() + direction[i][0];
                int nY = n.getY() + direction[i][1];
                
                if (nX < 0 || nX >= maps.length || nY < 0 || nY >= maps[0].length)
                    continue;
                
                if (visited[nX][nY] != 0 || maps[nX][nY] == 0)
                    continue;
                
                visited[nX][nY] = visited[n.getX()][n.getY()] + 1;
                q.add(new Node(nX, nY));
            }
        }
    }
    
    public int solution(int[][] maps) {
        
        bfs(maps);
        
        return (visited[maps.length-1][maps[0].length-1] == 0) ? -1 : visited[maps.length-1][maps[0].length-1];
    }
    
    class Node {
        private int x;
        private int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
    }
}
