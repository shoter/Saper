
package mines.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import mines.commons.Constans;

/**
 * Klasa obsługuje ładowanie grafik twarzy
 * @author wojciech
 */
public class ImgFacesLoader {
    /** Zmienna przechowuje grafiki twarzy */
    final private Image[] images;

    public ImgFacesLoader() {
        images = new Image[Constans.NUMB_OF_FACES];
        load();
    }

    /** 
     * Zwraca twarz o zadanycm indeksie 
     * @param ind indeks twwarzy
     * @return grafika
     */
    public Image getImage(final int ind) {
        return images[ind];
    }

    private void load() {
        images[0] = new ImageIcon(this.getClass().getResource("face/0.png")).getImage();
        images[1] = new ImageIcon(this.getClass().getResource("face/1.png")).getImage();
        images[2] = new ImageIcon(this.getClass().getResource("face/2.png")).getImage();
        images[3] = new ImageIcon(this.getClass().getResource("face/3.png")).getImage();
        images[4] = new ImageIcon(this.getClass().getResource("face/4.png")).getImage();
        images[5] = new ImageIcon(this.getClass().getResource("face/5.png")).getImage();
        images[6] = new ImageIcon(this.getClass().getResource("face/6.png")).getImage();
        images[7] = new ImageIcon(this.getClass().getResource("face/7.png")).getImage();
    }
}
