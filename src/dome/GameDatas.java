package dome;

import javax.swing.*;
import java.net.URL;

/**
 * @program: snake
 * @description: 游戏数据
 * @author: stone
 * @create: 2021-01-12 13:31
 **/
public class GameDatas {
    public static URL bodyUrl = GameDatas.class.getResource("statics/body.png");
    public static URL foodUrl = GameDatas.class.getResource("statics/food.png");
    public static URL leftUrl = GameDatas.class.getResource("statics/left.png");
    public static URL rightUrl = GameDatas.class.getResource("statics/right.png");
    public static URL upUrl = GameDatas.class.getResource("statics/up.png");
    public static URL downUrl = GameDatas.class.getResource("statics/down.png");


    public static ImageIcon iconBody = new ImageIcon(bodyUrl);
    public static ImageIcon iconFood = new ImageIcon(foodUrl);
    public static ImageIcon iconLfet = new ImageIcon(leftUrl);
    public static ImageIcon iconRight = new ImageIcon(rightUrl);
    public static ImageIcon iconUp = new ImageIcon(upUrl);
    public static ImageIcon iconDown = new ImageIcon(downUrl);

}
