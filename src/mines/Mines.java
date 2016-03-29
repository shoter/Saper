package mines;

import java.util.logging.Level;
import java.util.logging.Logger;
import mines.controller.Controller;
import mines.model.Model;
import mines.view.View;

public class Mines {

    public static void main(String[] args) {

        try {
            Model m = new Model();
            View v = new View();
            v.setVisible(true);
            Controller c = new Controller(m, v);
            
        } catch (Exception ex) {
            Logger.getLogger(Mines.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
