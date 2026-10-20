/*
 * =====================================================
 *  JAVA APPLET PROGRAM - Basic Drawing Example
 *  Subject: Java Programming (M.Tech)
 * =====================================================
 *
 *  THEORY (Exam ke liye):
 *  ----------------------
 *  Java Applet ek small Java program hota hai jo web browser
 *  ya appletviewer mein run hota hai. Ye java.applet.Applet
 *  class ko extend karta hai aur HTML page mein embed hota hai.
 *
 *  Applet Life Cycle Methods (5 important methods):
 *    1. init()    - Applet initialize hone par sirf ek baar call hota hai
 *    2. start()   - Applet start ya restart hone par call hota hai
 *    3. paint()   - Screen par kuch display/draw karne ke liye call hota hai
 *    4. stop()    - Applet tab stop hota hai jab user page se door jata hai
 *    5. destroy() - Applet completely end hone par call hota hai
 *
 *  Graphics class ke common methods:
 *    - drawString(String, x, y)  -> text display karta hai
 *    - drawLine(x1, y1, x2, y2) -> do points ke beech line draw karta hai
 *    - drawRect(x, y, w, h)     -> rectangle draw karta hai
 *    - drawOval(x, y, w, h)     -> oval ya circle draw karta hai
 *    - fillRect(x, y, w, h)     -> filled rectangle draw karta hai
 *    - fillOval(x, y, w, h)     -> filled oval draw karta hai
 *    - setColor(Color.RED)      -> drawing color set karta hai
 */

// Step 1: Applet class import karo - Applet banane ke liye jaruri
import java.applet.Applet;

// Step 2: Graphics class import karo - drawing/painting ke liye jaruri
import java.awt.Graphics;

/*
 * HTML Applet Tag (appletviewer ke liye source file mein comment likhte hain):
 * <applet code="App.class" width="300" height="300"></applet>
 *
 * code   = compiled .class file ka naam
 * width  = applet window ki width pixels mein
 * height = applet window ki height pixels mein
 */

// Step 3: Public class banao jo Applet ko extend kare
// "extends Applet" ka matlab hai ki App class ko Applet ke saare features milenge
public class App extends Applet {

    /*
     * paint(Graphics g) Method:
     * -------------------------
     * - Ye method applet ki window par kuch bhi display karne ke liye use hota hai.
     * - Jab bhi applet ko repaint karna ho ye automatically call hota hai.
     * - Graphics object 'g' ek drawing tool hai jisse hum shapes aur text draw karte hain.
     * - @Override batata hai ki ye parent class Applet ke paint() method ko override kar raha hai.
     */
    @Override
    public void paint(Graphics g) {

        // drawString(text, x, y):
        //   "Hello from Applet" text ko x=100, y=100 position par display karta hai.
        //   x = left edge se horizontal distance (pixels)
        //   y = top edge se vertical distance (pixels)
        g.drawString("Hello from Applet", 100, 100);

        // drawLine(x1, y1, x2, y2):
        //   Point (20, 20) se Point (180, 180) tak ek straight line draw karta hai.
        //   Ye ek diagonal line hogi - top-left corner se bottom-right corner ki taraf.
        g.drawLine(20, 20, 180, 180);
    }
}
