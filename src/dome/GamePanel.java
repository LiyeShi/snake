package dome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @program: snake
 * @description:
 * @author: stone
 * @create: 2021-01-12 13:30
 **/
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //    记录游戏状态
    boolean isStart = false;
    //    食物的坐标
    int foodX, foodY;
    //    定时器
    Timer timer = new Timer(100, this);
    private Random random;
    private Snake snake;

    public GamePanel() {
        random = new Random();
        setFocusable(true);
        addKeyListener(this);
        init();
    }


    public void init() {
//        初始化蛇
        snake = new Snake(3, true);
//        生成食物的坐标
        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);
//        启动定时器
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        setBackground(Color.WHITE);
//        游戏区域
        g.fillRect(25, 75, 850, 600);
//        显示游戏标题
        g.setFont(new Font("宋体", Font.BOLD, 50));
        g.drawString("贪吃蛇小游戏", 140, 50);
//        游戏没有开始 显示开始游戏的提示信息
        if (!isStart) {
            g.setColor(Color.WHITE);
            g.drawString("按下空格键开始游戏", 300, 300);
        }
//        如果游戏失败了，绘制红色提示字体
        if (!snake.isLive()) {
            g.setColor(Color.RED);
            g.drawString("游戏失败，按下空格键重新开始", 300, 300);
        }

//        画出小蛇的头
        if (snake.getDirection().equals("R")) {
            GameDatas.iconRight.paintIcon(this, g, snake.getSnakeX()[0], snake.getSnakeY()[0]);
        } else if (snake.getDirection().equals("L")) {
            GameDatas.iconLfet.paintIcon(this, g, snake.getSnakeX()[0], snake.getSnakeY()[0]);
        } else if (snake.getDirection().equals("U")) {
            GameDatas.iconUp.paintIcon(this, g, snake.getSnakeX()[0], snake.getSnakeY()[0]);
        } else {
            GameDatas.iconDown.paintIcon(this, g, snake.getSnakeX()[0], snake.getSnakeY()[0]);
        }
//        画出小蛇的身体
        for (int i = 1; i < snake.getLength(); i++) {
            GameDatas.iconBody.paintIcon(this, g, snake.getSnakeX()[i], snake.getSnakeY()[i]);
        }
//        绘制食物
        GameDatas.iconFood.paintIcon(this, g, foodX, foodY);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //获得键盘按键
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
//        如果点击了空格 两种情况 开始游戏或者重新开始游戏
        if (keyCode == KeyEvent.VK_SPACE) {
            if (snake.isLive()) {
//      游戏中途点击了空格键 切换游戏状态
                isStart = !isStart;
            } else {
//       游戏失败后点击了空格键，重新开始游戏
                init();
            }
//            重绘界面
            repaint();
        }
//        切换蛇的方向
        if (keyCode == KeyEvent.VK_LEFT) {
            snake.setDirection("L");
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            snake.setDirection("R");
        } else if (keyCode == KeyEvent.VK_UP) {
            snake.setDirection("U");
        } else if (keyCode == KeyEvent.VK_DOWN) {
            snake.setDirection("D");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
//每隔 0.1秒执行一次这个方法
    @Override
    public void actionPerformed(ActionEvent e) {
//        判断游戏是否处于开始状态
        if (isStart && snake.isLive()) {
//            吃到食物
            if (snake.getSnakeX()[0] == foodX && snake.getSnakeY()[0] == foodY) {
//                小蛇增加一节
                snake.grow();
//                重新生成新的食物坐标
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);
            }
//            控制小蛇的身体移动

            for (int i = snake.getLength() - 1; i > 0; i--) {
                snake.getSnakeX()[i] = snake.getSnakeX()[i - 1];
                snake.getSnakeY()[i] = snake.getSnakeY()[i - 1];
            }

            if (snake.getDirection().equals("R")) {
                snake.getSnakeX()[0] = snake.getSnakeX()[0] + 25;
                if (snake.getSnakeX()[0] > 850) {
                    snake.getSnakeX()[0] = 25;
                }
            } else if (snake.getDirection().equals("L")) {
                snake.getSnakeX()[0] = snake.getSnakeX()[0] - 25;
                if (snake.getSnakeX()[0] <0) {
                    snake.getSnakeX()[0] = 850;
                }
            } else if (snake.getDirection().equals("U")) {
                snake.getSnakeY()[0] = snake.getSnakeY()[0] - 25;
                if (snake.getSnakeY()[0] < 75) {
                    snake.getSnakeY()[0] = 650;
                }
            } else if (snake.getDirection().equals("D")) {
                snake.getSnakeY()[0] = snake.getSnakeY()[0] + 25;
                if (snake.getSnakeY()[0] > 650) {
                    snake.getSnakeY()[0] = 75;
                }
            }
//            失败判定 撞到自己就失败
            for (int i = 1; i < snake.getLength(); i++) {
                if (snake.getSnakeX()[i] == snake.getSnakeX()[0] && snake.getSnakeY()[i] == snake.getSnakeY()[0]) {
                    snake.setLiveState(false);
                }
            }

        }
        repaint();
    }

}
