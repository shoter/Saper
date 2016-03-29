
package mines.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import mines.commons.Constans;

/**
 * Klasa obsługuje ładowanie gafik pol min
 * @author wojciech
 */
public class ImgFieldLoader {
        final private Image[] images;

    public ImgFieldLoader() {
        images = new Image[Constans.NUMB_OF_IMAGES];
        load();
    }

    public Image getImage(final int ind) {
        return images[ind];
    }

    private void load() {
        images[0] = new ImageIcon(this.getClass().getResource("img/0.png")).getImage();
        images[1] = new ImageIcon(this.getClass().getResource("img/1.png")).getImage();
        images[2] = new ImageIcon(this.getClass().getResource("img/2.png")).getImage();
        images[3] = new ImageIcon(this.getClass().getResource("img/3.png")).getImage();
        images[4] = new ImageIcon(this.getClass().getResource("img/4.png")).getImage();
        images[5] = new ImageIcon(this.getClass().getResource("img/5.png")).getImage();
        images[6] = new ImageIcon(this.getClass().getResource("img/6.png")).getImage();
        images[7] = new ImageIcon(this.getClass().getResource("img/7.png")).getImage();
        images[8] = new ImageIcon(this.getClass().getResource("img/8.png")).getImage();
        images[9] = new ImageIcon(this.getClass().getResource("img/9.png")).getImage();
        images[10] = new ImageIcon(this.getClass().getResource("img/10.png")).getImage();
        images[11] = new ImageIcon(this.getClass().getResource("img/11.png")).getImage();
        images[12] = new ImageIcon(this.getClass().getResource("img/12.png")).getImage();
    }
}
