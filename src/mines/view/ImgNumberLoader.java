
package mines.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import mines.commons.Constans;

/**
 *
 * @author wojciech
 */
public class ImgNumberLoader {
    final private Image[] images;

    public ImgNumberLoader() {
        images = new Image[Constans.NUMB_OF_NUMBERS];
        load();
    }

    public Image getImage(final int ind) {
        return images[ind];
    }

    private void load() {
        images[0] = new ImageIcon(this.getClass().getResource("numbers/0.png")).getImage();
        images[1] = new ImageIcon(this.getClass().getResource("numbers/1.png")).getImage();
        images[2] = new ImageIcon(this.getClass().getResource("numbers/2.png")).getImage();
        images[3] = new ImageIcon(this.getClass().getResource("numbers/3.png")).getImage();
        images[4] = new ImageIcon(this.getClass().getResource("numbers/4.png")).getImage();
        images[5] = new ImageIcon(this.getClass().getResource("numbers/5.png")).getImage();
        images[6] = new ImageIcon(this.getClass().getResource("numbers/6.png")).getImage();
        images[7] = new ImageIcon(this.getClass().getResource("numbers/7.png")).getImage();
        images[8] = new ImageIcon(this.getClass().getResource("numbers/8.png")).getImage();
        images[9] = new ImageIcon(this.getClass().getResource("numbers/9.png")).getImage();
        images[10] = new ImageIcon(this.getClass().getResource("numbers/10.png")).getImage();
    }
}
