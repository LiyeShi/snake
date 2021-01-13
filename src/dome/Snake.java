package dome;

/**
 * @program: snake
 * @description:
 * @author: stone
 * @create: 2021-01-13 12:38
 **/
public class Snake {
    //    蛇的长度
    private int length;
    //    存放蛇 头和身体的坐标
    private int[] snakeX;
    private int[] snakeY;
    //    蛇的生命状态
    private boolean isLive;
    //    蛇的前进方向
    private String direction;

    public Snake(int snakeLength, boolean isLive) {
        if (snakeLength==5) {
//            初始最长就是四节
            snakeLength=4;
        }else {
            this.length = snakeLength;
        }
            this.isLive = isLive;
//      存放蛇头和每节身体的坐标数组
        snakeX = new int[600];
        snakeY = new int[600];
        int startPointX=100;
        int startPointY=100;
//        初始蛇的坐标  头和身体 纵坐标不变 横坐标每个相差25
        for (int i = 0; i < snakeLength; i++) {
            snakeX[i] = startPointX;
            snakeY[i]=startPointY;
            startPointX-=25;
        }
//        默认方向向右走
        setDirection("R");
    }


    public void grow() {
        length++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int snakeLength) {
        this.length = snakeLength;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLiveState(boolean live) {
        isLive = live;
    }

    public int[] getSnakeX() {
        return snakeX;
    }

    public int[] getSnakeY() {
        return snakeY;
    }
    public void setSnakeX(int[] snakeX) {
        this.snakeX = snakeX;
    }



    public void setSnakeY(int[] snakeY) {
        this.snakeY = snakeY;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
