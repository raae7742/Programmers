import java.util.*;

class Solution {
    class Path {
        int startX;
        int startY;
        int endX;
        int endY;
        
        public Path(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
        
        @Override
        public int hashCode() {
            return Integer.toString(startX).hashCode()
                + Integer.toString(startY).hashCode()
                + Integer.toString(endX).hashCode()
                + Integer.toString(endY).hashCode();
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Path) {
                Path p = (Path)obj;
                return (this.startX == p.startX && this.startY == p.startY
                        && this.endX == p.endX && this.endY == p.endY) ||
                       (this.startX == p.endX && this.startY == p.endY
                        && this.endX == p.startX && this.endY == p.startY); 
            }
            return false;
        }
    }
    
    public int solution(String dirs) {
        Set<Path> set = new HashSet();
        
        int x = 0;
        int y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            switch(dirs.charAt(i)) {
                case 'U':
                    if (y+1 < 6) {
                        set.add(new Path(x, y, x, y+1));
                        y = y+1;
                    }
                    break;
                case 'D':                    
                    if (y-1 >= -5) {
                        set.add(new Path(x, y, x, y-1));
                        y = y-1;
                    }
                    break;
                case 'R':                    
                    if (x+1 < 6) {
                        set.add(new Path(x, y, x+1, y));
                        x = x+1;
                    }
                    break;
                case 'L':                    
                    if (x-1 >= -5) {
                        int newY = y;
                        set.add(new Path(x, y, x-1, y));
                        x = x-1;
                    }
                    break;
            }
        }
        
        return set.size();
    }
}
