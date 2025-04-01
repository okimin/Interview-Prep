class RobotBound{
    public boolean isRobotBounded(String instructions) {
        int [][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int dir = 0;
        int x = 0;
        int y = 0;

        for(char c : instructions.toCharArray()){
            if(c == 'L')
                dir--;
            else if(c == 'R')
                dir++;
            else{
                x += directions[dir%4][0];
                y += directions[dir%4][0];
            }
        }
        if((dir %4) == 0 && !(x==0 && y==0))
            return false;
        return true;
    }
}