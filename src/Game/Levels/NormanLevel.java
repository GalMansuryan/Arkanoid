package  Game.Levels;
import Shapes.GameItems.Block;
import Shapes.Absract.Rectangle;
import Shapes.Absract.Point;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NormanLevel {
    private List<Block> blocks;

    public NormanLevel() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:/Users/GalMansuryan/Desktop/ass6/src/Norman.png"));
        } catch (IOException e) {
            System.out.println("Image could not be read.");
            System.exit(1);
        }

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                Rectangle rectangle = new Rectangle(new Point(x, y), 1, 1,
                        new Color(red, green, blue), 'b');
                blocks.add(new Block(rectangle));
            }
        }
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
