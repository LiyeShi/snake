package dome;

import javax.swing.*;

/**
 * @program: snake
 * @description: 游戏主启动类
 * @author: stone
 * @create: 2021-01-12 13:26
 **/
public class StartGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(10,10,900,720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.add(new GamePanel());
    }
}
