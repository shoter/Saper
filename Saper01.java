
package saper01;

import java.util.logging.Level;
import java.util.logging.Logger;
import saper01.controller.Controller;
import saper01.model.Model;
import saper01.view.View;

/**
 *
 * @author wojciech
 */
public class Saper01 {


    public static void main(String[] args) {
        
        try {
            Model m=new Model();
            View v=new View();
            Controller c=new Controller(m,v);
            v.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Saper01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
